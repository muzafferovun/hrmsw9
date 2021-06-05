package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SectorProfessionService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;


import kodlamaio.hrms.entities.concretes.SectorProfession;


@RestController
@RequestMapping("/api/sectorPositionProfessions")
public class SectorPositionProfessionController {
	private SectorProfessionService sectorPositionProfessionService;
	@Autowired
	public SectorPositionProfessionController(SectorProfessionService sectorPositionProfessionService) {
		super();
		this.sectorPositionProfessionService=sectorPositionProfessionService;
	}
	@GetMapping("/getall")
	public DataResult<List<SectorProfession>> getAll(){
		return this.sectorPositionProfessionService.getAll();
	}
	@PostMapping("/add")
	public List<Result> add(@RequestBody SectorProfession sectorPositionProfession) {
		return this.sectorPositionProfessionService.add(sectorPositionProfession);
	}
	
}
