package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.PersonExperiencesAddDto;
import kodlamaio.hrms.entities.dtos.PersonExperiencesGetDto;

public interface PersonExperiencesService {
	DataResult<List<PersonExperiencesGetDto>> getExperiences();
	List<Result> addExperiences(PersonExperiencesAddDto personExperiencesAddDto);

}
