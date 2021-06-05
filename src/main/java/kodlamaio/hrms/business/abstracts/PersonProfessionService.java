package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.PersonProfessionAddDto;
import kodlamaio.hrms.entities.dtos.PersonProfessionGetDto;
public interface PersonProfessionService {
	DataResult<List<PersonProfessionGetDto>> getProfession();
	List<Result> addProfession(PersonProfessionAddDto personProfessionAddDto);
}
