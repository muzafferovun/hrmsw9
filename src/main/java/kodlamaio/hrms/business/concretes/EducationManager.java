package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CountrieCitysDao;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.dataAccess.abstracts.EducationTypeDao;
import kodlamaio.hrms.entities.concretes.CountrieCitys;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.EducationType;
import kodlamaio.hrms.entities.dtos.EducationAddDto;
import kodlamaio.hrms.entities.dtos.EducationListDto;
@Service
public class EducationManager implements EducationService {
	private EducationTypeDao educationTypeDao;
	private EducationDao educationDao;
	private CountrieCitysDao countrieCitysDao;

	@Autowired
	public EducationManager(EducationDao educationDao,EducationTypeDao educationTypeDao,CountrieCitysDao countrieCitysDao) {
		this.educationDao=educationDao;
		this.educationTypeDao=educationTypeDao;
		this.countrieCitysDao=countrieCitysDao;
	}	
	@Override
	public DataResult<List<EducationListDto>> getAll() {
		return new SuccessDataResult<List<EducationListDto>>(educationDao.getAllEducationListDto(),"Eğitim Enstitüleri listelendi");
	}

	@Override
	public List<Result> add(EducationAddDto educationAddDto) {
		AllDataResult allDataResult=new AllDataResult();
		allDataResult=checkAdd(educationAddDto);
		if(!allDataResult.isSuccess()) {
			allDataResult.addResult(new ErrorResult("Error"));
			return allDataResult.getErrorResults();
		}
		Education education=new Education();
		education.setCity(this.countrieCitysDao.findById(educationAddDto.getCity()).get());
		education.setEducationType(this.educationTypeDao.findById(educationAddDto.getEducationType()).get());
		education.setInfo(educationAddDto.getInfo());
		education.setLogo(educationAddDto.getLogo());
		education.setName(educationAddDto.getName());
		education.setWebsite(educationAddDto.getWebsite());
		educationDao.save(education);
		allDataResult.addResult(new SuccessResult("Kayıt İşlemi gerçekleştirildi"));
		return allDataResult.getSuccessResults();
	}
	private AllDataResult checkAdd(EducationAddDto educationAddDto) {
		AllDataResult allDataResult=new AllDataResult();
		if(educationAddDto.getName().isBlank()) {
			allDataResult.addResult(new ErrorResult("name is empty"));
		}
		if(!this.educationDao.findByName(educationAddDto.getName().toString()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("Education name is already registered"));
		}
		if(this.educationTypeDao.findById(educationAddDto.getEducationType()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("Education Type is not found"));
		}
		if(this.countrieCitysDao.findById(educationAddDto.getCity()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("Education city is not found"));
		}
		
		
		
		return allDataResult;
	}

}
