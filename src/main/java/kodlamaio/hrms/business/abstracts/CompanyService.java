package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Company;
import kodlamaio.hrms.entities.concretes.CompanyUser;



public interface CompanyService {
	DataResult<List<Company>>  getAll();
	List<Result> add(CompanyUser companyUser);
	Result closeJobPosition( int jobPositionId);
	Result openJobPosition( int jobPositionId);
    DataResult<Company> getByCompanyName(String companyName);

}
