package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CompanyActivationCodesService;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CompanyActivationCodes;



@RestController
@RequestMapping("/api/company_activation_codes")
public class CompanyActivationCodesController {
	private CompanyActivationCodesService companyActivationCodesService;
	@Autowired
	public CompanyActivationCodesController(CompanyActivationCodesService companyActivationCodesService) {
		super();
		this.companyActivationCodesService=companyActivationCodesService;
	}
	@PostMapping("/activate")
	public Result activate(@RequestBody CompanyActivationCodes companyActivationCodes) {
		return this.companyActivationCodesService.activate(companyActivationCodes);
	}
	
}
