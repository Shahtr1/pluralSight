package onlineCoaching.course2.generics;

import java.util.Arrays;
import java.util.Objects;

public class TheProblemWithArrays {
	public static void main(String[] args) {
		Person donDraper = new Person("Don", 89);
		Person peggy = new Person("Peggy", 65);
		
		Person[] madMen = {donDraper,peggy};
		
		System.out.println(Arrays.toString(madMen));
		
//		madMen[2] = new Person("Bert", 100);
//		System.out.println(Arrays.toString(madMen));//java.lang.ArrayIndexOutOfBoundsException
		
		madMen = add(new Person("Bert", 100),madMen);
		System.out.println(Arrays.toString(madMen));
	}

	private static Person[] add(Person person, Person[] array) {
		int length = array.length;
		array = Arrays.copyOf(array, length + 1);
		array[length] = person;
		return array;
	}
}

class Person{
	private final String name;
	private final int age;
	
	public Person(String name,int age) {
		Objects.requireNonNull(name);
		
		this.name  = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	
}









