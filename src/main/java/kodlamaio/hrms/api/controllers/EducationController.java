package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.abstracts.EducationTypeService;
import kodlamaio.hrms.business.abstracts.PersonService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.EducationTypeDao;
import kodlamaio.hrms.entities.concretes.EducationType;
import kodlamaio.hrms.entities.dtos.EducationAddDto;
import kodlamaio.hrms.entities.dtos.EducationListDto;
import kodlamaio.hrms.entities.dtos.EducationTypeAddDto;

@RestController
@RequestMapping("/api/educations")
public class EducationController {
	private EducationService educationService;
	private EducationTypeService educationTypeService;
	@Autowired
	public EducationController(EducationService educationService,EducationTypeService educationTypeService) {
		super();
		this.educationService=educationService;
		this.educationTypeService=educationTypeService;
	}
	@GetMapping("/educationInstitues")
	public DataResult<List<EducationListDto>> getAll(){
		return this.educationService.getAll();
	}
	
	@PostMapping("/addEducationInstitue")
	public List<Result> add(@RequestBody EducationAddDto educationAddDto) {
		return this.educationService.add(educationAddDto);
	}
	@GetMapping("/educationTypes")
	public DataResult<List<EducationType>> getAllEducationTypes(){
		return this.educationTypeService.getAllEducationTypes();
	}
	
	@PostMapping("/addEducationType")
	public List<Result> add(@RequestBody EducationTypeAddDto educationTypeAddDto) {
		return this.educationTypeService.addEducationType(educationTypeAddDto);
	}

}
