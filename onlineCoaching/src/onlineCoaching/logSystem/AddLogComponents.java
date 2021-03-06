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
 * 				formatter formats the logRecord in String.
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

/*
 * 	Built-in Handlers
 * 		Java provides several built-in Handlers
 * 			Inherit directly or indirectly from Handler
 * 		
 * 		Commonly used built-in Handlers
 * 			ConsoleHandler
 * 				Writes to System.err
 * 			StreamHandler
 * 				Writes to a network socket
 * 			FileHandler
 * 				Writes to 1 or more files	
 */

/*
 * 	File Handler
 * 		FileHandler output options
 * 			Can output to a single file
 * 			Can output to a rotating set of files
 * 		Working with rotating set of files
 * 			Specify approximate max size in bytes
 * 			Specify max number of files
 * 			Cycles through reusing oldest file
 */

/*
 * 	FileHandler Substitution Pattern
 * 		Supports a substitution-based file naming
 * 			Reduces issues related to system and configuration differences
 * 			Automates rotating file set naming
 * 		
 * 	FileHandler Substitution Pattern Values
 * 			Value				Meaning
 * 			
 * 			/					Platform slash\backslash
 * 										./foo.log
 * 										/		\
 * 									unix		windows
 * 						  		./foo.log		.\foo.log
 * 			
 * 			%t					Temp directory
 * 									%t/foo.log
 * 									/		\
 * 								unix		windows
 * 			 		 /var/tmp/foo.log		C:\Users\Jim\AppData\Local\Temp\foo.log
 * 		
 * 			%h					User's home directory
 * 									%h/foo.log
 * 									/		\
 * 								unix		windows
 * 				/var/users/jim/foo.log		C:\Users\Jim\foo.log
 * 
 * 			%g					Rotating log generation
 * 									foo_%g.log
 * 								foo_0.log --> foo_1.log --> foo_2.log
 * 									^							|
 * 									|							|
 * 									|___________________________|	
 * 					 		 				
 */

/*
 * 	Built-in Formatters
 * 		Java provides two built-in Formatters
 * 			Both inherit directly from Formatters
 * 		XMLFormatter
 * 			Formats content as XML
 * 		SimpleFormatter
 * 			Formats content as simple text
 * 			Format is customizable
 * 				Uses standard formatting notation 	
 */

/*
 * 	SimpleFormatter Formatting
 * 		String.Format(format,date,source,logger,message,thrown);
 * 						/
 * 					   /     //date is anywhere $1 shows up
 * 			%1$tb %1$td, %1$tY %1$tl:%1$tM:%1$tS %1$Tp %2$s %n %4$s: %5$s%6$s%n
 * 				July 7,2016 2:43:13 PM com.jwhh.support.Other  doWork
 * 				Info: This is the message
 * 			
 * 
 * 	Customizing the Format String
 * 		Set format string with a system properly
 * 			java.logging.SimpleFormatter.format
 * 			Pass value with Java -D option	
 * 
 * 	SimpleFormatter Formatting
 * 		we want this  --->  This is the message,com.jwhh.support.Other  doWork,INFO
 * 	    to achieve that we launch our program
 * 			C:\> java -D java.util.logging.SimpleFormatter.format=%5$s,%2$s,%4$s%n com.pluralsight.training.Main 
 */

/*
 * 	Log Configuration File
 * 		Configuration info can be sat in a file
 * 			Follows standard properties file format
 * 			Can replace code-based config
 * 			Can be used with code-based config
 * 		Set file name with a system property
 * 			java.util.logging.config.file
 * 			Pass value with Java -D option
 * 
 * 	Identifying Configuration Values
 * 		Specific values depend on classes
 * 			Most code-based options available
 * 		Naming of values for Handlers & Formatters
 * 			Fully qualified class name
 * 			Followed by a "dot" and the value name
 * 		Naming of values for Loggers
 * 			Name of Logger as passed to getLogger
 * 			Followed by a "dot" and the value name
 * 
 */

/*
 * 	Logger Naming
 * 		Naming implies a parent-child relationship
 * 			LogManager links Loggers in a hierarchy based on each Logger's name
 * 		Should follow hierarchical meaning
 * 		Corresponds to type hierarchy
 * 			Each "dot" separates a level
 * 		Generally tied to a class full name	
 * 
 * 												com.ps
 * 									  		   / 	\
 * 								com.ps.training		com.ps.accounting
 * 									/		\	
 * 			  com.ps.training.Student		com.ps.training.Main				
 * 					^
 * 					|
 * 					|log
 * 			parents will log it too, but there would be a lot of duplicates so we can leverage it
 * 	Leveraging Logger Naming Hierarchy
 * 		Making the most of the Hierarchical system	
 * 			Focus on capturing important info
 * 				With the option to get details if needed
 * 			Manage setup primarily on parents
 * 			Manage log calls primarily at children
 * 
 * 			How can that actually work?????????????
 * 				Logging Hierarchy and Levels
 * 					Loggers do not require their to be level set
 * 						Log level can be null
 * 							Will inherit parent level
 * 						Primarily set level on parents
 * 							Normally somewhat restrictive level
 * 						Set more detail level on child if needed
 * 				Logging Hierarchy and Handlers
 * 					Loggers do not require handlers
 * 						A logger doesn't log if no handler
 * 							But does pass up to parent Logger
 * 						Primarily add Handlers to upper parents
 * 						Add Handlers to child if needed		
 * 					
 * 												
 */

package onlineCoaching.logSystem;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
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
		
							/*
//		Logging with FileHandler
		new FileHandler(pattern,size,Rotating set)	
		FileHandler hndlr = new FileHandler("%h/myapp_%g.log",1000,4);
		h.setFormatter(new SimpleFormatter());
		logger.addHandler(hndlr);
		//Do Something
							  */
							
		//Logging Code-based Configuration
			/*
			 * 		Handler h = new ConsoleHandler();
			  		h.setLevel(Level.ALL);	
					Formatter f = new SimpleFormatter();
					h.setFormatter(f);
					logger.addHandler(h);
					logger.setLevel(Level.INFO);
					logger.log(Level.INFO,"We're Logging!");
					//Now the same thing below in Log configuration File
			 */
		
			/*
			 * //Log Configuration File
			 * 	//log.properties	
			 * 		java.util.logging.ConsoleHandler.level = ALL
			 * 		java.util.logging.ConsoleHandler.formatter = java.util.logging.SimpleFormatter
			 * 		com.pluralsight.handlers = java.util.logging.ConsoleHandler
			 * 		com.pluralsight.level = ALL
			 * 		java.util.logging.SimpleFormatter.format = %5$s,%2$s,%4$s%n
			 * and launch it 
			 * 		java -D java.util.logging.config.file=log.properties com.pluralsight.training.Main
			 * 		and in application, just use
			 * 		static Logger logger = Logger.getLogger("com.pluralsight");
			 */
		
			/*
			 * 	Logger Naming
			 * 
			 * 		///////////////////////////////////
			 * 		package com.ps.training;
			 * 		public class Main{
			 * 			static Logger pkgLogger = Logger.getLogger("com.ps.training");
			 * 			static Logger logger = Logger.getLogger("com.ps.training.Main");
			 * 			psvm()
			 * 		}
			 * 		//////////////////////////////////
			 * 		package com.ps.training;
			 * 		public class Student{
			 * 			static Logger logger = Logger.getLogger("com.ps.training.Student");
			 * 			psvm()
			 * 		}
			 */
		
		/*
		 * 	Logger Naming how to do!!!!!!
		 * 		package com.ps.training;
			 * 		public class Main{
			 * 			static Logger pkgLogger = Logger.getLogger("com.ps.training");
			 * 			static Logger logger = Logger.getLogger("com.ps.training.Main");
			 * 			psvm(){
			 * 				logger.entering("com.ps.training","Main"); -->not logged because it needs FINER
			 * 				logger.log(Level.INFO,"We're Logging!"); -->gets logged because of parent
			 * 				//we calling on child logger with only configured parent logger
			 * 			}
			 * 		}
			 * 
			 *	//the config file be
			 *		com.ps.training.handlers=java.util.logging.ConsoleHandler
			 *		com.ps.training.level=INFO
			 *		//inorder to let entering work we do
			 *			com.ps.training.Main.handlers=java.util.logging.FileHandler
			 *			com.ps.training.Main.level=ALL
		 */
	}
}












