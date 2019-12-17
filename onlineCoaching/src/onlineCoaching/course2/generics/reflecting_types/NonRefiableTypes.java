/*
 * 	A lot of generic info is erased at runtime, not enough info retained
 */

/*
 * 	Type Variables
 * 		T
 * 
 * Parameterized Type with Parameters
 * 		ArrayList<String>, Map<Integer,String>
 * 
 * 	Parameterized type with Bounds
 * 		List<? extends Number>, Consumer<? super String>
 */

package onlineCoaching.course2.generics.reflecting_types;

import java.util.ArrayList;
import java.util.List;

public class NonRefiableTypes<T> {
	public static void main(String[] args) {
		new NonRefiableTypes<String>().main();
	}	
		
		private void main() {
			List<String> strings = new ArrayList<>();
			List<Integer> integers = new ArrayList<>();
			System.out.println(strings.getClass());
			System.out.println(integers.getClass());
			System.out.println(strings.getClass() == integers.getClass());
			
			List<? extends Number> numbers = new ArrayList<Number>();
			System.out.println(numbers.getClass());
			System.out.println(numbers.getClass() == integers.getClass());
		}
}






