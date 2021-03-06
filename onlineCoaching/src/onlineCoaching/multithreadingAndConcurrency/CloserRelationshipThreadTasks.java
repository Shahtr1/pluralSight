/*
 * 	Multithreading not always loosely coupled
 * 		Caller may need results from worker
 * 		May need to know if task succeeded
 * 
 */

/*
 * 	Thread Relationship Types
 * 		Callable interface
 * 			Represents a task to be run on a thread
 * 				Can return results
 * 				Can throw exceptions
 * 			Only member is the call method
 * 		
 * 		Future interface
 * 			Represents results a thread task
 * 				Returned by ExecutorService.submit
 * 			The key method is get
 * 				Blocks until task completes
 * 				Returns Callable interface
 * 				Throws Callable interface exception
 * 			
 */

package onlineCoaching.multithreadingAndConcurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class CloserRelationshipThreadTasks {
	
	
}

//Adder Method Returning a Value
	//Adder implementing Callable
	public class SimpleAdderClassAndThreadClass implements Callable<Integer>{
		private String inFile,outFile;
		public SimpleAdderClassAndThreadClass(String inFile) {
			this.inFile=inFile;
			this.outFile=outFile;
		}
		
		public int doAdd() throws IOException{
			int total = 0;
			String line = null;
			
			try(BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))){
				while((line = reader.readLine())!=null) {
					total += Integer.parseInt(line);
				}
			}
			return total;
		}
		
		public Integer call()  throws IOException{
			return doAdd();
		}
	}
	
	//Start Adder processing
	String[] inFiles = {"./file1.txt",..."./file6.txt"};
	String[] outFiles = {"./file1.out.txt",..."./file6.out.txt"};
	ExecutorService es = Executors.newFixedThreadPool(3);
	Future<Integer>[] results = new Future[inFiles.length];
	
	for(int i=0;i<inFiles.length;i++) {
		SimpleAdderClassAndThreadClass adder = new SimpleAdderClassAndThreadClass(inFiles[i]);
		results[i] = es.submit(adder);
	}
	
	for(Future<Integer> result : results) {
		try {
			int value = result.get(); //b;locks until return value available
			System.out.println("Total: " + value);
		}catch(ExecutionException e) { //Exception raised in Adder
			Throwable adderEx = e.getCause(); //Get the Adder exception
			//Do something with adderEx
		}catch(Exception e) {...} //Non-Adder exceptions
	}






















