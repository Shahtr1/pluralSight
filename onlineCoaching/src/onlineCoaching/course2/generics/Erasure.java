/*
 * 	Translation at compile time, not runtime
 * 	Generics representation	 is a lie, it only exists as a source code of the java program
 * 	And as we translate it to bytecode we erase or remove those generic types
 * 	Not all the information, a lot of info is still retained at runtime
 */

/*
 * 	How are Generics Implemented?
 * 		Erase Type Parameters
 * 		Add casts
 * 		Add Bridge Methods
 */

/*
 * 	List of type Integer and string will all be erased to List
 * 		List<String>,List<Integer>,List<List<Integer>> --->  List
 * 		
 * 		List<String>[] --->  List[]
 * 		
 * 		T without bounds --->  Object
 * 
 *  	T extends Foo ---> Foo
 */

package onlineCoaching.course2.generics;

import java.util.List;

public class Erasure<T, B extends Comparable<B>> {
	public void unbounded(T param) {
		
	}
	public void lists(List<String> param, List<List<T>> param2) {
		String s = param.get(0);
	}
	
	public void bounded(B param) {
		
	}
	
//	//on cmd please
//	javap -s classname
	
	/*
	 * C:\Users\Shahrukh\Desktop>javap -s Erasure.class
		Compiled from "Erasure.java"
		public class onlineCoaching.course2.generics.Erasure<T, B extends java.lang.Comparable<B>> {
		  public onlineCoaching.course2.generics.Erasure();
		    descriptor: ()V
		
		  public void unbounded(T);
		    descriptor: (Ljava/lang/Object;)V
		    	takes a java lang Object and returns a void
		    	V here stands for void
		    	our unbounded method returns void, thats the type that the JVM understands under the hood
		
		  public void lists(java.util.List<java.lang.String>, java.util.List<java.util.List<T>>);
		    descriptor: (Ljava/util/List;Ljava/util/List;)V
		    takes two lists as params and returns void
		
		  public void bounded(B);
		    descriptor: (Ljava/lang/Comparable;)V
		    takes param Comparable and return void
		    
		    /////////So types have been erased
		     * 
		     *
	 */
	
	/*
	 *  now add -c , it will actually decompile bytecode further
	 *  
	 *  C:\Users\Shahrukh\Desktop>javap -s -c Erasure.class
			Compiled from "Erasure.java"
			public class onlineCoaching.course2.generics.Erasure<T, B extends java.lang.Comparable<B>> {
			  public onlineCoaching.course2.generics.Erasure();
			    descriptor: ()V
			    Code:
			       0: aload_0
			       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
			       4: return
			
			  public void unbounded(T);
			    descriptor: (Ljava/lang/Object;)V
			    Code:
			       0: return
			
			  public void lists(java.util.List<java.lang.String>, java.util.List<java.util.List<T>>);
			    descriptor: (Ljava/util/List;Ljava/util/List;)V
			    Code:
			       0: aload_1
			       1: iconst_0
			       2: invokeinterface #2,  2            // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
			       7: checkcast     #3                  // class java/lang/String
			      10: astore_3
			      11: return
			
			  public void bounded(B);
			    descriptor: (Ljava/lang/Comparable;)V
			    Code:
			       0: return
	 */
}









