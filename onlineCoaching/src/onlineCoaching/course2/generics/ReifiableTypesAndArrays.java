/*
 *  Array is a reified type
 */

package onlineCoaching.course2.generics;

import java.util.List;

public class ReifiableTypesAndArrays {
	public static void main(String[] args) {
//		String[] strings = new String[3];
//		Object[] objects = strings;
//		objects[0] = 1;
//		
//		//we got java.lang.ArrayStoreException as before, because arrays are reified
//		//A string array is a distinct type and list of string isn't a distinct type
//		// so it has to force this exception
//		
//		
		
		List arrayList = new CustomArrayList();
		arrayList.add(0);
		arrayList.add(1);
		arrayList.add(2);
		
		System.out.println(arrayList.get(0));
		System.out.println(arrayList.get(1));
		System.out.println(arrayList.get(2));
		
	}
}











