package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.business.abstracts.SectorPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.SectorPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.SectorPosition;
import kodlamaio.hrms.entities.dataTransferObjects.JobPositionList;
import kodlamaio.hrms.entities.dtos.JobPositionAddDto;


@RestController
@RequestMapping("/api/jobPosition")
public class JobPositionController<T> {
	private JobPositionService jobPositionService;
	@Autowired
	public JobPositionController( JobPositionService jobPositionService) {
		super();
		this.jobPositionService=jobPositionService;
	}
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobPositionService.getAll();
	}
	@PostMapping("/add")
	@GetMapping
	public List<Result> add(@RequestBody JobPositionAddDto jobPositionAddDto) {
		
		return this.jobPositionService.add(jobPositionAddDto);
	}
	@GetMapping("/getSectorPositions")
	public DataResult<List<SectorPosition>> getJobPositions(){
		return this.jobPositionService.getJobPositions();
	}
	@GetMapping("/getAplicationsList")
	public DataResult<List<T>> getAplicationsList(){
		return this.jobPositionService.getAplicationsList();
	}
	@GetMapping("/getCompanyAplicationsList")
	public DataResult<List<T>> getCompanyAplicationsList(int companyId){
		return this.jobPositionService.getCompanyAplicationsList(companyId);
	}
	
}
