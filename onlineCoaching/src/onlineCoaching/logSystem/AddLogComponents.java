/*
 * Log System Divided into Components
 * 		Each component handles specific task
 * 		Easy to setup common behaviors
 * 		Provides flexibility
 * 
 * 	Core Log Components
 * 		3 core components
 * 			Logger
 * 				Accepts app calls
 * 				It generates LogRecord and which is passed to Handler
 * 			Handler
 * 				Publishes logging information
 * 				A logger can have multiple
 * 				LogRecord is passed here, each handler has a formatter, so logRecord is passed there
 * 			Formatter
 * 				Formats log info for publication
 * 				Each handler has one formatter
 * 				formatter formats the text in String.
 * 				String is passed back to handler and then to outside world
 * 
 * 			We can setLevels to Handlers
 * 
 * 
 * 	Creating a Logger
 * 		Use Logger.getLogger static method
 * 		Loggers named with a string
 * 		Once created accessible in LogManager
 * 
 * 	Adding a Handler
 * 		Java provides built-in Handlers
 * 		Add with Logger.addHandler
 * 
 * 	Adding a Formatter
 * 		Java provides built-in Formatters
 * 		Add with Handler.setFormatter	
 */

package onlineCoaching.logSystem;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class AddLogComponents {
	static Logger logger = Logger.getLogger("onlineCoaching.logSystem");
	
	public static void main(String[] args) {
		Handler h = new ConsoleHandler();
		Formatter f = new SimpleFormatter();
		h.setFormatter(f);
		logger.addHandler(h);
		logger.setLevel(Level.INFO);
		logger.log(Level.INFO,"We're Logging!");
	}
}












