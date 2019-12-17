/*
 * 	Sorted and navigable maps extend the map interface
 * 		traversal in Key Ascending Order
 * 		SortedMap superseded by NavigableMap
 * 
 */

/*
 * 	SortedMap
 * 		Defines an interface for a map with ordering
 * 		Subviews based upon key
 * 
 * 		K firstKey();
 * 		K lastKey();
 * 
 * 		SortedMap<K, V> tailMap(E fromKey);
 * 		SortedMap<K, V> headMap(E toKey);
 * 		SortedMap<K, V> subMap(K fromKey, K toKey);
 * 
 * 	In order to define the sort order , we need to provide a key thats comparable or have a specific comparator
 */

/*	
 * 	NavigableMap
 * 		First/Last Entries
 * 			Poll methods remove element as well as returning it
 * 
 * 		Map.Entry<K, V> firstEntry();
 * 		Map.Entry<K, V> lastEntry();
 * 
 * 		Map.Entry<K, V> pollFirstEntry();
 * 		Map.Entry<K, V> pollLastEntry();
 * 
 * 		////////////////////////////////////////////////////////////////////
 * 
 * 	Navigating by key
 * 		Allows moving to a lower/higher element in the map
 * 		
 * 		Map.Entry<K, V> lowerEntry(K key);
 * 		Map.Entry<K, V> higherEntry(K key);
 * 
 * 		K lowerKey(K key);
 * 		K higherKey(K key);	
 * 
 * 		///////////////////////////////////////////////////////////////////////
 * 
 * 	Navigating by key
 * 		Allows moving to a less than or equal/greater than or equal element in the map
 * 
 * 		Map.Entry<K, V> floorEntry(K key);
 * 		Map.Entry<K, V> ceilingEntry(K key);
 * 
 * 		K floorKey(K key);
 * 		K ceilingKey(K key);
 * 
 * 		////////////////////////////////////////////////////////////////////////
 * 
 * 	Reversing the order
 * 		Can't override keySet() due to backwards compatibility concerns
 * 		
 * 		NavigableMap<K, V> descendingMap()
 * 		NavigableSet<K> descendingKeySet()
 * 		
 * 		NavigableSet<K> navigableKeySet()	
 * 
 * 		////////////////////////////////////////////////////////////////////////
 * 
 * 	NavigableMap Views
 * 		NavigableMap<K, V> tailMap(E fromKey, boolean incl);
 * 		NavigableMap<K, V> headMap(E toKey, boolean incl);
 * 
 * 		NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
 */


package onlineCoaching.course2.collections;

public class SortedAndNavigableMaps {
	public static void main(String[] args) {
		
	}
}












