package kodlamaio.hrms.business.abstracts;

import java.util.List;



import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.PersonCvAddDto;
import kodlamaio.hrms.entities.dtos.PersonCvEducationAddDto;
import kodlamaio.hrms.entities.dtos.PersonCvEducationGetDto;
import kodlamaio.hrms.entities.dtos.PersonCvGetDto;
import kodlamaio.hrms.entities.dtos.PersonCvProfessionAddDto;
import kodlamaio.hrms.entities.dtos.PersonCvProfessionGetDto;

public interface PersonCvService {
	DataResult<List<PersonCvGetDto>> getAll();
	List<Result> addCv( PersonCvAddDto personCvAddDto);
	DataResult<List<PersonCvProfessionGetDto>> getCvProfessions(int personCvId);
	List<Result> addCvProfession( PersonCvProfessionAddDto personCvProfessionAddDto);
	DataResult<List<PersonCvEducationGetDto>> getCvEducation(int educationCvId);
	List<Result> addCvEducation( PersonCvEducationAddDto personCvEducationAddDto);
	
}
