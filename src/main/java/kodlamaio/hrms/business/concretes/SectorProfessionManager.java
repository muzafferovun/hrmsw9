package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SectorProfessionService;
import kodlamaio.hrms.core.loggers.concretes.LoggerManager;
import kodlamaio.hrms.core.loggers.concretes.Utils;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

import kodlamaio.hrms.dataAccess.abstracts.SectorPositionDao;
import kodlamaio.hrms.dataAccess.abstracts.SectorProfessionDao;

import kodlamaio.hrms.entities.concretes.SectorProfession;

@Service
public class SectorProfessionManager implements SectorProfessionService {
	private SectorPositionDao sectorPositionDao;
	private SectorProfessionDao sectorProfessionDao;
	private LoggerManager loggerManager;
	@Override
	public DataResult<List<SectorProfession>> getAll(){
		Utils.RunLoggers(loggerManager.log("Sector")," sector_position_profession tablosu listelendi");		
		return new SuccessDataResult<List<SectorProfession>>(this.sectorProfessionDao.findAll(),"Data Listelendi");
	}
	@Autowired
	public SectorProfessionManager(SectorPositionDao sectorPositionDao,SectorProfessionDao sectorPositionProfessionDao) {
		this.loggerManager=new LoggerManager();
		this.sectorPositionDao=sectorPositionDao;
		this.sectorProfessionDao=sectorPositionProfessionDao;
	}
	@Override
	public List<Result> add(SectorProfession sectorPositionProfession) {
		AllDataResult allDataResult=checkSectorProfession(sectorPositionProfession);
		if(allDataResult.isSuccess()) {
		Utils.RunLoggers(loggerManager.log("Sector"),sectorPositionProfession.getProfession_name()+" sector_position_profession tablosuna eklendi");		
			this.sectorProfessionDao.save(sectorPositionProfession);
			allDataResult.addResult(new SuccessResult("sector_position_profession kaydı gerçekleştirildi"));
			return allDataResult.getSuccessResults();
		}
		else {
			return allDataResult.getErrorResults();
		}
	}
	@Override
	public AllDataResult checkSectorProfession(SectorProfession sectorPositionProfession) {
		AllDataResult allDataResult=new AllDataResult();
		if(sectorPositionDao.findById(sectorPositionProfession.getSector().getId()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("sector_position id numarası sistemde kayıtlı değil"));
		}
		if(!sectorProfessionDao.getSectorProfession(sectorPositionProfession.getProfession_name(),sectorPositionProfession.getSector().getId()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("sector_position_profession tablosunda kayıt mevcut!"));
		}
		
		return allDataResult;
	}
	
}
