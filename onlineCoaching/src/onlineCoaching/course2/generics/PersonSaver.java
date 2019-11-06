package onlineCoaching.course2.generics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonSaver {
private final RandomAccessFile file;
	
	public PersonSaver(final File file) throws FileNotFoundException {
		this.file = new RandomAccessFile(file, "rw");
	}
	
	public void save(Person person) throws IOException  {
		file.writeUTF(person.getClass().getName());
		file.writeUTF(person.getName());
		file.writeInt(person.getAge());
	}

//	public void saveAll(final List<Person> persons) {
//		for(Person person : persons) {
//			save(person);
//		}
//	}
	
	
	//Upper Bounded Wildcards
	public void saveAll(final List<? extends Person> persons) throws IOException { //covariant method
		for(Person person : persons) {
			save(person);
		}
	}
	
	//we can also use 
	//public <T extends Person> void saveAll(List<T> persons), but the above is much simpler, so why would we ever have that <T extends Person>?
	//here is why!!
	
//	static class Person<? extends Person>{
//		??? get() {
//			return null;
//		}
//	}// here ? means nothing referred, so we cant return anything, no type
	
	
//	//so we use this
//	static class Person<T extends Person>{
//		T get() {
//			return null;
//		}
//	}
	// so use <T extends Person> when you want to restrict your class abd declare it, and want the value back 
	// use <? extends Person> for a parameter on a method
	
	
	//Lower Bounded Wildcards
	
}










