/*
 *  A raw type is just a usage of a generic type that doesnt have any generic parameters
 *  if raw type is equal to List<Object>
 *  but they arent the same thing
 *  
 *  as we can assign this
 *  List<String> strings = list;
 *  
 *  but if we keep a raw type
 *  this List<String> strings = list; is not an error
 */

/*
 * raw types mean that we have an unsafe scenario in the code, this can introduce runtime errors
 */

package onlineCoaching.course2.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LegacyCode {
	public static void main(String[] args) {
//		List<Object> list = new ArrayList<>(); //this is raw type
//		list.add("abc");
//		list.add(1);
//		list.add(new Object());
//		
//		List<String> strings = list;
		
		
		
		List list = new ArrayList<>(); //this is raw type
		list.add("abc");
		list.add(1);
		list.add(new Object());
		
		List<String> strings = list;  //very very bad
		for(String elem : strings) {
		//  (because of second element) java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String 
			System.out.println(elem);
		}
		
		
		
		
//		we didnt have generics in preJava 5 and no foreach
		Iterator iterator = list.iterator();
		
		while(iterator.hasNext()) {
			final Object element = iterator.next();
			System.out.println(element);
		}
	}
}
