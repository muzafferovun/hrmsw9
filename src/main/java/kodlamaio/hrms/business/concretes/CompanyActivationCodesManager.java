package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanyActivationCodesService;

import kodlamaio.hrms.core.loggers.concretes.LoggerManager;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CompanyActivationCodeDao;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;


import kodlamaio.hrms.entities.concretes.CompanyActivationCodes;



@Service
public class CompanyActivationCodesManager implements CompanyActivationCodesService {
	private CompanyActivationCodeDao companyActivationCodeDao;
	private CompanyDao companyDao;

	private LoggerManager loggerManager;
	@Autowired
	public CompanyActivationCodesManager(CompanyActivationCodeDao companyActivationCodeDao,CompanyDao companyDao) {
		this.loggerManager=new LoggerManager();
		this.companyActivationCodeDao=companyActivationCodeDao;
		this.companyDao=companyDao;
	}
	@Override
	public Result activate(CompanyActivationCodes companyActivationCodes) {
		if(checkActivationCode(companyActivationCodes)) {
			
			this.companyDao.activateCompany(companyActivationCodes.getCompany_id());
			
			return new SuccessResult("Aktivasyon Gerçekleştirildi");
		}
		return new ErrorResult("Hatalı Doğrulama Kodu");
	}
	private boolean checkActivationCode(CompanyActivationCodes companyActivationCodes) {
		if(this.companyActivationCodeDao.checkActivationCode(companyActivationCodes.getCompany_id(),companyActivationCodes.getActivation_code()).isEmpty()) {
			return false;
		}
		return true;
	}
	
}
