package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.PersonEducationService;
import kodlamaio.hrms.business.abstracts.PersonExperiencesService;
import kodlamaio.hrms.business.abstracts.PersonProfessionService;
import kodlamaio.hrms.business.abstracts.PersonService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Person;
import kodlamaio.hrms.entities.concretes.PersonProfession;
import kodlamaio.hrms.entities.concretes.PersonUser;
import kodlamaio.hrms.entities.concretes.SectorPosition;
import kodlamaio.hrms.entities.dtos.PersonEducationAddDto;
import kodlamaio.hrms.entities.dtos.PersonEducationGetDto;
import kodlamaio.hrms.entities.dtos.PersonExperiencesAddDto;
import kodlamaio.hrms.entities.dtos.PersonExperiencesGetDto;
import kodlamaio.hrms.entities.dtos.PersonProfessionAddDto;
import kodlamaio.hrms.entities.dtos.PersonProfessionGetDto;



@RestController
@RequestMapping("/api/person")
public class PersonController {
	private PersonService personService;
	private PersonExperiencesService personExperiencesService;
	private PersonProfessionService personProfessionService;
	private PersonEducationService personEducationService;
	@Autowired
	public PersonController(PersonService personService,PersonExperiencesService personExperiencesService,PersonProfessionService personProfessionService
			,PersonEducationService personEducationService) {
		super();
		this.personService=personService;
		this.personExperiencesService=personExperiencesService;
		this.personProfessionService=personProfessionService;
		this.personEducationService=personEducationService;
	}
	@GetMapping("/getall")
	public DataResult<List<Person>> getAll(){
		return this.personService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody PersonUser personUser) {
		return this.personService.add(personUser);
	}
	@GetMapping("/getExperiences")
	public DataResult<List<PersonExperiencesGetDto>> getExperiences(){
		return this.personExperiencesService.getExperiences();
	}
	
	@PostMapping("/addExperiences")
	public List<Result> addExperiences(@RequestBody PersonExperiencesAddDto personExperiencesAddDto) {
		return this.personExperiencesService.addExperiences(personExperiencesAddDto);
	}
	@GetMapping("/getProfession")
	public DataResult<List<PersonProfessionGetDto>> getProfession(){
		return this.personProfessionService.getProfession();
	}
	
	@PostMapping("/addProfession")
	public List<Result> addProfession(@RequestBody PersonProfessionAddDto personProfessionAddDto) {
		return this.personProfessionService.addProfession(personProfessionAddDto);
	}
	@GetMapping("/getEducation")
	public DataResult<List<PersonEducationGetDto>> getEducation(){
	//	return this.personEducationService.getEducation();
		return null;
	}
	
	@PostMapping("/addEducation")
	public List<Result> addEducation(@RequestBody PersonEducationAddDto personEducationAddDto) {
		return this.personEducationService.addEducation(personEducationAddDto);
	}
	
	
}
