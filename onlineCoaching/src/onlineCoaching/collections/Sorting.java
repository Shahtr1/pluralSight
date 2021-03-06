//Sorting
/*	Two ways to specify sort behavior
 * 
 * 	Comparable interface
 * 		Implemented by the type to be sorted
 * 		Type specifies own sort behavior
 * 			Should be consistent with equals
 * 	
 * 	Comparator interface
 * 		Implemented by type to perform sort
 * 		Specifies sort behavior for another type
 * 
 */

package onlineCoaching.collections;

import java.util.TreeSet;

public class Sorting {
	public static void main(String[] args) {
		//Implementing Comparable
		System.out.println("Implementing Comparable");
		TreeSet<MyClass1> tree = new TreeSet<>();
		tree.add(new MyClass1("2222","ghi"));
		tree.add(new MyClass1("3333","abc"));
		tree.add(new MyClass1("1111","def"));
		
		tree.forEach(m->System.out.println(m));
		
//		Implementing Comparator
		System.out.println("Implementing Comparator");
		TreeSet<MyClass1> tree1 = new TreeSet<>(new MyComparator());
		tree1.add(new MyClass1("2222","ghi"));
		tree1.add(new MyClass1("3333","abc"));
		tree1.add(new MyClass1("1111","def"));
		
		tree1.forEach(m->System.out.println(m));
		
	}
}
