/*
 * 	//Logging Levels
 * 		Each log entry is associated with a level
 * 			Included with each log call
 * 		Each Logger has a capture level
 * 			Use setLevel method
 * 			Ignores entries below capture level	
 * 		
 * 		Each level has a numeric value
 * 			7 basic log levels
 * 			2 special levels for Logger
 * 			Can define custom levels
 * 				Should generally be avoided
 * 
 * 		Level		Numeric Value		Description
 * 		
 * 		OFF			Integer.MAX_VALUE	Logger capture nothing
 * 		SEVERE		1000				Serious failure
 * 		WARNING		900					Potential problem
 * 		INFO		800					General info
 * 		CONFIG		700					Configuration info
 * 		FINE		500					General developer info
 * 		FINER		400					Detailed developer info
 * 		FINEST		300					Specialized developer info
 * 		ALL			Integer.MIN_VALUE	Logger capture everything
 */

/*
 * 	Types of Log Methods
 * 		Logger supports several logging methods
 * 			Simple log method
 * 			Level convenience methods
 * 			Precise convenience methods
 * 			Parameterized message methods
 * 	/////////////////////////////////////////////	
 * 		Simple Log Method
 * 			logger.log(Level.SEVERE,"Uh Oh!!");
 * 		
 * 	/////////////////////////////////////////////
 * 		Level Convenience Methods
 * 			Method name implies log level
 * 			Only need to pass the message
 * 				
 * 				Method		Level
 * 				
 * 				severe		Level.SEVERE
 * 				warning		Level.Warning
 * 				info		Level.INFO
 * 				config		Level.CONFIG
 * 				fine		Level.FINE
 * 				finer		Level.FINER
 * 				finest		Level.FINEST
 * 			Example	
 * 				logger.severe("Uh Oh!!"); 
 * 
 * 		Precise Log methods
 * 			Standard log methods infer calling info
 * 				Sometimes get it wrong
 * 			User precise log methods to avoid issue
 * 				Named logp
 * 				Calling class and method names passed
 * 			Example
 * 				logger.logp(Level.SEVERE,"className","methodName","message");
 * 	/////////////////////////////////////////////////////////
 * 
 * 		Precise convenience methods
 * 			Simplify logging common method actions
 * 			Logs a predefined message
 * 			Always logged as level.FINER
 * 				
 * 				Method			Message
 * 				
 * 				entering		ENTRY
 * 				exiting			RETURN
 * 	///////////////////////////////////////////////////////////////
 * 		Parameterized message methods
 * 			log. logp
 * 				Parameter substitution indicators explicitly appear within  the message
 * 					Uses simple positional substitution
 * 					Zero-based index within brackets {N}
 * 			entering,exiting
 * 				Values appear after default message
 * 					Space separated
 * 			Values always passed as object
 * 				Accept individual object or object array	
 */

package onlineCoaching.logSystem;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MakingLogCalls {
	static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static void main(String[] args) {
		
		//changing the default value
		Logger rootLog = Logger.getLogger("");
		rootLog.setLevel( Level.FINEST );
		rootLog.getHandlers()[0].setLevel( Level.FINEST );
		
		
		logger.setLevel(Level.FINE);
		
		logger.log(Level.SEVERE, "Uh Oh!!");
		logger.log(Level.INFO, "My info message");
		logger.log(Level.FINE, "My fine message");
		logger.log(Level.FINEST, "My finest message");
		
		System.out.println();
		doWork();
		
//		Parameterized message methods
		System.out.println();
		logger.log(Level.INFO,"{0} is my favourite","Java");
		logger.log(Level.INFO,"{0} is {1} days from {2}",new Object[] {"Wed",2,"Fri"});
		
		System.out.println();
		doWork("Shahrukh","Tramboo");
	}
	
	private static void doWork() {
		logger.setLevel(Level.ALL);
		logger.entering("onlineCoaching.logSystem.MakingLogCalls", "doWork");
		logger.logp(Level.WARNING,"onlineCoaching.logSystem.MakingLogCalls","doWork","Empty Function");
		logger.exiting("onlineCoaching.logSystem.MakingLogCalls", "doWork");
	}
	
	private static void doWork(String left,String right) {
		logger.entering("onlineCoaching.logSystem.MakingLogCalls", "doWork",new Object[] {left,right});
		logger.logp(Level.WARNING,"onlineCoaching.logSystem.MakingLogCalls","doWork","Empty Function");
		String result = "<"+ left+right+">";
		logger.exiting("onlineCoaching.logSystem.MakingLogCalls", "doWork",result);
	}
}




