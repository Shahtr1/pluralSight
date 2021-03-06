/*
 * 	Java has built-in ability to persist objects
 * 		Store from runtime into a byte stream
 * 		Restore from byte stream into runtime
 * 
 * 	Leverages reflection
 * 
 * 	Opens up many possibilities
 * 		Save to file system
 * 		Save in a database
 * 			RDBMS can store as blob
 * 			OODBMS can often store directly
 * 		Pass across memory address boundaries
 * 		Pass over network
 */

/*
 * 	Serialization
 * 		Serializing
 * 			Storing an object-graph to a byte stream
 * 		Deserializing
 * 			Restoring an object-graph from a byte stream 
 * 		
 */

/*
 * 	Serialization Types
 * 		Serializable
 * 			Implemented by serializable types
 * 			Indicates that type supports serialization
 * 			Has no methods
 * 		ObjectOutputStream
 * 			Serializes object-graph to stream
 * 		ObjectInputStream
 * 			Deserializes stream to object-graph
 */

/*
 * 	Being Serializable
 * 		Requirements to be serializable
 * 			Implement Serializable
 * 			Members are serializable
 * 				Primitive types are serializable
 * 				Others must implement Serializable
 */

/*
 * 	Java determines a Serial version unique identifier
 * 		which determines the structure of class
 * 		It includes the identifier into the stream content
 * 		
 */

/*
 * 	Creating Class Version Compatibility
 * 		Serial version unique identifier
 * 			Indicates version compatibility
 * 				Compatible versions have same value
 * 		Java can calculate at runtime
 * 			Value affected by a number of factors
 * 				Full type name
 * 				Implemented interfaces
 * 				Members
 * 			Type content determines compatibility
 * 		Can specify as part of type definition
 * 			Developer determines compatibility
 * 
 * 		Specifying serial version unique identifier
 * 			Add serialVersionUID field
 * 				Must be a long
 * 				Must be static final
 * 				Should be private
 * 		Calculate for initial version of type
 * 			Use serialver utility
 * 		Use same value for future versions
 * 			Maintains version compatibility	
 */

/*
 * 	The serialver utility
 * 		Performs same calculation as Java runtime
 * 		Found in JDK bin folder
 * 			IDEs often provide a plug-in
 * 	Using serialver utility
 * 		Uses class' class file
 * 			Will search in local folder
 * 			Can specify -classpath
 * 		Can pass class name on command line
 * 			Displays value to console
 * 		Can use -show option
 * 			Opens a simple graphical UI
 * 
 * 					//In CMD
 * 	serialver -classpath "./" onlineCoaching.Serialization.BankAccount
 */

/*
 * 	Custom Serialization
 * 		Can add custom serialization handling
 * 			To handle serializing
 * 				Add writeObject method to type
 * 			To handle deserializing
 * 				Add readObject method to type
 * 	
 * 		Methods called through reflection
 * 			Methods normally marked private
 */

/*
 * 	Implementing writeObject method
 * 		Return type of void
 * 		Include throws clause
 * 			IOException
 * 		Accepts ObjectOutputStream
 * 			Use to write values
 * 			defaultWriteObject for default behavior
 */

/*
 * 	Implementing readObject method
 * 		Return type of void
 * 		Include throws clause
 * 			IOException
 * 			ClassNotFoundException
 * 		Accept ObjectInputStream
 * 			Use to read values
 * 			Use readFileds to get field name info
 * 				Can access values by name
 * 			defaultReadObject for default behavior
 */

/*
 * 	Transient Fields
 * 		In some cases don't want all fields serialized
 * 			Useful for fields derived from another
 * 			Avoids unnecessary use of storage
 * 		Use transient keyword
 * 			Excludes field from serialization
 * 		Normally restore value manually
 * 			Use custom serialization
 */


package onlineCoaching.Serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class PersistingObjects {
	
	static Logger logger = Logger.getLogger("onlineCoaching.metadataWithAnnotations");

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		BankAccount bak1 = new BankAccount("1234",500);
		bak1.deposit(250); 
		saveAccount(bak1,"account.dat");
		BankAccount acct = loadAccount("account.dat");
		logger.info(acct.getId()+" : "+acct.getBalance());
		
		
		BankAccount2 bak2 = new BankAccount2("1234",500);
		bak2.deposit(350); 
//		saveAccount2(bak2,"account2.dat");
		BankAccount2 acct2 = loadAccount2("account2.dat");
		logger.info(acct2.getId()+" : "+acct2.getBalance());
		
		//Serializing with a Transient Field
		BankAccount bak3 = new BankAccount("1234",500);	
		BankAccount bak4 = new BankAccount("9876",750);
		AccountGroup group = new AccountGroup();
		group.addAccount(bak3);
		group.addAccount(bak4);
		
		saveGroup(group,"group.dat");
		loadGroup("group.dat");
		System.out.println(group.getTotalBalance());
	}
	
	static void saveGroup(AccountGroup g,String fileName){
		try(ObjectOutputStream objStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))){
			objStream.writeObject(g);
		}catch(IOException e) {
			
		}
	}
	
	static AccountGroup loadGroup(String fileName) {
		AccountGroup g = null;
		try(ObjectInputStream objStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))){
			g = (AccountGroup)objStream.readObject();
		}catch(IOException e) {
			
		}catch(ClassNotFoundException e) {
			
		}
		return g;
	}
	
	static void saveAccount(BankAccount ba,String fileName) throws IOException {
		ObjectOutputStream objStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
		objStream.writeObject(ba);
	}
	
	static BankAccount loadAccount(String fileName) throws ClassNotFoundException {
		BankAccount ba = null;
		try(ObjectInputStream objO=new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))){
			ba = (BankAccount)objO.readObject();
		}catch(IOException e) {
			
		}
		return ba;
	}
	static void saveAccount2(BankAccount2 ba,String fileName) throws IOException {
		ObjectOutputStream objStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
		objStream.writeObject(ba);
	}
	
	static BankAccount2 loadAccount2(String fileName) throws ClassNotFoundException {
		BankAccount2 ba = null;
		try(ObjectInputStream objO=new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))){
			ba = (BankAccount2)objO.readObject();
		}catch(IOException e) {
			
		}
		return ba;
	}
}

class BankAccount implements Serializable{
	//String class implements serializable
	private final String id;
	private int balance = 0;
	private char lastTxType;
	private int lastTxAmount;
	
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
	
	public synchronized void deposit(int amount) {
		balance += amount;
		lastTxType = 'd';
		lastTxAmount = amount;
	}
	
	public synchronized void withdrawal(int amount) {
		balance -= amount;
		lastTxType = 'w';
		lastTxAmount = amount;
	}
}

class BankAccount2 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3262058704649897456L;
	//String class implements serializable
	
	private String id;
	private int balance = 0;
	private char lastTxType;
	private int lastTxAmount;
	
	static Logger logger = Logger.getLogger("onlineCoaching.metadataWithAnnotations");
	
	 BankAccount2(String id) {
		this.id=id;
	}
	
	 BankAccount2(String id,int startBalance) {
		this.balance = startBalance;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public synchronized void deposit(int amount) {
		balance += amount;
	}
	
	public synchronized void withdrawal(int amount) {
		balance -= amount;
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		ObjectInputStream.GetField fields = in.readFields();
		id = (String)fields.get("id", null);
		balance = fields.get("balance", 0);
		lastTxType = fields.get("lastTxType", 'u');
		lastTxAmount = fields.get("lastTxAmount", -1);
	}
}

class AccountGroup implements Serializable{
	//HashMap also supports serialization
	private Map<String,BankAccount> accountMap = new HashMap<>();
	private transient int totalBalance;
	public int getTotalBalance() {
		return totalBalance;
	}
	public void addAccount(BankAccount account) {
		totalBalance += account.getBalance();
		accountMap.put(account.getId(), account);
	}
	
	void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		in.defaultReadObject();
		for(BankAccount account:accountMap.values())
			totalBalance += account.getBalance();
	}
}












