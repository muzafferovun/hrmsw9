package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Person;
import kodlamaio.hrms.entities.concretes.PersonUser;


public interface PersonService {
	DataResult<List<Person>>  getAll();
	Result add(PersonUser personUser);

}
