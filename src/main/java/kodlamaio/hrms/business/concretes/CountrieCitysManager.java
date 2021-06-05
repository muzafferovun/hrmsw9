package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CountrieCitysService;

import kodlamaio.hrms.core.loggers.concretes.LoggerManager;
import kodlamaio.hrms.core.loggers.concretes.Utils;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CountrieCitysDao;

import kodlamaio.hrms.entities.concretes.CountrieCitys;



@Service
public class CountrieCitysManager implements CountrieCitysService {
	private CountrieCitysDao countrieCitysDao;
	private LoggerManager loggerManager;
	@Override
	public DataResult<List<CountrieCitys>> getAll(){
		Utils.RunLoggers(loggerManager.log("Sector")," sector tablosu listelendi");		
		return new SuccessDataResult<List<CountrieCitys>>(this.countrieCitysDao.findAll(),"Data Listelendi");
	}
	@Autowired
	public CountrieCitysManager(CountrieCitysDao countrieCitysDao) {
		this.loggerManager=new LoggerManager();
		this.countrieCitysDao=countrieCitysDao;
	}
	@Override
	public Result add(CountrieCitys countrieCitys) {
		this.countrieCitysDao.save(countrieCitys);
		Utils.RunLoggers(loggerManager.log("Sector"),countrieCitys.getCity_name()+" countrie_citys tablosuna eklendi");		
		return new SuccessResult(countrieCitys.getCity_name()+" countrie_citys tablosuna Eklendi");
	}
	
}
