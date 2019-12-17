/*
 * 	Functional Interfaces
 * 		A great use case for wildcards
 * 		
 * 	Lambda expressions have types which are functional Interfaces, and those interfaces have a single abstract method on
 *  	
 *  	The Comparator Interface
 *  		Comparator<T> -> int compare(T o1, T o2);
 *  		Comparator<Foo>
 *  		Comparator<? super Foo> //because its data going in
 *  
 *   	The Function Interface
 *   		Function<T, R> -> R apply(T arg)
 *   		Function<Foo, Bar>
 *   		Function<? super Foo, ? extends Bar>
 */

package onlineCoaching.course2.generics.advanced;

public class FunctionalInterfaces {
	public static void main(String[] args) {
		
	}
}
