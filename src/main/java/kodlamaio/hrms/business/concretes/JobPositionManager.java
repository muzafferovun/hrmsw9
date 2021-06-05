package kodlamaio.hrms.business.concretes;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.loggers.concretes.LoggerManager;
import kodlamaio.hrms.core.loggers.concretes.Utils;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.dataAccess.abstracts.CountrieCitysDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.dataAccess.abstracts.SectorPositionDao;

import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.SectorPosition;
import kodlamaio.hrms.entities.dataTransferObjects.JobPositionList;
import kodlamaio.hrms.entities.dtos.JobPositionAddDto;
@Service
public class JobPositionManager<T> implements JobPositionService {
	private LoggerManager loggerManager;
	private JobPositionDao jobPositionDao;
	private CompanyDao companyDao;
	private SectorPositionDao sectorPositionDao;
	private CountrieCitysDao countrieCitysDao;
	private String datePattern ="yyyy-MM-dd HH:mm:SS";

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao,CompanyDao companyDao,SectorPositionDao sectorPositionDao,CountrieCitysDao countrieCitysDao) {
		this.loggerManager=new LoggerManager();
		this.jobPositionDao=jobPositionDao;
		this.companyDao=companyDao;
		this.sectorPositionDao=sectorPositionDao;
		this.countrieCitysDao=countrieCitysDao;
	}
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		Utils.RunLoggers(loggerManager.log("Company")," company tablosu listelendi");		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Data Listelendi");
	}

	@Override
	public List<Result> add(JobPositionAddDto jobPositionAddDto) {
		AllDataResult alldataResult=checkJobPosition(jobPositionAddDto);
		if(alldataResult.isSuccess()) {
			JobPosition jobPosition=new JobPosition();
			jobPosition.setCompany(this.companyDao.findById(jobPositionAddDto.getCompanyId()).get());
			SectorPosition sectorPosition=new SectorPosition();
			sectorPosition.setId(jobPositionAddDto.getJobPositionId());
			
			jobPosition.setSectorPosition(sectorPosition);
			jobPosition.setCity(jobPositionAddDto.getCity());
			jobPosition.setJobApplicationEndTime(jobPositionAddDto.getJobApplicationEndTime());
			jobPosition.setJobApplicationStartTime(jobPositionAddDto.getJobApplicationStartTime());
			jobPosition.setJobPositionStatus(jobPositionAddDto.isStatus());
			jobPosition.setPersonCount(jobPositionAddDto.getPersonCount());
			jobPosition.setReferanceContent(jobPositionAddDto.getReferanceContent());
			jobPosition.setReferanceTitle(jobPositionAddDto.getReferanceTitle());
			jobPosition.setSalaryMax(jobPositionAddDto.getSaleryMax());
			jobPosition.setSalaryMin(jobPositionAddDto.getSaleryMin());
			this.jobPositionDao.save(jobPosition);
			alldataResult.addResult(new SuccessResult("JobPosition kaydı gerçekleştirildi"));
			return alldataResult.getSuccessResults();
		}
		return alldataResult.getErrorResults();
	}
	private AllDataResult checkJobPosition(JobPositionAddDto jobPositionAddDto) {
		AllDataResult allDataResult=new AllDataResult();
		if(this.companyDao.findById(jobPositionAddDto.getCompanyId())==null) {
			allDataResult.addResult(new ErrorResult(jobPositionAddDto.getCompanyId()+" id numaralı company bulunamadı"));
		}
		if(this.sectorPositionDao.findById(jobPositionAddDto.getJobPositionId())==null) {
			allDataResult.addResult(new ErrorResult(jobPositionAddDto.getJobPositionId()+" id numaralı sector_position bulunamadı"));
		}
		if(this.countrieCitysDao.findById(jobPositionAddDto.getCity()).isEmpty()) {
			allDataResult.addResult(new ErrorResult(jobPositionAddDto.getCity()+" id numaralı city bulunamadı"));
		}
		if(jobPositionAddDto.getReferanceTitle().isBlank()) {
			allDataResult.addResult(new ErrorResult(" referanceTitle boş geçilemez"));
		}
		if(jobPositionAddDto.getReferanceContent().isBlank()) {
			allDataResult.addResult(new ErrorResult(" referanceContent boş geçilemez"));
		}
		
		
		return allDataResult;
	} 

	@Override
	public DataResult<List<SectorPosition>> getJobPositions() {
	//	Utils.RunLoggers(loggerManager.log("Company")," company tablosu listelendi");		
		return new SuccessDataResult<List<SectorPosition>>(this.sectorPositionDao.findAll(),"Data Listelendi");
	} 
	@Override
	public DataResult<List<JobPositionList>>  getAplicationsList() {
	//	Utils.RunLoggers(loggerManager.log("Company")," company tablosu listelendi");	
		List<JobPositionList> jobPositionlist=this.jobPositionDao.findAplicationsList();
		return new SuccessDataResult<List<JobPositionList>>(jobPositionlist,"Data Listelendi");
	}
	@Override
	public DataResult<List<JobPositionList>>  getCompanyAplicationsList(int companyId) {
	//	Utils.RunLoggers(loggerManager.log("Company")," company tablosu listelendi");	
		List<JobPositionList> jobPositionlist=this.jobPositionDao.findCompanyAplicationsList(companyId);
		return new SuccessDataResult<List<JobPositionList>>(jobPositionlist,"Data Listelendi");
	}

	
}
