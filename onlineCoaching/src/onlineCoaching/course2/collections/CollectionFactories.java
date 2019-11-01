/*
 * 	factories are static method of the collection that will create us a new collection with some specific properties
 * 		Singletons
 * 			Immutable single value of collection
 * 			Use when you want to pass a single value to a method that takes a collection	
 * 			Set<Integer> set = Collections.singleton(1);
 * 			List<String> list = Collections.singletonList("one");
 * 			Map<Integer, String> map = Collections.singletonMap(1,"one");
 * 		
 * 		Empty Collections
 * 			Immutable empty collection
 * 			Use when you want to pass a no values to a method that takes a collection
 * 			Set<Integer> set = Collections.emptySet();
 * 			List<String> list = Collections.emptyList();
 * 			Map<Integer, String> map = Collections.emptyMap();			
 * 		Unmodifiable collection factory
 * 			it provides us a view that we can't modify it
 */

package onlineCoaching.course2.collections;

import static onlineCoaching.course2.collections.ProductFixtures.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionFactories {
	public static void main(String[] args) {
		ShoppingBasket s = new ShoppingBasket();
		s.add(door);
		System.out.println(s);
		
		s.getItems().add(window);
		System.out.println(s);//the total weight should be 45, it is 35
	}
}


class ShoppingBasket{
	private final List<Product> items = new ArrayList<>();
	private int totalWeight = 0;
	
	public void add(Product product) {
		items.add(product);
		totalWeight += product.getWeight();
	}
	
//	public List<Product> getItems(){
//		return items;
//	}
	
	public List<Product> getItems(){
		return Collections.unmodifiableList(items);
	}
	
	public String toString() {
		return "Shopping Basket of \n" + items + "\nwith weight: " + totalWeight;
	}
	
}















