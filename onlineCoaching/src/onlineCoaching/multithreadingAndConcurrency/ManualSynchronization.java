/*
 * 	Synchronized Methods
 * 		Automated concurrency management
 * 		Used lock of current object instance
 * 
 * 	All Java objects have a lock
 * 		Can manually acquire that lock
 * 			Use synchronized statement block
 * 			Available to any code with a reference
 */

package onlineCoaching.multithreadingAndConcurrency;

import java.util.concurrent.Executors;

public class ManualSynchronization {
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
		} //not thread-safe we have to do it explicitly
	}
}

class Worker implements Runnable{
	private BankAccount account;
	//other members elided for clarity
	
	public void run() {
		for(int i = 0;i<10;i++) {
			synchronized(account) {
				account.deposit(10);
			}
		}
	}
}

//Why Use Synchronized statement blocks
	/*
	 * 	Synchronized blocks provide flexibility
	 * 		Enables use of non-thread safe classes
	 * 		Can protect complex blocks of code
	 * 		Sometimes synchronized methods just aren't enough
	 */

// Bank Account Class Revisited

	public class BankAccount{
		private int balance;
		
		public synchronized BankAccount(int startBalance) {
			balance = startBalance;
		}
		
		public synchronized int getBalance() {
			return balance;
		}
		
		public synchronized void deposit(int amount) {
			balance += amount;
		}
		
		public synchronized void withdraw(int amount) {
			balance -= amount;
		}
	}
	
	//Only one transaction at a time
	public class TxWorker implements Runnable{
		protected BankAccount account;
		protected char txType; // 'w' -> withdrawal, 'd' -> deposit
		protected int amt;
		public TxWorker(BankAccount account,char txType,int amt) {...}
		
		public void run() {
			if(txType == 'w')
				account.withdraw(amt);
			else if(txType == 'd')
				account.deposit(amt);
		}
	}
	
	//Dispatching Transactions
	ExecutorService es = Executors.newFixedThreadPool(5);
	TxWorker[] workers = //Retrieve TxWorker instances
	
	for(TxWorker worker:workers)
		es.submit(worker);
	
	//Shutdown es and wait
///////////////////////////////////////////////////////////////////////////////////

// Now promotion over 500 , give 10% of difference
	//Transaction Promo worker
	public class TxPromoWorker extends TxWorker{
		public TxPromoWorker(BankAccount account,char tsType, int amt) {super(...)}
		public void run() {
			if(txType == 'w') {
				account.withdraw(amt);
			}else if(txType == 'd') {
				account.deposit(amt);
				if(account.getBalance()>500) {
					int bonus = (int)((account.getBalance()-500)*0.1);
					account.deposit(bonus);
				}
			}
		}
	}
	
	
	//Dispatching Transactions
	ExecutorService es = Executors.newFixedThreadPool(5);
	TxWorker[] workers = //Retrieve TxPromoWorker instances
	
	for(TxWorker worker:workers)
		es.submit(worker);
	
	//Shutdown es and wait
	//This seems to work, but it doesnt
	
	//first we have a deposit of 150, then getbalance to check > 500, releases the lock, and before anything further another thread comes and withdrawal is made, then everything would get messed up

//So fix it
	//Thread Safe Transaction Promo Worker
	public void run() {
		if(txType == 'w') {
			account.withdraw(amt);
		}else if(txType == 'd') {
			synchronized {
				account.deposit(amt);
				if(account.getBalance()>500) {
					int bonus = (int)((account.getBalance()-500)*0.1);
					account.deposit(bonus);
				}
			}
		}
	}














