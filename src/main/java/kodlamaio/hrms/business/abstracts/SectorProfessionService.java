package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;


import kodlamaio.hrms.entities.concretes.SectorProfession;

public interface SectorProfessionService {
	DataResult<List<SectorProfession>>  getAll();
	List<Result> add(SectorProfession sectorPositionProfession);
	AllDataResult checkSectorProfession(SectorProfession sectorPositionProfession);

}
