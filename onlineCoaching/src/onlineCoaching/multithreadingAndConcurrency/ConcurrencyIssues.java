/*
 * 	The challenge of concurrency
 * 		Threads sometimes share resources
 * 		No problem if resources only read
 * 		Changes must be coordinated
 * 
 * 	Failure to coordinate can create problems
 * 		Receive wrong results
 * 		Crash the program
 * 
 * 
 */

/*
 * 	Controlling methods
 * 		Coordinate thread access to methods
 * 		use synchronized method modifier
 * 			Class can have as many as needed
 * 
 * 		Synchronization managed per instance
 * 			No more than one thread can be in any synchronized method at a time
 * 
 */

/*
 * 	Using Synchronized Methods
 * 		When to us these methods
 * 			Protect modification by multiple threads
 * 			Reading value that might be modified by another thread
 * 		Why not always synchronize methods
 * 			Has significant overhead
 * 			Use only in multithreading scenarios
 * 
 * 		Constructors are never synchronized
 * 
 */

package onlineCoaching.multithreadingAndConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrencyIssues {
	

}

//As simple Bank Account class
	public class BankAccount{
		private int balance;
		
		public BankAccount(int startBalance) {
			balance = startBalance;
		}
		
		public int getBalance() {
			return balance;
		}
		
		public void deposit(int amount) {
			balance += amount;
		}
	}

//A class to update bank account
	public class Worker implements Runnable{
		private BankAccount account;
		public Worker(BankAccount account) {
			this.account=account;
		}
		public void run() {
			for(int i=0;i<10;i++) {
				int startBalance = account.getBalance();
				account.deposit(10);
				int endBalance = account.getBalance();
			}
		}
	}

//Running on a single thread
	ExecutorService es = Executors.newFixedThreadPool(5);
	BankAccount account = new BankAccount(100);
	
	Worker worker = new Worker(account);
	es.submit(worker);
	//Shutdowm es and wait
	
//Running on Multiple Threads
	ExecutorService es = Executors.newFixedThreadPool(5);
	BankAccount account = new BankAccount(100);
	for(int i = 0;i<5;i++) {
		Worker worker = new Worker(account);
		es.submit(worker);
	}
	//Shutdowm es and wait
	
//								1 thread vs 5 threads	
										/*
				100 = +10 +10 +10 +10 +10 +10 +10 +10 +10 +10 = 200
					  |										 ^		
					  |										 |	
					  |______________________________________|
									   1 Thread
										
	
				100 = +10 +10 +10 +10 +10 +10 +10 +10 +10 +10
				      +10 +10 +10 +10 +10 +10 +10 +10 +10 +10
				      +10 +10 +10 +10 +10 +10 +10 +10 +10 +10
				      +10 +10 +10 +10 +10 +10 +10 +10 +10 +10
				      +10 +10 +10 +10 +10 +10 +10 +10 +10 +10  = 600 or 580 or something else we dont know						
					  |										 ^		
					  |										 |	
					  |______________________________________|
									   5 Threads				
										
										*/

		//There is more here than meets the eye
		/*
		 * see the deposit method ,
		 * 	even if something might seem a single statement, that isnt the single operation for java
		 * 	 								
		 * 								  |-------	
		 * 								  |1.	Read current value from memory
		 * 			balance += amount; -->|
		 * 								  |2.	Perform addition
		 * 								  |	
		 * 								  |3.	Write result back to memory
		 * 								  |_______	
		 * 					we call this a non-atomic operation;
		 * 		//Because there is multiple steps that dont happen in one time , so
		 *  		its possible for changes to happen from other thread
		 */

//Synchronized Methods on Bank Account class
	public class BankAccount{
		private int balance;
		
		public BankAccount(int startBalance) {
			balance = startBalance;
		}
		
		public synchronized int getBalance() {
			return balance;
		}
		
		public synchronized void deposit(int amount) {
			balance += amount;
		}
	}
				//5 Threads Running correctly
	/*
							

	100 = +10 +10 +10 +10 +10 +10 +10 +10 +10 +10
	      +10 +10 +10 +10 +10 +10 +10 +10 +10 +10
	      +10 +10 +10 +10 +10 +10 +10 +10 +10 +10
	      +10 +10 +10 +10 +10 +10 +10 +10 +10 +10
	      +10 +10 +10 +10 +10 +10 +10 +10 +10 +10  = 600 
		  |										 ^		
		  |										 |	
		  |______________________________________|
						   5 Threads				
							
							*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


