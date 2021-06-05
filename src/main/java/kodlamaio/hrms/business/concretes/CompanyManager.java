package kodlamaio.hrms.business.concretes;

import java.util.List;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.loggers.concretes.LoggerManager;
import kodlamaio.hrms.core.loggers.concretes.Utils;
import kodlamaio.hrms.core.methods.GlobalMethods;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CompanyActivationCodeDao;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Company;
import kodlamaio.hrms.entities.concretes.CompanyActivationCodes;
import kodlamaio.hrms.entities.concretes.CompanyUser;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.User;



@Service
public class CompanyManager implements CompanyService {
	private CompanyDao companyDao;
	private UserDao userDao;
	private CompanyActivationCodeDao companyActivationCodeDao;
	private JobPositionDao jobPositionDao;
	private LoggerManager loggerManager;
	@Override
	public DataResult<List<Company>> getAll(){
		Utils.RunLoggers(loggerManager.log("Company")," company tablosu listelendi");		
		return new SuccessDataResult<List<Company>>(this.companyDao.findAll(),"Data Listelendi");
	}
	@Autowired
	public CompanyManager(CompanyDao companyDao,UserDao userDao,CompanyActivationCodeDao companyActivationCodeDao,JobPositionDao jobPositionDao) {
		this.loggerManager=new LoggerManager();
		this.companyDao=companyDao;
		this.userDao=userDao;
		this.jobPositionDao=jobPositionDao;
		this.companyActivationCodeDao=companyActivationCodeDao;
	}
	@Override
	public List<Result> add(CompanyUser companyUser) {
		AllDataResult alldataResult=checkCompany(companyUser);
		if(!alldataResult.isSuccess()) {
			alldataResult.addResult(new ErrorResult("Company kaydı gerçekleştirilmedi"));
			return alldataResult.getErrorResults();
		}
		
		
		User user=new User();
		user.setEmail(companyUser.getEmail());
		user.setPassword(companyUser.getEmail());
		user.setStatus(true);
		this.userDao.save(user);
		alldataResult.addResult(new SuccessResult("user tablo kaydı gerşekleştirildi"));
		Company company=new Company();
		company.setUser_id(user.getId());
		company.setCompany_email(companyUser.getCompany_email());
		company.setCompany_name(companyUser.getCompany_name());
		company.setIs_verify(false);
		company.setPhone(companyUser.getPhone());
		company.setWebsite(companyUser.getWebsite());
		company.setIs_activate(false);
		company.setCompany_city(Integer.parseInt(companyUser.getCompany_city()));
		this.companyDao.save(company);
		alldataResult.addResult(new SuccessResult("company tablo kaydı gerşekleştirildi"));
		
		CompanyActivationCodes companyActivationCodes=new CompanyActivationCodes();
		companyActivationCodes.setCompany_id(company.getId());
		companyActivationCodes.setActivation_code(GlobalMethods.passwordGenerator(50));
		companyActivationCodeDao.save(companyActivationCodes);
		alldataResult.addResult(new SuccessResult("activationCode tablo kaydı gerşekleştirildi"));
		
//		this.companyDao.save(company);
//		Utils.RunLoggers(loggerManager.log("Company"),company.getCompany_name()+" Company tablosuna eklendi");		
		return alldataResult.getSuccessResults();
	}
	private AllDataResult checkCompany(CompanyUser companyUser) {
		AllDataResult allDataResult=new AllDataResult();
		if(companyUser.getPhone().length()<10) {
			allDataResult.addResult(new ErrorResult("Telefon numarası Hatalı"));
		}
		if(!this.userDao.findEmail(companyUser.getEmail()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("Email Adresi Sistemde Kayıtlı"));
		}
		if(companyUser.getPassword().length()<4|!companyUser.getPassword().equals(companyUser.getRepassword())) {
			allDataResult.addResult(new ErrorResult("Şifreler Uyuşmuyor veya 4 haneden küçük"));
		}
		
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		if(Pattern.matches(regex, companyUser.getEmail())==false){
			allDataResult.addResult(new ErrorResult("Email adresi uygun Email formatında değil"));
		}
		String[] emailpart= companyUser.getEmail().split("@");
		String[] websitepart=companyUser.getWebsite().split("www.");
		if(emailpart.length<2) {
			allDataResult.addResult(new ErrorResult("Email adresi uygun Email formatında değil"));
		}
		if(websitepart.length<2) {
			allDataResult.addResult(new ErrorResult("web sitesi uygun formatta değil.Örn :(www.gmail.com)"));
		}

		if(emailpart.length>1&&websitepart.length>1) {
			if(websitepart[1].length()<1) {
				allDataResult.addResult(new ErrorResult("web sitesi uygun formatta değil.Örn :(www.gmail.com)"));
			}
			if(!emailpart[1].equals(websitepart[1]) ) {
				allDataResult.addResult(new ErrorResult("Email adresi şirket web adresine ait değil"));
			}
		}
		
		return allDataResult;
	}
	@Override
	public Result closeJobPosition(int jobPositionId) {
		
		
		if(this.jobPositionDao.findjobPositionId(jobPositionId).isEmpty()) {
			return new ErrorResult("jobPositionId ye ait kayıt bulunamadı");
		}
		this.jobPositionDao.unActivateJobPosition(jobPositionId);
		
		return new SuccessResult("JopPosition is pasive");
	}
	@Override
	public Result openJobPosition(int jobPositionId) {
		
		
		if(this.jobPositionDao.findjobPositionId(jobPositionId).isEmpty()) {
			return new ErrorResult("jobPositionId ye ait kayıt bulunamadı");
		}
		this.jobPositionDao.activateJobPosition(jobPositionId);
		
		return new SuccessResult("JopPosition is Active");
	}
	@Override
	public DataResult<Company> getByCompanyName(String companyName) {
		Company company=new Company();
		company=this.companyDao.getByCompanyName(companyName);
		if(company==null) {
			return new SuccessDataResult<Company>(company,"company is found");
		}
		return new ErrorDataResult<Company>(company,"company is not found");
	}
}
