package onlineCoaching.course2.generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExamples<T> {
	
	public static void main(String[] args) {
		Person donDraper = new Person("Don", 89);
		Person peggy = new Person("Peggy", 65);
		Person bert = new Person("Bert", 100);
		
		List<Person> madMen = new ArrayList<>();
		madMen.add(donDraper);
		madMen.add(peggy);
		madMen.add(bert);
		
//		new Minimizer<Person>().min(madMen,new AgeComparator()); //boilerplate
		
		
//		final Person youngestCastMember = (Person) min(madMen,new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//			
//		});   //runtime error, no generic safe
		
		
//		final Person youngestCastMember = (Person) min(madMen,new AgeComparator());
		
		final Person youngestCastMember = min(madMen,new AgeComparator());
		
		System.out.println(youngestCastMember);
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		
		System.out.println(min(numbers, Integer::compare));
	}
	
//	static final class Minimizer<T>{ //boilerplate
//		public T min(List<T> values) {
//			
//		}
//	}
	
	public static <T> T min(List<T> values, Comparator<T> comparator) {
		if(values.isEmpty()) {
			throw new IllegalArgumentException("Empty");
		}
		
		T lowestElement = values.get(0);
//		System.out.println(lowestElement);
		
		for(int i = 1;i < values.size();i++) {
			final T element = values.get(i);
//			System.out.println(element);
			if(comparator.compare(element, lowestElement)<0) {
//				System.out.println(element);
				lowestElement = element;
			}
		}
		
		return lowestElement;
	}
}






