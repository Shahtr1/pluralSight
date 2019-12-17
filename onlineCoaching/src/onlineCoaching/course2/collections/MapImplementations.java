/*
 * 	Three General Purpose Maps
 * 		HashMap
 * 		LinkedHashMap
 * 		TreeMap
 */

/*
 * 			HashMap
 * 		Good general purpose implementation
 * 		takes the hashcode of key object
 * 		Uses the .hashcode() method (just like HashSet)
 * 		Maintains an array of buckets
 * 			->  hash % bucket_count
 * 		Buckets are linked lists to accommodate collisions
 * 		Buckets can be trees
 * 		The number of buckets increases with more elements
 */

/*
 * 	MutableHashMapKeys
 * 		if you got a string a value as a key, you can call hashcode method on it repeatedly
 * 		and you will get the same hashcode upon future calls. What if we break that contract?
 */

/*
 * 	TreeMap
 * 		Implemented using red-black tree
 * 			A balanced Binary Tree
 * 		Implements Navigable and Sorted
 * 			Uses comparable/comparator to define the order
 * 		TreeMap is the only implementation in the java core library that implements Navigable and SortedMap
 */

/*
 * 	LinkedHashMap
 * 		A guaranteed order of reversal
 * 			Either the order in which you insert the keys, or in which you access them		
 * 
 * 		Based Upon HashMap
 * 		Maintains an Order
 * 		Either Insertion, or Access
 * 
 * 		Helpful for implementing Caches
 * 			Called by the out and putAll methods
 * 				protected boolean removeEldestEntry(Map.Entry<K, V> eldest)		
 * 	
 */

/*
 * 	WeakHashMap
 * 		Weak references keys
 * 			they are associated with the keys but doesn't keep the object alive, and hence are garbage collected
 * 		Can be removed when unreachable
 * 		Used as a cache
 * 
 * 	EnumMap
 * 		Use if you have keys that are enums
 * 			Faster than other maps
 * 		Implementation based upon bitsets
 * 			Stores a single long for <= 64 elements
 * 
 * 		A bitset is where you take a long, and each element in that bitset corresponds to whether an entry is
 * 		there or not. So it's set if the element is there, or the bit is off if it's not there
 */

/*
 * 							Algorithmic Performance
 * 					   put				 get/containsKey				next
 * 	HashMap			 O(N),Ω(1)			  O(log N),Ω(1)            O(Capacity/N)
 *  LinkedHashMap	 O(N),Ω(1)			  O(log N),Ω(1)            O(Capacity/N)
 *  IdentityhashMap	 O(N),Ω(1)			    O(N),Ω(1)              O(Capacity/N)
 *  TreeMap			 O(log N)				O(log N)				O(log N)
 *  EnumMap				O(1)				  O(1)					  O(1)			
 */


package onlineCoaching.course2.collections;

public class MapImplementations {
	public static void main(String[] args) {
		
	}
}
























