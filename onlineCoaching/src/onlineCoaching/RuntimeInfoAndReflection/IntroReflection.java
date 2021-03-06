/*
 * Core capabilities of reflection
 * 	Examine types at runtime
 * 	Dynamically execute & access members
 */

/*'
 * The Need for Reflection
 * 	Apps do not always control types used
 * 		Common in advanced app designs
 * 		Common in tools and frameworks
 * 
 * 	Often dynamically load types
 * 		Type not known at compile time
 * 		There's no type-specific source code
 * 
 * 	Requires special runtime type handling
 * 		Examines types at runtime
 * 		Dynamically execute & access members
 */

/*
 * 	Runtime Examination
 * 		Can fully examine objects at runtime
 * 			Type,Base types
 * 			Interfaces implemented
 * 			Members
 * 		Variety of uses
 * 			Determine a type's capabilities
 * 			Tools development
 * 				Type inspector/browser
 * 				Schema generation
 */

/*
 * 	Dynamic Execution and Access
 * 		Can access full capability of type
 * 			Construct instances
 * 			Access fields
 * 			Call methods
 * 		
 * 		Variety of uses
 * 			Configurable application designs
 * 				Specifics tasks externally controlled
 * 			Inversion of control application designs
 * 				App provides fundamental behavior
 * 				Classes added to specialize behavior	
 */

/*
 * 	Type as a Type
 * 		Type is the foundation of any app solution
 * 			We use types to model biz issues or tech issues
 * 
 * 		Java uses types to model type issues
 * 			Fundamental type is the Class class
 * 				Each type has a Class instance
 * 				Describes the type in detail
 */

/*
 * 	Instances of Class class
 * 		simpleName
 * 		fields
 * 		constructors
 * 		methods 
 */

/*
 * 	Accessing a Type's Class instance
 * 		From a type reference
 * 			Call getClass method
 * 		From string name
 * 			Call Class.forName static method
 * 				Pass fully qualified type name
 * 		From type literal
 * 			Use typename.class
 */

/*
 * 	Accessing Type Information
 * 		Every aspect of a type is knowable
 * 			Superclass
 * 			Implemented interfaces
 * 			Modifiers
 * 			Members
 */

/*
 * 	Type Access Modifiers
 * 		Retrieving type access modifiers
 * 			Use getModifiers
 * 			Returned as single int value
 * 				Each modifier is represented by a separate bit in that integer
 * 			
 * 		Use Modifier class to interpret modifiers
 * 			Provides static fields for bit comparisons
 * 				Requires use of bitwise and/or
 * 			Provides static helper methods
 * 				Each checks for specific modifier
 */

/*
 * 	Types to Describe Type Members
 * 		Field class
 * 			Name,Type
 * 		Method
 * 			Name,Return type,Parameter types
 * 		Constructor
 * 			Name,Parameter types
 * 
 * 	Accessing Type Members
 * 		Two general ways
 * 			Type's declared members only
 * 				we can get public,protected & private
 * 					getDeclaredFields
 * 					getDeclaredMethods
 * 					getDeclaredConstructors
 * 
 * 			Type's declared & Inherited members	
 * 				we can get only public
 * 					getFields
 * 					getMethods
 * 					getConstructors  //no inherited constructors here, as thats not possible
 * 					
 */

/*
 * 	More About Members
 * 		Can request individual member by signature
 * 			getField
 * 				Pass name
 * 			getMethod
 * 				Pass name plus parameter types
 * 			getConstructor
 * 				Pass parameter types
 */

/*
 * 	Interacting with Object Instances
 * 		Reflection not limited to describing types
 * 		Can access and invoke members
 */

/*
 * 	Instance Creation with Reflection
 * 		Constructors can be executed
 * 			Use Constructor newInstance method
 * 			Returns a reference to a new instance
 * 		Simplified handling for no-arg constructor
 * 			No need to access constructor directly
 * 			Use Class newInstance method
 * 		
 * 		Flexible work dispatch system
 * 			Executes worker classes against targets
 * 			Can use any worker in classpath
 * 		Method to start work accepts 2 args
 * 			Name of worker type
 * 				Received as a String reference
 * 			Target of work
 * 				Received as Object reference
 * 		Worker type requirements
 * 			Constructor that accepts target type
 * 			A doWork method that takes no args	
 */

/*
 * 	Update flexible work dispatch system
 * 		Core requirements same as before
 * 	Method to start work
 * 		Accepts same 2 args as before
 * 
 * 	Worker type requirements
 * 		Has a no-arg constructor
 * 		Implements TaskWorker interface	
 */

package onlineCoaching.RuntimeInfoAndReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Logger;



 interface TaskWorker{
	 void setTarget(Object target);
	 void doWork();
 }

public class IntroReflection {
	
	static Logger logger = Logger.getLogger("onlineCoaching.RuntimeInfoAndReflection");
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		BankAccount bak1 = new BankAccount("1");
		BankAccount bak2 = new BankAccount("2", 500);
		doWork(bak1);
		System.out.println();
		
		//by string name
		Class<?> c = Class.forName("onlineCoaching.RuntimeInfoAndReflection.BankAccount");
		showName(c);
		System.out.println();
		
//		by type literal
		Class<?> c1 =BankAccount.class;
		showName(c1);
		System.out.println();
		
		HighVolumeAccount hBak1 = new HighVolumeAccount("12");
		classInfo(hBak1);
		System.out.println();
		
		typeModifiers(hBak1);
		System.out.println();
		
		fieldInfo(bak1);
		System.out.println();
		
		methodInfo(hBak1);
		System.out.println();
		
		methodInfo2(hBak1);
		System.out.println();
		
		callGetId(bak1);
		System.out.println();
		
		callDeposit(bak2, 50);
		System.out.println();
		
		startWork("onlineCoaching.RuntimeInfoAndReflection.AccountWorker",bak2);
		System.out.println();
		
		startWork2("onlineCoaching.RuntimeInfoAndReflection.AccountWorker",bak2);
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	static void methodInfo2(Object obj) {
		Class<?> theClass = obj.getClass();
		Method[] methods = theClass.getMethods();
		displayMethods2(methods);
		System.out.println();
		
		Method[] methods1 = theClass.getDeclaredMethods();
		displayMethods2(methods1);
	}
	static void displayMethods2(Method[] arr) {
		for(Method f:arr) {
			if(f.getDeclaringClass() != Object.class)
				logger.info(f.getName());
		}
	}
	
	static void methodInfo(Object obj) {
		Class<?> theClass = obj.getClass();
		Method[] methods = theClass.getMethods();
		displayMethods(methods);
		System.out.println();
		
		Method[] methods1 = theClass.getDeclaredMethods();
		displayMethods(methods1);
	}
	
	static void displayMethods(Method[] arr) {
		for(Method f:arr) {
			logger.info(f.getName());
		}
	}
	
	static void fieldInfo(Object obj) {
		 Class<?> theClass = obj.getClass();
		 Field[] fields = theClass.getFields();
		 displayFields(fields);
		 System.out.println();
		 
		 Field[] declaredFields = theClass.getDeclaredFields();
		 displayFields(declaredFields);
	 }
	
	static void displayFields(Field[] arr) {
		for(Field f:arr) {
			logger.info(f.getName()+" : "+f.getType());
		}
	}
	
	static void doWork(Object obj) {
		Class<?> c = obj.getClass();
		showName(c);
	}
	
	static void showName(Class<?> theClass) {
		logger.info(theClass.getSimpleName());
	}
	
	static void classInfo(Object obj) {
		Class<?> theClass = obj.getClass();
		logger.info(theClass.getSimpleName());
		
		Class<?> superClass = theClass.getSuperclass();
		logger.info(""+theClass.getSuperclass());
		
		Class<?> superClass2 = superClass.getSuperclass();
		logger.info(""+superClass.getSuperclass());
		
		logger.info(theClass.getSimpleName());
		
		Class<?>[] interfaces = theClass.getInterfaces();
		for(Class<?> ifc :interfaces) {
			logger.info(ifc.getSimpleName());
		}
		//there's is a method of Class class isInterface() to handle interface
	}
	
	static void typeModifiers(Object obj) {
		Class<?> theClass = obj.getClass();
		int modifiers = theClass.getModifiers();
		if((modifiers & Modifier.FINAL)>0) {
			logger.info("bitwise check - final");
		}
		//or without bitwise op's
		if(Modifier.isFinal(modifiers))
			logger.info("method check - final");
		if(Modifier.isPrivate(modifiers))
			logger.info("method check - private");
		if(Modifier.isProtected(modifiers))
			logger.info("method check - protected");
		if(Modifier.isPublic(modifiers))
			logger.info("method check - public");
	}

	//Method Access with Reflection
	static void callGetId(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> theClass = obj.getClass();
		Method m = theClass.getMethod("getId");
		Object result = m.invoke(obj);
		logger.info("Result: " + result);
	}
	
	//Method Access with Reflection
	static void callDeposit(Object obj,int amt) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			Class<?> theClass = obj.getClass();
			Method m = theClass.getMethod("deposit",int.class);
			m.invoke(obj,amt);
			Method m1 = theClass.getMethod("getBalance");
			Object result = m1.invoke(obj);
			logger.info("Result: " + result);
		}

	static void startWork(String workerTypeName,Object workerTarget) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> workerType = Class.forName(workerTypeName);
		logger.info(workerType.getSimpleName());
		Class<?> targetType = workerTarget.getClass();
		logger.info(targetType.getSimpleName());
		Constructor c = workerType.getConstructor(targetType);
		logger.info(c.getName());
		Object worker = c.newInstance(workerTarget);
		logger.info(worker.toString());
		Method doWork = workerType.getMethod("doWork");
		doWork.invoke(worker);
	}
	
	static void startWork2(String workerTypeName,Object workerTarget) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> workerType = Class.forName(workerTypeName);
		logger.info(workerType.getSimpleName());
		TaskWorker worker = (TaskWorker)workerType.newInstance();
		worker.setTarget(workerTarget);
		worker.doWork();
	}
}

class BankAccount{
	private String id;
	private int balance = 0;
	
	static Logger logger = Logger.getLogger("onlineCoaching.RuntimeInfoAndReflection");
	
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

class AccountWorker implements Runnable{
	static Logger logger = Logger.getLogger("onlineCoaching.RuntimeInfoAndReflection");
	BankAccount ba;
	HighVolumeAccount hva;
	public AccountWorker(BankAccount ba){
		this.ba=ba;
	}
	public AccountWorker(HighVolumeAccount hva) {
		this.hva=hva;
	}
	
	public void doWork() {
//		Thread t = new Thread(hva != null ? hva : this);
		Thread t = new Thread(this);
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

class AccountWorker1 implements Runnable,TaskWorker{

	static Logger logger = Logger.getLogger("onlineCoaching.RuntimeInfoAndReflection");
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
	
	//NOTE: see startWork2 for this
	
}



























