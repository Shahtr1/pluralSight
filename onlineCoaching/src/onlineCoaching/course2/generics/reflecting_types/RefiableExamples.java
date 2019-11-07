/*
 * 	Not all generic type can be reflected
 * 	Types that are reified can be reflected
 * 	A type which contains all its descriptive information
 */

/*
 * 	Primitives
 * 		int, long
 * 
 * 	Non Parameterized Class or interface
 * 		String, ActionListener
 * 
 * 	All type arguments are unbounded Wildcards
 * 		List<?>, Map<?,?>
 * 
 * 	Raw Types
 * 		List, Map
 * 
 * 	Arrays of reifiable components
 * 		int[][], List<?>[]
 */

package onlineCoaching.course2.generics.reflecting_types;

import java.util.ArrayList;
import java.util.List;

public class RefiableExamples {
	public static void main(String[] args) {
		System.out.println(int.class);
		System.out.println(String.class);
		
		List<?> wildcards = new ArrayList<>();
		System.out.println(wildcards.getClass());
		
		List raw = new ArrayList<>();
		System.out.println(raw.getClass());
		
		System.out.println(raw.getClass() == wildcards.getClass());
		
		System.out.println(int[].class);
		
		System.out.println(List[].class);
	}
}







