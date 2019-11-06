package onlineCoaching.course2.generics;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PersonStorageTest {
	Partner donDraper = new Partner("Don", 89);
	Employee peggy = new Employee("Peggy", 65);
	Partner bert = new Partner("Bert", 100);
	
	private File file;
	private PersonSaver saver;
	private PersonLoader loader;
	
	@Test
	public void savesAndLoadsPerson() throws Exception {
		Person person = new Person("Bob", 20);
		saver.save(person);
		
		assertEquals(person,loader.load());
	}
	
	@Test
	public void savesAndLoadsArraysOfPeople() throws Exception {
//		Person[] persons = new Person[2];
		
//		//maybe we have an array of partner, we see here that this compiles fine
//		//as arrays in java are covariant
//		
//		Partner[] partners = new Partner[2];
//		Person[] persons = partners;
//		
//		persons[0] = donDraper;
//		persons[1] = bert;
		
		
		
		//But unfortunately making our arrays covariant is unsafe, as we can also do this
//		Employee[] employees = new Employee[2];
//		Person[] persons = employees;
//		
//		persons[0] = donDraper;
//		persons[1] = bert;
//		//we get ArrayStoreException, as we have put a partner in a array of employee
//		//lets use list
		
//		List<Person> persons = new ArrayList<>();
//		persons.add(donDraper);
//		persons.add(bert);
//		//lets use partner
		
		List<Partner> persons = new ArrayList<>();
		persons.add(donDraper);
		persons.add(bert);
		//Lists are not covariant, compile error here, we have to change the saveAll method's generic type here
		
		
		saver.saveAll(persons); 
		
			
		
		assertEquals(donDraper,loader.load());
		assertEquals(bert,loader.load());
	}
	
	@Test
	public void loadsListsOfPeople() throws Exception {
		saver.save(donDraper);
		saver.save(peggy);
		
		List<Person> people = new ArrayList<>();
		loader.loadAll(people);
		
		assertEquals(donDraper,people.get(0));
		assertEquals(bert,people.get(1));
	}
}











