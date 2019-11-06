package onlineCoaching.course2.generics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PersonLoader {
	private final RandomAccessFile file;
	
	public PersonLoader(final File file) throws FileNotFoundException {
		this.file = new RandomAccessFile(file, "rw");
	}
	
	public Person load() {
		try {
			final String className = file.readUTF();
			final String personName = file.readUTF();
			final int age = file.readInt();
			
			//final Class<? extends Object> personClass = Class.forName(className); // or
			final Class<?> personClass = Class.forName(className);
			final Constructor<?> constructor = personClass.getConstructor(String.class);
			return (Person) constructor.newInstance(personName,age);
			
		}catch(IOException e) {
			return null;
		}
		catch(NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException | IllegalArgumentException | ClassNotFoundException e) {
			return null;
		}
	}

	
	//contravariant method
	public void loadAll(List<? super Person> people) throws ClassNotFoundException { //anything that is a Person or a parent of a Person
		Person person;
		while((person = load())!=null) {
			people.add(person);
		}
	}
}
