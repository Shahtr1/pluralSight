//Arrays have limitations
/*
 * 	statically sized
 * 	Requires explicit position management
 * 	Little more than a bunch of values
 * 
 */

//Collections hold and organize values
/*
 * 	Iterable
 * 	Can provide type safety	
 * 	tend to dynamically size
 * 
 */

//Collection Interface
/*
 * 	provides common collection methods
 * 	Implemented by most collection types
 * 		Map collections are notable exception
 * 	Extends iterable interface
 * 
 * 		Method         Description
 * 		
 * 		size			Returns number of elements
 * 		clear			Removes all elements
 * 		isEmpty			returns true if no elements
 * 		add				Add a single element
 * 		addAll			Add all members of another collection
 *  
 */////////////////////////////////////////////////////////

 /*   Common Equality-based Methods
 *   	Method			Description
 *   	
 *   	contains		Returns true if contains element
 *   	containsAll		Return true if contains all members of another collection
 *   	remove			Remove element
 *   	removeAll		Remove all elements contained in another collection
 *   	retainAll		Remove all elements not contained in another collection
 *   	
 *   		Tests all us the equals method
 *   	
 */


package onlineCoaching.collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class IntroAndArrayList {
	public static void main(String[] args) {
		
		//Without type safety
		ArrayList list = new ArrayList();
		
		list.add("foo");
		list.add("Boo");
		
		System.out.println("Elements: " + list.size());
		
		for(Object o:list)
			System.out.println(o.toString());
		
		String s = (String)list.get(1);
		System.out.println(s);
		
		//A strong typed collection
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("foo");
		list1.add("Boo");
		
		System.out.println("Elements: " + list1.size());
		
		for(String s1:list1)
			System.out.println(s1);
		String s2 = list1.get(1);
		System.out.println(s2);
		
		//addAll method
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("Foo");
		list2.add("Bar");
		
		LinkedList<String> list3 = new LinkedList<>();
		list3.add("Baz");
		list3.add("Boo");
		
		list3.addAll(list2);
		System.out.println(list3);
		
		//Remove a member
		ArrayList<MyClass> list4 = new ArrayList<>();
	
		MyClass v1 = new MyClass("v1","abc");
		MyClass v2 = new MyClass("v2","abc");
		MyClass v3 = new MyClass("v3","abc");
		
		list4.add(v1);
		list4.add(v2);
		list4.add(v3);
		
		list4.remove(v3);
		
		System.out.println("this is the remove member list");
		for(MyClass c : list4) {
			System.out.println(c.getLabel());
		}
		
		
		
	} 
}
















