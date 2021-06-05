package kodlamaio.hrms.core.loggers.concretes;

import kodlamaio.hrms.core.loggers.abstracts.Logger;

public class DatabaseLogger implements Logger  {

	@Override
	public void log(String message) {
		System.out.println("Database Log : "+message);
		
	}

}
