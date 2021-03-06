//Maps store key/value pairs

/*
 * 	Common Map Types
 * 
 * 		Interface			Description
 * 	
 * 		Map					Basic map operations
 * 		SortedMap			Map whose keys are sorted
 * 
 *	//////////////////////////////////////////////////
 *		
 *		Class				Description
 *		
 *		HashMap				Efficient general purpose Map implementation
 *		TreeMap				SortedMap implemented as a self-balancing tree 
 *							Supports Comparable and Comparator sorting
 *	
 *	//////////////////////////////////////////////////////////
 *
 *	Common Map Methods
 *	
 *		Method				Description
 *
 *		put					Add key and value
 *		putIfAbsent			Add key and value if key not contained or value null
 *		get					Return value for key, if key not found return null
 *		getOrDefault		Return value for key, if key not found return the provided default value
 *		values				Return a Collection of the contained values
 *		keySet				Return a Set of the contained values
 *		
 *				also supports lambda expressions
 *		forEach				Perform action for each entry
 *		replaceAll			Perform action for each entry replacing the each key's value with action's result
 *	///////////////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *		Common SortedMap Methods
 *	
 *			Method			Description
 *
 *			firstKey		Return first key
 *			lastKey			Return last key
 *			headMap			Return a map for all keys that are less than the specified key
 *			tailMap			Return a map for all keys that are greater than or equal to the specified key
 *			subMap			Return a map for all keys that are greater than or equal to the starting key and less tha the ending key
 */

package onlineCoaching.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapCollections {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		
		map.put("2222","ghi");
		map.put("3333","abc");
		map.put("1111","def");
		
		String s1 = map.get("3333");
		String s2 = map.get("9999");
		String s3 = map.getOrDefault("9999","nope");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		//bi-consumer lambda expressions
		System.out.println("bi-consumer lambda expressions");
		map.forEach((k,v) -> System.out.println(k + " | " + v));
		
		//uses a bifunction
		System.out.println("uses a bifunction");
		map.replaceAll((k,v) -> v.toUpperCase());
		map.forEach((k,v) -> System.out.println(k + " | " + v));
		
		//Using sortedMap
		SortedMap<String,String> map1 = new TreeMap<>();
		map1.put("2222", "ghi");
		map1.put("3333", "abc");
		map1.put("1111", "def");
		map1.put("6666", "xyz");
		map1.put("4444", "mno");
		map1.put("5555", "pqr");
		System.out.println("Using sortedMap");
		map.forEach((k,v) -> System.out.println(k + " | " + v));
		
		System.out.println("Using sortedMap headMap method");
		SortedMap<String,String> hMap = map1.headMap("3333");
		hMap.forEach((k,v) -> System.out.println(k + " | " + v));
		
	}
}
















