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
	}
}




