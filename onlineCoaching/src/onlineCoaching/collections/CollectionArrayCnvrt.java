//Collection interface can return an array
/*
 * 		to Array() method
 * 			Returns Object array
 * 		toArray(T[] array) method
 * 			Returns array of type T
 * 		
 * Array content can be retrieved as collection
 * 		use Arrays class asList method
 */

package onlineCoaching.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionArrayCnvrt {
	public static void main(String[] args) {
		ArrayList<MyClass> list = new ArrayList<>();
		list.add(new MyClass("v1","abc"));
		list.add(new MyClass("v2","xyz"));
		list.add(new MyClass("v3","abc"));
		
		Object[] objArray = list.toArray();
		MyClass[] a1 = list.toArray(new MyClass[0]);//typed
		
		MyClass[] a2 = new MyClass[3];
		MyClass[] a3 = list.toArray(a2);
		
		if(a2==a3)
			System.out.println("a2 & a3 reference the same array");
		
		
		//asList
		MyClass[] myArray = {
			new MyClass("val1","abc"),
			new MyClass("val2","xyz"),
			new MyClass("val3","abc")
		};
		
		Collection<MyClass> listC = Arrays.asList(myArray);
		listC.forEach(m -> System.out.println(m.getLabel()));
		
		
	}
}












