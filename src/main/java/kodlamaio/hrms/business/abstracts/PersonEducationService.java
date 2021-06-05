package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.dtos.PersonEducationAddDto;
import kodlamaio.hrms.entities.dtos.PersonEducationGetDto;

public interface PersonEducationService {
	DataResult<List<PersonEducationGetDto>> getEducation();
	List<Result> addEducation( PersonEducationAddDto personEducationAddDto);

}
