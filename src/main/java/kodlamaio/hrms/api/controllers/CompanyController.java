package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.business.abstracts.PersonService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Company;
import kodlamaio.hrms.entities.concretes.CompanyUser;


@RestController
@RequestMapping("/api/company")
public class CompanyController {
	private CompanyService companyService;
	@Autowired
	public CompanyController( CompanyService companyService) {
		super();
		this.companyService=companyService;
	}
	@GetMapping("/getall")
	public DataResult<List<Company>> getAll(){
		return this.companyService.getAll();
	}
	@PostMapping("/add")
	@GetMapping
	public List<Result> add(@RequestBody CompanyUser companyUser) {
		return this.companyService.add(companyUser);
	}
	@PostMapping("/closeJobPosition")
	@GetMapping
	public Result closeJobPosition( int jobPositionId) {
		return this.companyService.closeJobPosition(jobPositionId);
	}
	@PostMapping("/openJobPosition")
	@GetMapping
	public Result openJobPosition( int jobPositionId) {
		return this.companyService.openJobPosition(jobPositionId);
	}
	
}
