package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.loggers.concretes.LoggerManager;
import kodlamaio.hrms.core.loggers.concretes.Utils;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;


@Service
public class UserManager implements UserService {
	private UserDao userDao;
	private LoggerManager loggerManager;
	@Override
	public DataResult<List<User>> getAll(){
		Utils.RunLoggers(loggerManager.log("User")," User tablosu listelendi");		
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Data Listelendi");
	}
	@Autowired
	public UserManager(UserDao userDao) {
		this.loggerManager=new LoggerManager();
		this.userDao=userDao;
	}
	@Override
	public Result add(User user) {
		this.userDao.save(user);
		Utils.RunLoggers(loggerManager.log("User"),user.getEmail()+" User tablosuna eklendi");		
		return new SuccessResult(user.getEmail()+" User tablosuna eklendi");
	}
	
}
