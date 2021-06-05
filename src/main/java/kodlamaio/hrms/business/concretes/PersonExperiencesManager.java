package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.PersonExperiencesService;

import kodlamaio.hrms.core.methods.GlobalMethods;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.dataAccess.abstracts.PersonDao;
import kodlamaio.hrms.dataAccess.abstracts.PersonExperiencesDao;
import kodlamaio.hrms.dataAccess.abstracts.SectorPositionDao;
import kodlamaio.hrms.dataAccess.abstracts.SectorProfessionDao;
import kodlamaio.hrms.entities.concretes.PersonExperiences;

import kodlamaio.hrms.entities.dtos.PersonExperiencesAddDto;
import kodlamaio.hrms.entities.dtos.PersonExperiencesGetDto;

@Service
public class PersonExperiencesManager implements PersonExperiencesService {
	private PersonExperiencesDao personExperiencesDao;
	private PersonDao personDao;
	private SectorProfessionDao sectorProfessionDao;
	private SectorPositionDao sectorPositionDao;
	private CompanyDao companyDao;
	@Autowired
	PersonExperiencesManager(PersonExperiencesDao personExperiencesDao,PersonDao personDao,SectorProfessionDao sectorProfessionDao,CompanyDao companyDao,SectorPositionDao sectorPositionDao){
		this.personExperiencesDao=personExperiencesDao;
		this.personDao=personDao;
		this.sectorProfessionDao=sectorProfessionDao;
		this.companyDao=companyDao;
		this.sectorPositionDao=sectorPositionDao;
	}
	
	@Override
	public DataResult<List<PersonExperiencesGetDto>> getExperiences() {

		return new SuccessDataResult<List<PersonExperiencesGetDto>>(personExperiencesDao.getPersonExperiences(),"experiences listed");
	
	}


	@Override
	public List<Result> addExperiences(PersonExperiencesAddDto personExperiencesAddDto) {
		AllDataResult allDataResult=new AllDataResult();
		allDataResult=checkAdd(personExperiencesAddDto);
		if(!allDataResult.isSuccess()) {
			allDataResult.addResult(new ErrorResult("Error"));
			return allDataResult.getErrorResults();
		}
		PersonExperiences personExperiences=new PersonExperiences();
		
		personExperiences.setCompany(companyDao.findById(personExperiencesAddDto.getCompanyId()).get());
		if(!personExperiencesAddDto.getEndDate().isBlank()){
				personExperiences.setEndDate(LocalDate.parse(personExperiencesAddDto.getEndDate()));
		}
		personExperiences.setInfo(personExperiencesAddDto.getInfo());
		personExperiences.setWorking(personExperiencesAddDto.getIsWorking());
		personExperiences.setOtherCompany(personExperiencesAddDto.getOtherCompany());
		if(!personExperiencesAddDto.getStartDate().isBlank()){
			personExperiences.setStartDate(LocalDate.parse(personExperiencesAddDto.getStartDate()));
		}
		personExperiences.setPerson(personDao.findById( personExperiencesAddDto.getPersonId()).get());
		personExperiences.setSectorPosition(sectorPositionDao.findById(personExperiencesAddDto.getPositionId()).get());
		personExperiencesDao.save(personExperiences);
		allDataResult.addResult(new SuccessResult("Kayıt İşlemi gerçekleştirildi"));
		return allDataResult.getSuccessResults();
	}
	private AllDataResult checkAdd(PersonExperiencesAddDto personExperiencesAddDto) {
		AllDataResult allDataResult=new AllDataResult();
		if(!personExperiencesAddDto.getEndDate().isBlank()&&GlobalMethods.checkLocalDate(personExperiencesAddDto.getEndDate().toString())==false) {
			allDataResult.addResult(new ErrorResult("endDate is not in the proper format(yyyy-mm-dd)"));
		}
		if(!personExperiencesAddDto.getStartDate().isBlank()&&GlobalMethods.checkLocalDate(personExperiencesAddDto.getStartDate().toString())==false) {
			allDataResult.addResult(new ErrorResult("startDate is not in the proper format(yyyy-mm-dd)"));
		}
		
		if(this.sectorPositionDao.findById(personExperiencesAddDto.getPositionId()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("Sector Position is not found"));
		}
		if(this.personDao.findById(personExperiencesAddDto.getPersonId()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("Person is not found"));
		}
		return allDataResult;
	}

}
