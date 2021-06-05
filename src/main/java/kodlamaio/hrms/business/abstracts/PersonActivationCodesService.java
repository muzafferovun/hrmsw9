package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.PersonActivationCodes;


public interface PersonActivationCodesService {
	DataResult<List<PersonActivationCodes>>  getAll();
	Result activate(PersonActivationCodes personActivationCodes);

}
