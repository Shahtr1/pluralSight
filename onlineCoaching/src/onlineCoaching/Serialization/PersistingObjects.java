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



package onlineCoaching.Serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class PersistingObjects {
	
	static Logger logger = Logger.getLogger("onlineCoaching.metadataWithAnnotations");

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		BankAccount bak1 = new BankAccount("1234",500);
		bak1.deposit(250); 
//		saveAccount(bak1,"account.dat");
		BankAccount acct = loadAccount("account.dat");
		logger.info(acct.getId()+" : "+acct.getBalance());
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













