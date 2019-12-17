package onlineCoaching.course2.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImplementingAGenericType {
	public static void main(String[] args) {
		Person donDraper = new Person("Don", 89);
		Person peggy = new Person("Peggy", 65);
		Person bert = new Person("Bert", 100);
		
		List<Person> madMen = new ArrayList<>();
		madMen.add(donDraper);
		madMen.add(peggy);
		madMen.add(bert);
		
		System.out.println(madMen);
		
		Collections.sort(madMen,new AgeComparator());
		
		System.out.println(madMen);
		
		Collections.sort(madMen,new ReverseComparator<>(new AgeComparator()));
		
		System.out.println(madMen); 
	}
}


