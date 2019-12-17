/*
 * 	Downsides and Tradeoffs
 * 		Once we hit runtime generics sort of dont exist, this leads to some issues,
 * 		where it looks like we can do certain things, which are banned
 * 
 * 		Overloads	
 * 		Checking the type of an Instance
 * 		Performance	
 */

/*
 * 	all generics are erased to java lang Object or some subclass or some interface that in some ways subclasses Object, no way you can get primitive int but Integer.
 * 	and these have some really bad performance issues
 *  int array are in contagious order while Integer array can be anywhere,
 *  
 *  	int									  java.lang.Integer
 *   4 bytes								4 bytes for int value
 *   Nothing else for arrays!				Object Header: 8-16 bytes
 *   										Alignment: allocate a multiple of 8 bytes
 *   										Pointer for arrays: 4 or 8 bytes
 *   										Worst case: 32bytes(8x fatter)								
 */

/*
 * 	One of the promoted thing in Java 10 is primitive specialization, generic implementation may change and we might have primitive ints in something like a list and thus save memory
 * 	
 */

/*
 * C# has reified generics, each type has its own type, much better efficiency.
 * but cannot migrate collections, they have two one legacy and one new
 */

package onlineCoaching.course2.generics;

import java.util.List;

 public class ImplicationsOfErasure {
	public static void main(String[] args) {
		System.out.println(new InstanceOfExample<>() instanceof InstanceOfExample);
		System.out.println(new InstanceOfExample<>() instanceof Object);
//		System.out.println(new InstanceOfExample<>() instanceof Integer); //Incompatible conditional operand types InstanceOfExample<Object> and Integer

		try {
			throw new UncompilableException();
		}catch(UncompilableException e) {
			e.printStackTrace();
		}
		
		
//		try {
//			throw new UncompilableException();
//		}catch(UncompilableException<T> e) {
//			e.printStackTrace();
//		}
	}
}

class Overloading{
	public void print(String param) {
		
	}
	
	public void print(Integer param) {
		
	}
	
	public void print(List<String> param) {
		
	}
	
//	//banned as they both get erased to the same type
//	public void print(List<Integer> param) {
//		
//	}	
}

class InstanceOfExample<T>{
	public boolean equals(Object o) {
		if(o instanceof InstanceOfExample) {
			return true;
		}
		
//		if(o instanceof InstanceOfExample)<T> {
//			return true;
//		} //illegal because at runtime that class doesnt exist
		
		
		return false;
	}
	
	
}


class UncompilableException extends Exception{
	
//class UncompilableException<T> extends Exception{ //you cant extends extend anything which you can throw new of , with generics	
	
}












