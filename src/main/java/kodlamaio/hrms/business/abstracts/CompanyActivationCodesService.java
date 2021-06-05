package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CompanyActivationCodes;


public interface CompanyActivationCodesService {
	Result activate(CompanyActivationCodes companyActivationCodes);

}
