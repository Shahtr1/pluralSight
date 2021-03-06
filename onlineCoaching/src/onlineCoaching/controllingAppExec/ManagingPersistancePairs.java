//				Managing Persistable Key/Value Pairs
/*
 * 		Apps often need persistable key/value pairs
 * 			Store app configuration information
 * 			Track simple aspects of app state
 * 			Track user preferences
 * 		
 * 		Need an easy way to manage key/value pairs
 * 			Set/retrieve value
 * 			Store/load between app executions
 * 			Provide default value when not set
 * 
 * 		Use the java.util.Properties class
 *///////////////////////////////////////////////////////////
 				
	/*			Properties Class
	 * 				Inherits from HashTable class
	 * 				Keys and values are Strings
	 * 
	 * 			Working with properties
	 * 				setProperty method
	 * 					Sets the current value for a key
	 * 					Creates or updates key as needed
	 * 				getProperty method
	 * 					Returns the current value for the key
	 * 					Returns null if not found and no default
	 * 					Can optionally provide default value
	 */

	/*
	 * 			Store and load property values
	 * 				Can be written to & read from a stream
	 * 				Can optionally include comments
	 * 				Supports 2 formats
	 * 					Simple text
	 * 					XML
	 * 
	 * 			Persist as simple text
	 * 				Use store & load methods
	 * 					Supports OutputStream/InputStream
	 * 					Supports Writer/Reader
	 * 				Normally name file with .properties suffix
	 * 			
		 * 			One key/value pair written per line
		 * 				Key/value normally separated by = or :
		 * 					Whitespace surrounding =,: ignored
		 * 					Whitespace acts	as key/value separator if occurs without = or:
		 * 					Can escape whitespace,=,or: with \
		 * 				Start a line with # or ! for comments
		 * 				Blank lines ignored
	 * 
	 * 
	 * 			Persist as XML
	 * 				Use storeToXML & loadFromXML methods
	 * 					Supports OutputStream/InputStream
	 * 				Normally name file with .xml suffix	
	 * 				
	 * 				One key/value pair per XML element
	 * 					Stored as element named entry
	 * 						Key stored as key attribute
	 * 						Value stored as element value
	 * 					Use comment element for comments
	 * 	
	 */

	

package onlineCoaching.controllingAppExec;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ManagingPersistancePairs {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("displayName", "shahrukh");
		String name = props.getProperty("displayName");
//		System.out.println(name);
		String acc = props.getProperty("acc_no");
//		System.out.println(acc);
		String pos = props.getProperty("pos","1");
//		System.out.println(pos);
		
		
		//Storing properties as Simple Text
		props.setProperty("phoneNumber", "8448113174");
		try(Writer writer = Files.newBufferedWriter(Paths.get("xyz.properties"))){
			props.store(writer, "My comment");
		}catch(Exception e) {
			
		}
		
		
		//Loading properties from Simple Text
		Properties props1 = new Properties();
		try(Reader reader = Files.newBufferedReader(Paths.get("myApp.properties"))){
			props1.load(reader);
		}catch(Exception e) {
			
		}
		String val1 = props1.getProperty("val1");
		String val2 = props1.getProperty("val2");
		String val3 = props1.getProperty("val3");
		String val4 = props1.getProperty("val4");
		
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(val3);
		System.out.println(val4);
		
		
		//Storing Properties as XML
		try(OutputStream out = Files.newOutputStream(Paths.get("props.xml"))){
			props.storeToXML(out, "My comment");
		}catch(Exception e) {
			
		}
		
		//Loading Properties from XML
		Properties props2 = new Properties();
		try(InputStream in = Files.newInputStream(Paths.get("props.xml"))){
			props2.loadFromXML(in);
		}catch(Exception e) {
			
		}
		
		String val11 = props2.getProperty("displayName");
		String val21 = props2.getProperty("phoneNumber");
		
		System.out.println();
		System.out.println("From XML");
		
		System.out.println(val11);
		System.out.println(val21);
		
		//Using Default Properties
		Properties defaults =  new Properties();
		defaults.setProperty("position", "1");
		
		Properties props3 = new Properties(defaults);
		String nextPos = props3.getProperty("position");
		
		int iPos = Integer.parseInt(nextPos);
		props3.setProperty("position", Integer.toString(++iPos));
		
		nextPos = props3.getProperty("position");
		System.out.println(nextPos);
	}
}




















