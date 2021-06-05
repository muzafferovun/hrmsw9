package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SectorPosition;

public interface SectorPositionService {
	DataResult<List<SectorPosition>>  getAll();
	List<Result> add(SectorPosition sectorPosition);
	AllDataResult checkSectorPosition(SectorPosition sectorPosition);
}
