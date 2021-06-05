package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PersonCvService;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PersonCvDao;
import kodlamaio.hrms.dataAccess.abstracts.PersonCvEducationDao;
import kodlamaio.hrms.dataAccess.abstracts.PersonCvProfessionDao;
import kodlamaio.hrms.dataAccess.abstracts.PersonDao;
import kodlamaio.hrms.dataAccess.abstracts.PersonEducationDao;
import kodlamaio.hrms.dataAccess.abstracts.PersonProfessionDao;

import kodlamaio.hrms.entities.concretes.PersonCv;
import kodlamaio.hrms.entities.concretes.PersonCvEducation;
import kodlamaio.hrms.entities.concretes.PersonCvProfession;

import kodlamaio.hrms.entities.dtos.PersonCvAddDto;
import kodlamaio.hrms.entities.dtos.PersonCvEducationAddDto;
import kodlamaio.hrms.entities.dtos.PersonCvEducationGetDto;
import kodlamaio.hrms.entities.dtos.PersonCvGetDto;
import kodlamaio.hrms.entities.dtos.PersonCvProfessionAddDto;
import kodlamaio.hrms.entities.dtos.PersonCvProfessionGetDto;
@Service
public class PersonCvManager implements PersonCvService {
	private PersonCvDao personCvDao;
	private PersonDao personDao;
	private PersonProfessionDao personProfessionDao;
	private PersonCvProfessionDao personCvProfessionDao;
	private PersonCvEducationDao personCvEducationDao;
	private PersonEducationDao personEducationDao;
	@Autowired
	PersonCvManager(PersonCvDao personCvDao,PersonDao personDao
			,PersonProfessionDao personProfessionDao,PersonCvProfessionDao personCvProfessionDao
			,PersonCvEducationDao personCvEducationDao,PersonEducationDao personEducationDao){
		this.personCvDao=personCvDao;
		this.personDao=personDao;
		this.personProfessionDao=personProfessionDao;
		this.personCvProfessionDao=personCvProfessionDao;
		this.personCvEducationDao=personCvEducationDao;
	}
	@Override
	public DataResult<List<PersonCvGetDto>> getAll() {
		return new SuccessDataResult<List<PersonCvGetDto>>(personCvDao.getAllCv(),"Eğitim Enstitüleri listelendi");
		
	}

	@Override
	public List<Result> addCv(PersonCvAddDto personCvAddDto) {
		AllDataResult allDataResult=new AllDataResult();
		allDataResult=checkAdd(personCvAddDto);
		if(!allDataResult.isSuccess()) {
			allDataResult.addResult(new ErrorResult("Error"));
			return allDataResult.getErrorResults();
		}
		PersonCv personCv=new PersonCv();
		personCv.setCvCaption(personCvAddDto.getCvCaption());
		personCv.setCvContent(personCvAddDto.getCvContent());
		personCv.setPerson(this.personDao.findById(personCvAddDto.getPerson()).get());
		personCvDao.save(personCv);
		allDataResult.addResult(new SuccessResult("Cv Saved!!"));
		return allDataResult.getSuccessResults();
	}
	private AllDataResult checkAdd(PersonCvAddDto personCvAddDto) {
		AllDataResult allDataResult=new AllDataResult();
		if(personCvAddDto.getCvCaption().isBlank()) {
			allDataResult.addResult(new ErrorResult("cv Caption is blank"));
		}
		if(!this.personCvDao.findByCvCaption(personCvAddDto.getCvCaption()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("Education name is already registered"));
		}
		if(personCvAddDto.getCvContent().isBlank()) {
			allDataResult.addResult(new ErrorResult("cv content is blank"));
		}
		if(this.personDao.findById(personCvAddDto.getPerson()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("person not found"));
			
		}
		return allDataResult;
	}
	@Override
	public DataResult<List<PersonCvProfessionGetDto>> getCvProfessions(int personCvId) {
	//	return new SuccessDataResult<List<PersonCvProfessionGetDto>>(personCvProfessionDao.getAllPersonCvProfessionGetDto(personCvId),"Cv professions listed");
		return null;
	}
	@Override
	public List<Result> addCvProfession(PersonCvProfessionAddDto personCvProfessionAddDto) {
		AllDataResult allDataResult=new AllDataResult();
		allDataResult=checkaddCvProfession(personCvProfessionAddDto);
		if(!allDataResult.isSuccess()) {
			allDataResult.addResult(new ErrorResult("Error"));
			return allDataResult.getErrorResults();
		}
		PersonCvProfession personCvProfession=new PersonCvProfession();
		personCvProfession.setPersonCv(this.personCvDao.findById(personCvProfessionAddDto.getPersonCv()).get());
//		personCvProfession.set(this.personProfessionDao.findById(personCvProfessionAddDto.getPersonProfession()).get());
		this.personCvProfessionDao.save(personCvProfession);
		allDataResult.addResult(new SuccessResult("Cv Saved!!"));
		return allDataResult.getSuccessResults();
	}
	private AllDataResult checkaddCvProfession(PersonCvProfessionAddDto personCvProfessionAddDto) {
		AllDataResult allDataResult=new AllDataResult();
		if(this.personCvDao.findById(personCvProfessionAddDto.getPersonCv()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("un defined person_cv"));
		}
		if(this.personProfessionDao.findById(personCvProfessionAddDto.getPersonProfession()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("un defined person_profession"));
		}
		return allDataResult;
	}
	@Override
	public DataResult<List<PersonCvEducationGetDto>> getCvEducation(int educationCvId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Result> addCvEducation(PersonCvEducationAddDto personCvEducationAddDto) {
		AllDataResult allDataResult=new AllDataResult();
		allDataResult=checkaddCvEducation(personCvEducationAddDto);
		if(!allDataResult.isSuccess()) {
			allDataResult.addResult(new ErrorResult("Error"));
			return allDataResult.getErrorResults();
		}
		PersonCvEducation personCvEducation=new PersonCvEducation();
		personCvEducation.setPersonCv(this.personCvDao.findById(personCvEducationAddDto.getPersonCv()).get());
		personCvEducation.setPersonEducation(this.personEducationDao.findById(personCvEducationAddDto.getPersonEducation()).get());
//		personCvProfession.set(this.personProfessionDao.findById(personCvProfessionAddDto.getPersonProfession()).get());
		this.personCvEducationDao.save(personCvEducation);
		allDataResult.addResult(new SuccessResult("Cv Saved!!"));
		return allDataResult.getSuccessResults();
	}
	private AllDataResult checkaddCvEducation(PersonCvEducationAddDto personCvEducationAddDto) {
		AllDataResult allDataResult=new AllDataResult();
		if(this.personCvDao.findById(personCvEducationAddDto.getPersonCv()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("un defined person_cv"));
		}
		if(this.personCvEducationDao.findById(personCvEducationAddDto.getPersonEducation()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("un defined person education"));
		}
		return allDataResult;
	}

}
