package kodlamaio.hrms.core.loggers.concretes;

import kodlamaio.hrms.core.loggers.abstracts.Logger;

public class LoggerManager {
	public Logger[] log(String className) {
		Logger[] loggers={};
		if(className=="Sector") {	loggers=new Logger[] {new DatabaseLogger()};	}
		if(className=="User") {	loggers=new Logger[] {new DatabaseLogger()};	}
		
		return loggers;
	}
}
