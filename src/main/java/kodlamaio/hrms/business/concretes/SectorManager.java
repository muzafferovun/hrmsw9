package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SectorService;
import kodlamaio.hrms.core.loggers.concretes.LoggerManager;
import kodlamaio.hrms.core.loggers.concretes.Utils;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SectorDao;
import kodlamaio.hrms.entities.concretes.Sector;

@Service
public class SectorManager implements SectorService {
	private SectorDao sectorDao;
	private LoggerManager loggerManager;
	@Override
	public DataResult<List<Sector>> getAll(){
		Utils.RunLoggers(loggerManager.log("Sector")," sector tablosu listelendi");		
		return new SuccessDataResult<List<Sector>>(this.sectorDao.findAll(),"Data Listelendi");
	}
	@Autowired
	public SectorManager(SectorDao sectorDao) {
		this.loggerManager=new LoggerManager();
		this.sectorDao=sectorDao;
	}
	@Override
	public Result add(Sector sector) {
		this.sectorDao.save(sector);
		Utils.RunLoggers(loggerManager.log("Sector"),sector.getSector_name()+" sector tablosuna eklendi");		
		return new SuccessResult("Sectör Eklendi");
	}
	
}
