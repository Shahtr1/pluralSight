/*
 * 	ViewsOverMaps
 * 		keySet(), values(), entrySet()
 */

package onlineCoaching.course2.collections;

import static onlineCoaching.course2.collections.ProductFixtures.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ViewsOverMaps {
	public static void main(String[] args) {
		final Map<Integer,Product> idToProduct = new HashMap<>();
		idToProduct.put(1, door);
		idToProduct.put(2, floorPanel);
		idToProduct.put(3,window);
		
		System.out.println(idToProduct);
		System.out.println();
		
		final Set<Integer> ids = idToProduct.keySet();
		System.out.println(ids);
		System.out.println();
		
		ids.remove(1);
		System.out.println(ids);
		System.out.println(idToProduct);
		System.out.println();
		
//		ids.add(4);//UnsupportedOperationException, dont know what value
		
		final Collection<Product> products = idToProduct.values();
		System.out.println(products);
		System.out.println();
		
		products.remove(floorPanel);
		System.out.println(products);
		System.out.println(idToProduct);
		System.out.println();
		
//		products.add(floorPanel);//UnsupportedOperationException, dont know what value
		
		final Set<Map.Entry<Integer, Product>> entries = idToProduct.entrySet();
		//entry set is a set of key value entry elements
		//we can loop over it
		
		for(Map.Entry<Integer, Product> entry : entries) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
			entry.setValue(floorPanel);
		}
		
		System.out.println(idToProduct);
	}
}








