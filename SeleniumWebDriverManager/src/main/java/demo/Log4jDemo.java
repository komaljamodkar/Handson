package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4jDemo {
	private static Logger logger =LogManager.getLogger(Log4jDemo.class);
	

	public static void main(String[] args) {
		System.out.println("Hello world");
		logger.trace("this is an trace message");
		logger.info("this is an information message");
		logger.error("this is an error message");
		logger.warn("this is an waring message");
		logger.fatal("this is an fatal message");
		System.out.println("completed");
	}

}
