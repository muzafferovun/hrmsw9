package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationTypeService;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationTypeDao;
import kodlamaio.hrms.entities.concretes.EducationType;
import kodlamaio.hrms.entities.dtos.EducationTypeAddDto;
@Service
public class EducationTypeManager implements EducationTypeService {
	private EducationTypeDao educationTypeDao;
	@Autowired
	public EducationTypeManager(EducationTypeDao educationTypeDao) {
		this.educationTypeDao=educationTypeDao;
	}
	@Override
	public DataResult<List<EducationType>> getAllEducationTypes() {
		
		return new SuccessDataResult<List<EducationType>>(educationTypeDao.findAll(),"Eğitim Türleri listelendi");
	}

	@Override
	public List<Result> addEducationType(EducationTypeAddDto educationTypeAddDto) {
		AllDataResult allDataResult=new AllDataResult();
		if(educationTypeAddDto.getEducationTypeName().isBlank()) {
			allDataResult.addResult(new ErrorResult("EducationTypeName is empty"));
		}
		if(!educationTypeDao.findByEducationTypeName(educationTypeAddDto.getEducationTypeName().toString()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("EducationTypeName is already registered"));
		}
		if(allDataResult.isSuccess()) {
			EducationType educationType=new EducationType();
			educationType.setEducationTypeName(educationTypeAddDto.getEducationTypeName());
			educationTypeDao.save(educationType);
			allDataResult.addResult(new SuccessResult("Successs"));
			return allDataResult.getSuccessResults();
		}
		return allDataResult.getErrorResults();
	}

}
