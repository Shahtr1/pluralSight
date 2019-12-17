/*
 * 	Why use a Map?
 * 		
 */

/*
 * 	Adding & Replacing
 * 		V put(K key, V value)
 * 		void putAll(Map<? extends K,? extends V> values)
 * 
 * 		put(for a single value, putAll for another Map)
 * 		null keys and values are implementation specific
 * 
 */

/*	
 * 	Looking up Elements
 * 		Objects to allow more flexible generics contracts
 * 		
 * 		V get(Object key)
 * 		boolean containsKey(Object key)
 * 		boolean containsValue(Object value)
 * 			Object arguments for flexibility
 * 		
 */

/*
 * 	Removing
 * 		V remove(Object key)
 * 		void clear()
 */

/*
 * 	Querying the size
 * 	Same semantics as on Collection
 * 		int size()
 * 		boolean isEmpty()
 * 	
 */

/*
 * 					Collection and Map
 * 		Map is the only collections that don't extend or implement the Collection interface
 * 
 */

package onlineCoaching.course2.collections;

import static onlineCoaching.course2.collections.LookupTableComparison.runLookups;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Maps {
	public static void main(String[] args){
		runLookups(new MapProductLookupTable());
		runLookups(new NaiveProductLookupTable());
	}
}

class NaiveProductLookupTable implements ProductLookupTable{
	
	private List<Product> products = new ArrayList<>();
	
	@Override
	public Product lookupById(final int id) {
		for(Product product:products) {
			if(product.getId()==id) {
				return product;
			}
		}
		return null;
	}

	@Override
	public void addProduct(Product productToAdd) {
		for(Product product : products) {
			if(product.getId() == productToAdd.getId()) {
				throw new IllegalArgumentException("Unable to add product, duplicate id for "+productToAdd);
			}
		}
		products.add(productToAdd);
	}

	@Override
	public void clear() {
		products.clear();
	}
	
}


class MapProductLookupTable implements ProductLookupTable{
	
	private final Map<Integer,Product> idToProduct = new HashMap<>(); 
	
	@Override
	public void addProduct(final Product productToAdd) {
		final int id = productToAdd.getId();
		if(idToProduct.containsKey(id)) {
			throw new IllegalArgumentException("Unable to add product, duplicate id for "+productToAdd);
		}
		idToProduct.put(id, productToAdd);
	}

	@Override
	public void clear() {
		idToProduct.clear();
	}

	@Override
	public Product lookupById(final int id) {
		return idToProduct.get(id);
	}
	
}

class LookupTableComparison{
	private static final int ITERATIONS = 5;
	private static final int NUMBER_OF_PRODUCTS = 20_000;
	
	private static final List<Product> products = generateProducts();
	
	private static List<Product> generateProducts(){
		final List<Product> products = new ArrayList<>();
		final Random weightGenerator = new Random();
		for(int i=0;i<NUMBER_OF_PRODUCTS;i++) {
			products.add(new Product(i,"Product" + i,10 + weightGenerator.nextInt(10)));
		}
		Collections.shuffle(products);
		Collections.shuffle(products);
		Collections.shuffle(products);
		return products;
	}
	
	static void runLookups(final ProductLookupTable lookupTable) {
		final List<Product> products = LookupTableComparison.products;
		System.out.println("Running lookups with " + lookupTable.getClass().getSimpleName());
		
		for(int i = 0;i < ITERATIONS; i++) {
			final long startTime = System.currentTimeMillis();
			
			for(Product product : products) {
				lookupTable.addProduct(product);
			}
			
			for(Product product : products) {
				final Product result = lookupTable.lookupById(product.getId());
				if(result != product) {
					throw new IllegalStateException("Lookup Table returned wrong result for "+product);
				}
			}
			lookupTable.clear();
			
			System.out.println(System.currentTimeMillis() - startTime + "ms");
		}
	}
}


interface ProductLookupTable{
	Product lookupById(final int id);
	void addProduct(Product productToAdd);
	void clear();
}












