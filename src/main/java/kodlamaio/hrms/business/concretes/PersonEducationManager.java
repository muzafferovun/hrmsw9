package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PersonEducationService;
import kodlamaio.hrms.core.loggers.concretes.LoggerManager;
import kodlamaio.hrms.core.methods.GlobalMethods;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.dataAccess.abstracts.PersonActivationCodeDao;
import kodlamaio.hrms.dataAccess.abstracts.PersonDao;
import kodlamaio.hrms.dataAccess.abstracts.PersonEducationDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.PersonEducation;
import kodlamaio.hrms.entities.concretes.PersonExperiences;
import kodlamaio.hrms.entities.dtos.PersonEducationAddDto;
import kodlamaio.hrms.entities.dtos.PersonEducationGetDto;
import kodlamaio.hrms.entities.dtos.PersonExperiencesAddDto;
@Service
public class PersonEducationManager implements PersonEducationService {
	private PersonDao personDao;
	private EducationDao educationDao;
	private PersonEducationDao personeducationDao;
	@Autowired
	public PersonEducationManager(PersonDao personDao,EducationDao educationDao,PersonEducationDao personeducationDao) {
		this.personDao=personDao;
		this.educationDao=educationDao;
		this.personeducationDao=personeducationDao;
	}

	@Override
	public DataResult<List<PersonEducationGetDto>> getEducation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Result> addEducation(PersonEducationAddDto personEducationAddDto) {
		AllDataResult allDataResult=new AllDataResult();
		allDataResult=checkAdd(personEducationAddDto);
		if(!allDataResult.isSuccess()) {
			allDataResult.addResult(new ErrorResult("Error"));
			return allDataResult.getErrorResults();
		}
		PersonEducation personEducation=new PersonEducation();
		if(!personEducationAddDto.getEducationEndDate().isBlank())personEducation.setEducationEndDate(LocalDate.parse(personEducationAddDto.getEducationEndDate()));
		if(!personEducationAddDto.getEducationStartDate().isBlank())personEducation.setEducationStartDate(LocalDate.parse(personEducationAddDto.getEducationStartDate()));
		personEducation.setGraduate(personEducationAddDto.isGraduate());
		personEducation.setEducation(this.educationDao.findById(personEducationAddDto.getEducationId()).get());
		personEducation.setPerson(this.personDao.findById(personEducationAddDto.getPersonId()).get());
		this.personeducationDao.save(personEducation);
		allDataResult.addResult(new SuccessResult("Kayıt İşlemi gerçekleştirildi"));
		return allDataResult.getSuccessResults();
	}
	private AllDataResult checkAdd(PersonEducationAddDto personEducationAddDto) {
		AllDataResult allDataResult=new AllDataResult();
		if(!personEducationAddDto.getEducationEndDate().isBlank()&&GlobalMethods.checkLocalDate(personEducationAddDto.getEducationEndDate())==false) {
			allDataResult.addResult(new ErrorResult("endDate is not in the proper format(yyyy-mm-dd)"));
		}
		if(!personEducationAddDto.getEducationStartDate().isBlank()&&GlobalMethods.checkLocalDate(personEducationAddDto.getEducationStartDate())==false) {
			allDataResult.addResult(new ErrorResult("startDate is not in the proper format(yyyy-mm-dd)"));
		}
		if(personEducationAddDto.getEducationInfo().isBlank()) {
			allDataResult.addResult(new ErrorResult("educationInfo blank"));
		}
		
		if(this.educationDao.findById(personEducationAddDto.getEducationId()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("Sector Position is not found"));
		}
		if(this.personDao.findById(personEducationAddDto.getPersonId()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("Person is not found"));
		}
		return allDataResult;
	}

	

}
