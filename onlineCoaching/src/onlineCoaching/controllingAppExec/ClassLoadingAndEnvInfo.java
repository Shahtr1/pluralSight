/*
 * 	Most applications do not stand alone
 * 		Rely on classes in other packages
 * 		JDK packages located automatically
 * 		May need help locating other packages
 * 
 * 	Locating packages at development time
 * 		Specific to each IDE
 * 		
 * 	Locating packages at runtime
 * 		Java provides a number of options discussed below
 * 
 * 	Default Class Loading
 * 		By default Java searches current directory
 * 			Classes must be in .class files
 * 				Must be under packages directories
 * 		As long everything is in one directory 
 * 			C:\myDir> java onlineCoaching.controllingAppExec.ClassLoadingAndEnvInfo
 * 			and import other packages in main class
 * 			But in many cases having these only in one directory may not be practical
 * 	
 * 	Control the way classes are located
 * 		Specifying Class Path
 * 			Can provide the list of paths to search
 * 				Searched in the order they appear
 * 				Current directory used only if in list
 * 			Two options for specifying class path
 * 				Environment variable
 * 				Java command option
 * 	
 * 		Specifying Class Path as Environment variable
 * 			Can specify as an environment variable
 * 				Variable named CLASSPATH
 * 			Becomes default path
 * 				used by all programs that don't provide a specific path
 * 			Use environment variable with caution
 * 				Changing for one program can break another
 * 			
 * 			C:\myDir> set CLASSPATH=\otherDir
 * 			//----      Classes loaded from \otherDir      ----\\
 * 			C:\myDir> java onlineCoaching.controllingAppExec.ClassLoadingAndEnvInfo
 * 		
 * 			This isn't safe
 * 			Now moving to safer way
 * 
 * 		Class Path Structure
 * 			Paths provided as delimited list 
 * 				Windows -> separate with ;(semicolon)
 * 				Unix platforms -> separate with :(colon)
 * 				Searched in the order they appear
 * 			To reference classes in .class files
 * 				Path to folder containing package root
 * 			To reference classes in jar files
 * 				Path to the jar file 
 * 					Including jar file name
 * 			On WINDOWS ->
 * 				java -cp \psDir;\libDir onlineCoaching.controllingAppExec.ClassLoadingAndEnvInfo
 * 			On UNIX platforms ->
 * 				java -cp /psDir:/libDir onlineCoaching.controllingAppExec.ClassLoadingAndEnvInfo	
 * 			
 * 			What if under psDir there is a jar
 * 			On WINDOWS ->
 * 				java -cp \psDir\training.jar;\libDir onlineCoaching.controllingAppExec.ClassLoadingAndEnvInfo
 * 			On UNIX platforms ->
 * 				java -cp /psDir/training.jar:/libDir onlineCoaching.controllingAppExec.ClassLoadingAndEnvInfo
 * 
 * 		Class Loading with java -jar Option
 * 			Java -jar option locks down class loading
 * 				Class loading totally controlled by jar file
 * 				No other class loading source is used
 * 				
 * 			Provides tight control over class loading
 * 
 * 			java -jar ourApp.jar
 * 
 * 
 * 
 * 
 * 	Execution Environment Information
 * 		Apps often need environment information
 * 			User information
 * 			System information
 * 			Java configuration information
 * 			Application specific information
 * 
 * 		Java provides two common solutions
 * 			System properties 
 * 			Environment variables
 * 		
 * 		System Properties
 * 			Java provides info about environment
 * 				Accessed with System.getProperty
 * 			Information includes
 * 				User information
 * 				Java installation information
 * 				OS configuration information
 * 			Each value accessed via a string name
 * 
 * 		Environment variables
 * 			Most OS's support environment variables
 * 				Provide configuration information
 * 				Many variables are set by OS
 * 				Can provide app-specific variables
 * 			Apps can access environment variables
 * 				Access all with System.getenv()
 * 					Returns Map<String,String>
 * 				Access one with System.getenv(name)
 * 					Returns value of specific variable
 * 				
 */

package onlineCoaching.controllingAppExec;

import java.util.Map;

public class ClassLoadingAndEnvInfo {
	public static void main(String[] args) {
		
		//System Properties
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		String osArchitecture = System.getProperty("os.arch");
		String javaVendor = System.getProperty("java.vendor");
		
		System.out.println(userName);
		System.out.println(userHome);
		System.out.println(osArchitecture);
		System.out.println(javaVendor);
		
		//Environment Variables
			Map<String,String> all = System.getenv();
			all.forEach((k,v) -> System.out.println(k+" | "+v));
			String compName = System.getenv("COMPUTERNAME");
			String homePath = System.getenv("HOMEPATH");
			System.out.println(compName);
			System.out.println(homePath);
			
			String author = System.getenv("Course_author"); //this is not predefined by OS
			//so i want this specific to my Application
			System.out.println(author);
			/*
			 *  C:myDir> java onlineCoaching.controllingAppExec.ClassLoadingAndEnvInfo
			 *  	author's value will be printed as null
			 *  so we do this
			 *  	C:myDir> set Course_author=Shahrukh Tramboo
			 *  	C:myDir> java onlineCoaching.controllingAppExec.ClassLoadingAndEnvInfo
			 *  now it would print Shahrukh Tramboo	
			 */
	}
}

















