package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PersonActivationCodesService;

import kodlamaio.hrms.core.loggers.concretes.LoggerManager;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PersonActivationCodeDao;
import kodlamaio.hrms.dataAccess.abstracts.PersonDao;

import kodlamaio.hrms.entities.concretes.PersonActivationCodes;


@Service
public class PersonActivationCodesManager implements PersonActivationCodesService {
	private PersonActivationCodeDao personActivationCodeDao;
	private PersonDao personDao;

	private LoggerManager loggerManager;
	@Override
	public DataResult<List<PersonActivationCodes>> getAll(){
		return new SuccessDataResult<List<PersonActivationCodes>>(this.personActivationCodeDao.findAll(),"Data Listelendi");
	}
	@Autowired
	public PersonActivationCodesManager(PersonActivationCodeDao personActivationCodeDao,PersonDao personDao) {
		this.loggerManager=new LoggerManager();
		this.personActivationCodeDao=personActivationCodeDao;
		this.personDao=personDao;
	}
	@Override
	public Result activate(PersonActivationCodes personActivationCodes) {
		if(checkActivationCode(personActivationCodes)) {
			
			this.personDao.activatePerson(personActivationCodes.getPerson_id());
			
			return new SuccessResult("Aktivasyon Gerçekleştirildi");
		}
		return new ErrorResult("Hatalı Doğrulama Kodu");
	}
	private boolean checkActivationCode(PersonActivationCodes personActivationCodes) {
		if(this.personActivationCodeDao.checkActivationCode(personActivationCodes.getPerson_id(),personActivationCodes.getActivation_code()).isEmpty()) {
			return false;
		}
		return true;
	}
	
}
