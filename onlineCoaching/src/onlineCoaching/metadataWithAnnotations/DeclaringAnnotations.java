/*
 * 	Flexible work dispatch system
 * 		Executes worker classes against targets
 * 	Worker type requirements
 * 		Has a no-argument constructor
 * 		Implements TaskWorker interface
 * 			Our custom interface
 * 
 * 	Worker threading requirements
 * 		Can create own thread
 * 		Can be run on app's thread pool
 * 		Preference indicated with annotation
 */

/*
 * 	Declaring Annotations
 * 		Annotations are a special kind of interface
 * 			Usage is much more restricted
 * 				Can't be explicitly implemented
 * 			Implicitly extend Annotation interface
 * 			Interface behavior not initially apparent
 * 
 * 		Declaring annotations similar to interfaces
 * 			Use interface keyword
 * 				Preceded by an @ symbol
 * 			Declarations allow same modifiers
 * 			Declarations allowed in same places
 * 
 * 		Annotations can have content called elements
 * 			Associate values within annotations
 * 			Declared as methods
 * 			Setting is similar to fields
 */

/*
 *	Annotation Retention
 *		Annotations can specify availability
 *			Part of annotation declaration
 *			Indicated with Retention annotation
 *				Accepts RetentionPolicy value
 *
 *		RetentionPolicy Values
 *			SOURCE
 *				Exist only in source file
 *				Discarded by compiler
 *			CLASS
 *				Compiled into class file
 *				Discarded by runtime
 *				This is DEFAULT.
 *			RUNTIME
 *				Loaded into runtime
 *				Accessible with reflection
 */

/*
 * 	Annotation Target
 * 		Annotations can narrow allowable targets
 * 			Part of annotation declaration
 * 			Indicated with Target annotation
 * 				Accepts ElementType value
 * 			Can support multiple targets
 * 				use array notation
 * 
 * 		Target(ElementType.CONSTRUCTOR)
 * 		Target({ElementType.TYPE, ElementType.METHOD})
 */

/*
 * 	Simplifying Element Setting
 * 		Elements can be setup to simplify setting
 * 			Handle common cases
 * 			Element default values
 * 			Element assignment shorthand
 * 
 * 		Element Default Values
 * 			Elements can be declared with a default 
 * 				Use default keyword
 * 				Can still explicitly set if desired
 * 
 * 		Element Assignment Shorthand
 * 			Must be setting only one element
 * 			Element name must be value
 */

/*
 * 	Valid Annotation Element Types
 * 		Primitive type, String, Enum, Annotation, Class<?> ,can also be array , but array of the previously said types
 *      
 *      we had this 
 *      BankAccount bak2 = new BankAccount("2", 500);
 *		startWork2("onlineCoaching.metadataWithAnnotations.AccountWorker1",bak2);
 *
 *								//////////
 *		@ProcessedBy(AccountWorker.class)
 *		class BankAccount{
			private String id;
			private int balance = 0;
			
			static Logger logger = Logger.getLogger("onlineCoaching.metadataWithAnnotations");
			
			 BankAccount(String id) {
				this.id=id;
			}// other members elided
							/////
		now we would have this	
		BankAccount bak2 = new BankAccount("2", 500);
		startWorkSelfContained(bak2);
		//here we rely on metadata
		 * 
		 * 
		 * 	@Target(ElementType.TYPE)
			@Retention(RetentionPolicy.RUNTIME)
			@interface ProcessedBy{
				Class<?> value();
			}	
			/////////////////////
		
		
		static void startWorkSelfContained(Object workerTarget) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> targetType = workerTarget.getClass(); 
		ProcessedBy pb = targetType.getAnnotation(ProcessedBy.class);
		Class<?> workerType = pb.value();
		TaskWorker worker = (TaskWorker)workerType.newInstance();
		//Remaining of code just like startWorkMethod
		 * 		//...............
	}
					 
 */

package onlineCoaching.metadataWithAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface WorkHandler{
	boolean useThreadPool() default true;
}

public class DeclaringAnnotations {
	
	static Logger logger = Logger.getLogger("onlineCoaching.metadataWithAnnotations");
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		BankAccount bak2 = new BankAccount("2", 500);
		
		startWork2("onlineCoaching.metadataWithAnnotations.AccountWorker1",bak2);
		System.out.println();
	}
	
	
	@SuppressWarnings({ "deprecation", "null" })
	static void startWork2(String workerTypeName,Object workerTarget) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> workerType = Class.forName(workerTypeName);
		logger.info(workerType.getSimpleName());
		TaskWorker worker = (TaskWorker)workerType.newInstance();
		logger.info(""+worker);
		worker.setTarget(workerTarget);
		logger.info(workerTarget.toString());
		WorkHandler wh = workerType.getAnnotation(WorkHandler.class);
		ExecutorService pool = Executors.newFixedThreadPool(5);
		try {
			if(wh == null) {
				
			}
		}catch(Exception e){
			System.out.println(e.getClass().getSimpleName());
		}
		
		
		if(wh.useThreadPool()) {
			pool.submit(new Runnable() {
				public void run() {
					logger.info("Thread pool");
				}
			});
		}else
			worker.doWork();
	}
}

interface TaskWorker{
	 void setTarget(Object target);
	 void doWork();
}


@WorkHandler(useThreadPool = false)
class AccountWorker1 implements Runnable,TaskWorker{

	static Logger logger = Logger.getLogger("onlineCoaching.metadataWithAnnotations");
	BankAccount ba;
	
	@Override
	public void setTarget(Object target) {
		if(BankAccount.class.isInstance(target)) {
			ba = (BankAccount)target;
		}else
			throw new IllegalArgumentException();
		
	}

	@Override
	public void doWork() {
		Thread t = new Thread(HighVolumeAccount.class.isInstance(ba)?(HighVolumeAccount)ba:this);
		t.start();
	}

	@Override
	public void run() {
		char txType = 'w';//read tx type;
		int amt = 200;//read tx amount
		if(txType == 'w') {
			ba.withdrawal(amt);
			logger.info(""+ba.getBalance());
		}	
		else {
			logger.info(""+amt);
			ba.deposit(amt);
			logger.info(""+ba.getBalance());
		}
		
	}
	
	
}


class BankAccount{
	private String id;
	private int balance = 0;
	
	static Logger logger = Logger.getLogger("onlineCoaching.metadataWithAnnotations");
	
	 BankAccount(String id) {
		this.id=id;
	}
	
	 BankAccount(String id,int startBalance) {
		this.balance = startBalance;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amount) {
		balance += amount;
	}
	
	public void withdrawal(int amount) {
		balance -= amount;
	}
}

final class HighVolumeAccount extends BankAccount implements Runnable{

	HighVolumeAccount(String id) {
		super(id);
	}
	
	HighVolumeAccount(String id,int balance) {
		super(id,balance);
	}
	
	private int[] readDailyDeposits() {return null;}
	private int[] readDailyWithdrawals() {return null;}

	@Override
	public void run() {
		for(int depositAmt:readDailyDeposits()) {
			deposit(depositAmt);
		}
		for(int withdrawalAmt:readDailyWithdrawals()) {
			withdrawal(withdrawalAmt);
		}
		
	}
	
}








