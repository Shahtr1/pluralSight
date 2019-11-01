/*
 * 	Altering and Removing
 * 
 * 	replace(key,value)
 * 		update the value, and if key is not in map, it won't do anything
 * 
 * 	replaceAll(BiFunction<K,V,V>)
 * 		it takes a bifunction , a function that takes a key nd a map and returns the new value, it lets you update all the elements in one go
 * 
 * 	remove(key,value)
 * 		overloaded remove function, only removes  the one having the key and that value
 */

/*
 * 			Updating Values
 * 		getOrDefault()
 * 		putIfAbsent()
 * 		compute()
 * 		computIfAbsent()
 * 		computeIfPresent()
 * 		merge()
 */

/*
 * 	forEach - callback based iteration
 */

package onlineCoaching.course2.collections;

import static onlineCoaching.course2.collections.ProductFixtures.door;
import static onlineCoaching.course2.collections.ProductFixtures.floorPanel;
import static onlineCoaching.course2.collections.ProductFixtures.window;

import java.util.HashMap;
import java.util.Map;

public class Java8MapEnhancements {
	public static void main(String[] args) {
		
		final Product defaultProduct = new Product(-1, "Whatever the customer wants",100);
		
		final Map<Integer,Product> idToProduct = new HashMap<>();
		
		idToProduct.put(1, door);
		idToProduct.put(2, floorPanel);
		idToProduct.put(3, window);
		
//		Product result = idToProduct.getOrDefault(10, defaultProduct);
//		System.out.println(result);
//		System.out.println(idToProduct.get(10));
//		System.out.println();
		
//		Product result = idToProduct.replace(1, new Product("Big Door", 50));
//		System.out.println(result);
//		System.out.println(idToProduct.get(1));
//		//if the key was not before, it won't update anything
		
		System.out.println(idToProduct);
		
//		idToProduct.replaceAll((id,oldProduct) -> new Product(id, oldProduct.getName(),oldProduct.getWeight() + 10));
//		System.out.println(idToProduct);
		
//		Product result = idToProduct.computeIfAbsent(10, (id)->new Product(id,"Custom product",10));
//		System.out.println(result);
//		System.out.println(idToProduct.get(10));
		
		idToProduct.forEach((key,value) -> {
			System.out.println(key + " -> " + value);
		});
	}
}











