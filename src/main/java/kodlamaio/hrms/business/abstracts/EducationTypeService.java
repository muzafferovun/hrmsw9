package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EducationType;
import kodlamaio.hrms.entities.dtos.EducationTypeAddDto;

public interface EducationTypeService {
	DataResult<List<EducationType>>  getAllEducationTypes();
	List<Result> addEducationType(EducationTypeAddDto educationTypeAddDto);

}
