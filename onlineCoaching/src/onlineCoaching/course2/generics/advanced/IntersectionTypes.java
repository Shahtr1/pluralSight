/*
 * 	Intersection Type
 * 		<T extends A & B>
 * 		T is a subtype of A and B
 * 		If A is a class and B is an interface, so whatever T is , it have to extend the class and implement that interface at the same time,
 * 		it has all the methods of A and B.
 */

package onlineCoaching.course2.generics.advanced;

import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import onlineCoaching.course2.generics.Person;

public class IntersectionTypes {
	public static void main(String[] args) throws FileNotFoundException {
		IntersectionTypes reader = new IntersectionTypes();
		
		DataInputStream stream = new DataInputStream(new FileInputStream("src/file1.txt"));
		Person person = reader.read(stream);
		System.out.println(person);
		
		RandomAccessFile randomAccessFile = new RandomAccessFile("src/file1.txt", "rw");
		person = reader.read(randomAccessFile);//compiler complains that a random access file isnt a data dataInpiutStream, but we want it to work , we want flexibility, we can implement read method twice but thats too duplication, but we want interface thats implemented by randomAccessFile and DataInputStream, so theres an interface DataInput
		System.out.println(person);
	}
	
//	public Person read(final DataInputStream source) {
//		try(DataInputStream input = source){
//			return new Person(input.readUTF(),input.readInt());
//		}catch(IOException e) {
//			throw new RuntimeException(e);
//		}
//	}
	
	public <T extends DataInput & Closeable>Person read(final T source) {
		try(T input = source){
			return new Person(input.readUTF(),input.readInt());
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}




