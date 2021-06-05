package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CountrieCitys;


public interface CountrieCitysService {
	DataResult<List<CountrieCitys>>  getAll();
	Result add(CountrieCitys countrieCitys);

}
