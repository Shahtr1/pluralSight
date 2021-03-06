/*
 * Can pass info to app on command line
 * 		Easiest way to pass startup info
 * 			Target of app processing
 * 				Input/output files,URLs,etc.
 * 			Behavior options
 * 
 * Arguments passed as a String array
 * 		Received by app's main function
 * 		Each argument is a separate element
 * 			Separated by OS's whitespace
 * 			Honor's OS's value quoting
 */

package onlineCoaching.controllingAppExec;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Intro {
	public static void main(String[] args) {
		if(args.length==0) {
			showUsage();
			return;
		}
		
		String fileName = args[0];
		if(!Files.exists(Paths.get(fileName))) {
			System.out.println("\n File not found: " + fileName);
			return;
		}
		showFileLines(fileName);
			
	}
	
	
	
	private static void showFileLines(String fileName) {
		System.out.println();
		
		try(BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))){
			String line = null;
			while((line=reader.readLine())!=null)
				System.out.println(line);		
		}catch(Exception e) {
			System.out.println(e.getClass().getSimpleName()+"-"+e.getMessage());
		}
	}
	
	private static void showUsage() {
		System.out.println();
		System.out.println("Please provide the filename to process on the command line");
	}



	

}








