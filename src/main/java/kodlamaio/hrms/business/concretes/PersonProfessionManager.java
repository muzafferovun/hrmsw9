package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PersonProfessionService;
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
import kodlamaio.hrms.dataAccess.abstracts.PersonProfessionDao;
import kodlamaio.hrms.dataAccess.abstracts.SectorPositionDao;
import kodlamaio.hrms.dataAccess.abstracts.SectorProfessionDao;
import kodlamaio.hrms.entities.concretes.PersonExperiences;
import kodlamaio.hrms.entities.concretes.PersonProfession;
import kodlamaio.hrms.entities.dtos.PersonExperiencesAddDto;
import kodlamaio.hrms.entities.dtos.PersonExperiencesGetDto;
import kodlamaio.hrms.entities.dtos.PersonProfessionAddDto;
import kodlamaio.hrms.entities.dtos.PersonProfessionGetDto;
@Service
public class PersonProfessionManager implements PersonProfessionService {
	private PersonProfessionDao personProfessionDao;
	private PersonDao personDao;
	private SectorProfessionDao sectorProfessionDao;
	private SectorPositionDao sectorPositionDao;
	private CompanyDao companyDao;
	@Autowired
	PersonProfessionManager(PersonProfessionDao personProfessionDao,PersonDao personDao,SectorProfessionDao sectorProfessionDao,CompanyDao companyDao,SectorPositionDao sectorPositionDao){
		this.personProfessionDao=personProfessionDao;
		this.personDao=personDao;
		this.sectorProfessionDao=sectorProfessionDao;
		this.companyDao=companyDao;
		this.sectorPositionDao=sectorPositionDao;
	}

	@Override
	public DataResult<List<PersonProfessionGetDto>> getProfession() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<PersonProfessionGetDto>>(personProfessionDao.getPersonProfession(),"professions listed");
		
	}

	@Override
	public List<Result> addProfession(PersonProfessionAddDto personProfessionAddDto) {
		AllDataResult allDataResult=new AllDataResult();
		allDataResult=checkAdd(personProfessionAddDto);
		if(!allDataResult.isSuccess()) {
			allDataResult.addResult(new ErrorResult("Error"));
			return allDataResult.getErrorResults();
		}
		PersonProfession personProfession=new PersonProfession();
		personProfession.setContent(personProfessionAddDto.getContent());
		personProfession.setPerson(personDao.findById(personProfessionAddDto.getPersonId()).get());
		personProfession.setSectorProfession(sectorProfessionDao.findById(personProfessionAddDto.getProfessionId()).get());
		personProfessionDao.save(personProfession);
		allDataResult.addResult(new SuccessResult("Kayıt İşlemi gerçekleştirildi"));
		return allDataResult.getSuccessResults();
	}
	private AllDataResult checkAdd(PersonProfessionAddDto personProfessionAddDto) {
		AllDataResult allDataResult=new AllDataResult();
		if(this.sectorProfessionDao.findById(personProfessionAddDto.getProfessionId()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("Sector profession is not found"));
		}
		if(this.personDao.findById(personProfessionAddDto.getPersonId()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("Person is not found"));
		}
		return allDataResult;
	}

}
