package kodlamaio.hrms.core.loggers.concretes;

import kodlamaio.hrms.core.loggers.abstracts.Logger;

public class Utils {
	public static void RunLoggers(Logger[] loggers,String message) {
		for(Logger logger:loggers)	logger.log(message);

	}
}
