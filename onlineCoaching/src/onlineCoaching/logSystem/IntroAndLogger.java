/*
 * We need a way to capture app activity
 * 		Record unusual circumstances or errors
 * 		Track usage info
 * 		Debug
 * 
 * The required level of detail can vary
 * 
 * Java provides a built-in solution
 * 		java.util.logging
 */

/*    ///Log System Management
 * 			LogSystem is centrally managed
 * 				There is one app-wide log manager
 * 				Manages objects that do actual logging
 * 			Represented by LogManager class
 * 				One global instance
 * 					Access with static method LogManager.getLogManager
 * 
 */

/*
 * 	//Logger class
 * 		Provides logging methods
 * 		
 * 	  Access Logger instances with LogManager
 * 		Use getLogger method
 * 		Each instance named
 * 		A global logger instance is available
 * 			Access using the Logger class's static field GLOBAL_LOGGER_NAME
 * 			
 * 		
 */




package onlineCoaching.logSystem;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class IntroAndLogger {
	static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static void main(String[] args) {
		/*
		LogManager lm = LogManager.getLogManager();
		Logger logger = lm.getLogger(Logger.GLOBAL_LOGGER_NAME);
		logger.log(Level.INFO, "My first message");
		logger.log(Level.INFO, "My other message");
		// but we have to repeat it always to get to LogManager and Logger
		 // so in practice we start with static reference like above
		*/
		
		logger.log(Level.INFO, "My first message");
		logger.log(Level.INFO, "My other message");
	}
}









