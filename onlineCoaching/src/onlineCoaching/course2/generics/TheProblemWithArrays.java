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











