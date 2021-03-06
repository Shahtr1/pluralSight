/*
 *  Java offers thread pools
 *  	Creates a queue for tasks
 *  	Assigns tasks into a pool of threads
 *  	Handles details of managing threads	
 *  
 *  Thread Pool Types
 *  	ExecutorService interface
 *  		Models thread pool behavior
 *  		Can submit tasks
 *  		Request and wait for pool shutdown
 *  	
 *  	Executor class
 *  		Methods for creating thread pools
 *  			Dynamically sized pools
 *  			Size limited pools
 *  			Pools that schedule tasks for later
 *  
 */

package onlineCoaching.multithreadingAndConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPools {
						/*
					//This can cause problems if there are many files so we use a thread pool
	String[] inFiles = {"./file1.txt",..."./file6.txt"};
	String[] outFiles = {"./file1.out.txt",..."./file6.out.txt"};
	
	Thread[] threads = new Thread[inFiles.length];
	
		for(int i=0;i<inFiles.length;i++) {
			SimpleAdderClassAndThreadClass adder = new SimpleAdderClassAndThreadClass(inFiles[i],outFiles[i]);
			threads[i] = new Thread(adder);
			threads[i].start();
		}
		
	for(Thread thread:threads)
		thread.join();//Blocks waiting for thread completion
		//main thread continues running as long as background threads have done their job
					 	*/
		
						/*
				//Running Adder in a Thread Pool
	String[] inFiles = {"./file1.txt",..."./file6.txt"};
	String[] outFiles = {"./file1.out.txt",..."./file6.out.txt"};
	ExecutorService es = Executors.newFixedThreadPool(3);
	
	for(int i=0;i<inFiles.length;i++) {
		SimpleAdderClassAndThreadClass adder = new SimpleAdderClassAndThreadClass(inFiles[i],outFiles[i]);
		es.submit(adder);
		//never more than 3 running at the same time
	}
	try {
	es.shutdown();  //wait for work to get completed and don't allow new work
	es.awaitTermination(60,TimeUnit.SECONDS); //wait for shutdown, 60 seconds
	}catch(Exception e) {}
	
						*/
}













