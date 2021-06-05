package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SectorPositionService;

import kodlamaio.hrms.core.loggers.concretes.LoggerManager;
import kodlamaio.hrms.core.loggers.concretes.Utils;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SectorDao;
import kodlamaio.hrms.dataAccess.abstracts.SectorPositionDao;

import kodlamaio.hrms.entities.concretes.SectorPosition;

@Service
public class SectorPositionManager implements SectorPositionService {
	private SectorDao sectorDao;
	private SectorPositionDao sectorPositionDao;
	private LoggerManager loggerManager;
	@Override
	public DataResult<List<SectorPosition>> getAll(){
		Utils.RunLoggers(loggerManager.log("Sector")," sector tablosu listelendi");		
		return new SuccessDataResult<List<SectorPosition>>(this.sectorPositionDao.findAll(),"Data Listelendi");
	}
	@Autowired
	public SectorPositionManager(SectorPositionDao sectorPositionDao,SectorDao sectorDao) {
		this.loggerManager=new LoggerManager();
		this.sectorPositionDao=sectorPositionDao;
		this.sectorDao=sectorDao;
	}
	@Override
	public List<Result> add(SectorPosition sectorPosition) {
		AllDataResult allDataResult=checkSectorPosition(sectorPosition);
		if(allDataResult.isSuccess()) {
		Utils.RunLoggers(loggerManager.log("Sector"),sectorPosition.getPositionName()+" sector_position tablosuna eklendi");		
			this.sectorPositionDao.save(sectorPosition);
			allDataResult.addResult(new SuccessResult("sector_position kaydı gerçekleştirildi"));
			return allDataResult.getSuccessResults();
		}
		else {
			return allDataResult.getErrorResults();
		}
	}
	@Override
	public AllDataResult checkSectorPosition(SectorPosition sectorPosition) {
		AllDataResult allDataResult=new AllDataResult();
		if(sectorDao.findById(sectorPosition.getSectorId()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("Sectör id numarası sistemde kayıtlı değil"));
		}
		if(!sectorPositionDao.getSectorPosition(sectorPosition.getPositionName(),sectorPosition.getSectorId()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("sector_position tablosunda kayıt mevcut!"));
		}
		
		return allDataResult;
	}
	
}
