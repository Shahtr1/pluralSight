package onlineCoaching.course2.generics;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return Integer.compare(o1.getAge(), o2.getAge());//for ascending
//		return -1 * Integer.compare(o1.getAge(), o2.getAge());//check ReverseComparator
	}
	
}
