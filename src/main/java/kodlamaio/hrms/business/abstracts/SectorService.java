package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Sector;

public interface SectorService {
	DataResult<List<Sector>>  getAll();
	Result add(Sector sector);

	
}
