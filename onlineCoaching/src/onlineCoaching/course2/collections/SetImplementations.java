/*
 * 	HashSet,TreeSet,EnumSet
 * 		HashSet and TresSet both implements Set interface.
 * 		TreeSet also implement the SortedSet and NavigableSet interface.
 * 		EnumSet is designed efficient when dealing with enum types
 */

/*
 * 	HashSet
 * 		Based upon HashMap
 * 			Calls hashCode() on element and looks up location
 * 		Good general purpose implementation
 * 			Again resizes when it runs out of space	
 * 
 * 		
 * 					THE EQUALS/HASHCODE CONTRACT	
 * 		object.equals(other)
 * 
 * 			==>
 * 	
 * 		object.hashCode() == other.hashCode()
 * 
 * 			
 */

/*
 *				Correct Hashcodes
 *	Combine hashcode information from each field
 *		- result = 31 * result + obj.hashCode();
 *		- Arrays.hashCode() for arrays
 *		- (int) (l ^ (l >>> 32)) for longs
 *		- Float.floatToIntBits(f);
 *
 * 	Let your IDE do the heavy lifting
 * 	Or use Objects.hashCode();
 * 	Always use the same fields as equals()	
 */

 /*
  *  TreeSet
  *  	Based upon TreeMap
  *  		Uses a Binary Tree with a required sort order
  *  		Either it implements Comparable, or you need to provide comparator to the constructor of the TreeSet inorder to define that order
  *  
  *  	Keeps elements in the given order
  *  		See SortedSet and NavigableSet
  */

/*
 * 	EnumSet
 * 		Specialized implementation for enums
 * 			Uses a bitset based upon the ordinal of the enum
 * 		Use when storing sets of enums
 */

/*
 * 				Algorithmic performance
 * 					add				contains			next
 * 	 HashSet	 O(N),Ω(1)			O(N),Ω(1)		  O(Capacity/N)
 * 	 TreeSet	 O(log N)			O(log N)		    O(log N)
 * 	 EnumSet	   O(1)				  O(1)             	  O(1)		
 */

package onlineCoaching.course2.collections;

public class SetImplementations {

}






