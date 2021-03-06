/*
	 * 				Providing Default Properties
	 * 					Often useful to provide default values
	 * 						Simplifies configuration
	 * 						Provide initial values for user preferences
	 * 						Cumbersome to explicitly provide defaults for each getProperty call
	 * 
	 * 					Can create Properties with defaults
	 * 						Pass default Properties to constructor
	 * 							Searched if key not found in current Properties instances
	 * 						Default properties take precedent over default value passed to getProperty
	 * 				
	 * 				Include Default Properties in Package
	 * 					Default property file can be part of package
	 * 						Create .properties file at development time
	 * 							Build process includes file in package
	 * 					Can load file from package
	 * 						Takes advantage of Java resource system
	 * 						Use getResourceAsStream method
	 * 							Accessed through any class in package
	 * 								ClassName.class		
	 * 								this.getClass()
	 */

package onlineCoaching.controllingAppExec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ProvidingDefaultProps {
	public static void main(String[] args) {
		try {
			Properties defaultProps = new Properties();
			try(InputStream in = ProvidingDefaultProps.class.getResourceAsStream("MyDefaultValues.xml")){
				defaultProps.loadFromXML(in);
			}
			Properties userProps = new Properties(defaultProps);
			loadUserProps(userProps);
			
			String welcomeMessage = userProps.getProperty("welcomeMessage");
			String farewellMessage = userProps.getProperty("farewellMessage");
			
			System.out.println(welcomeMessage);
			System.out.println(farewellMessage);
			
			if(userProps.getProperty("isFirstRun").equalsIgnoreCase("Y")) {
				userProps.setProperty("welcomeMessage","Welcome back");
				userProps.setProperty("farewellMessage","Things will be familiar now");
				userProps.setProperty("isFirstRun","N");
				saveUserProps(userProps);
			}
			
		}catch(IOException e) {
			System.out.println("Exception <" + e.getClass().getSimpleName() + "> " + e.getMessage());
		}
	}
	
	private static Properties loadUserProps(Properties userProps)throws IOException{
		Path userFile = Paths.get("userValues.xml");
		if(Files.exists(userFile)) {
			try(InputStream inputStream = Files.newInputStream(userFile)){
				userProps.loadFromXML(inputStream);
			}
		}
		return userProps;
	}
	
	private static void saveUserProps(Properties userProps) throws IOException {
		try(OutputStream out = Files.newOutputStream(Paths.get("userValues.xml"))){
			userProps.storeToXML(out, null);
		}
	}
}

















