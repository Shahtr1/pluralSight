//	Sets are collections of distinct elements. There are no duplicates

/*
 * 	
 */

package onlineCoaching.course2.collections;
import static onlineCoaching.course2.collections.Product.BY_NAME;
import static onlineCoaching.course2.collections.Product.BY_WEIGHT;
import static onlineCoaching.course2.collections.ProductFixtures.*;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class SetsCollection {
	public static void main(String[] args) throws Exception {
		SetsCollection sc = new SetsCollection();
		ProductCatalogueTest pct = new ProductCatalogueTest();
		pct.shouldOnlyHoldUniqueProducts();
	}
}

class ProductCatalogue implements Iterable<Product>{
	
//	private final Set<Product> products = new HashSet<>();
	
//	//default constructor of TreeSet does not take any recipe on how should we order,
//	//we have to provide comparator, if we didnt provide any, it assumes that it implements Comparable
//	private final Set<Product> products = new TreeSet<>();
	
//	private final Set<Product> products = new TreeSet<>(BY_NAME);
	
//	private final SortedSet<Product> products = new TreeSet<>(BY_NAME);
	
	private final SortedSet<Product> products = new TreeSet<>(BY_WEIGHT);
	
	public void isSuppliedBy(Supplier supplier) {
		products.addAll(supplier.products());
	}
	
	@Override
	public Iterator<Product> iterator() {
		return products.iterator();
	}
	
	Set<Product> lightVanProducts(){
		Product heaviestLightVanProduct = findHeaviestLightVanProduct();
		return products.headSet(heaviestLightVanProduct);
	}

	private Product findHeaviestLightVanProduct() {
		for(Product product : products) {
			if(product.getWeight()>20) {
				return product;
			}
		}
		return products.last();
	}
	
	Set<Product> heavyVanProducts(){
		Product heaviestLightVanProduct = findHeaviestLightVanProduct();
		return products.tailSet(heaviestLightVanProduct);
	}
	
}

class ProductCatalogueTest{
	@Test
	public void shouldOnlyHoldUniqueProducts() throws Exception{
		ProductCatalogue catalogue = new ProductCatalogue();
		
		catalogue.isSuppliedBy(bobs);
		catalogue.isSuppliedBy(kates);
		
		assertThat(catalogue,containsInAnyOrder(door,floorPanel,window));
	}
	
	@Test
	public void shouldFindLightVanProducts() {
		ProductCatalogue catalogue = new ProductCatalogue();
		catalogue.isSuppliedBy(bobs);
		catalogue.isSuppliedBy(kates);
		
		assertThat(catalogue.lightVanProducts(),containsInAnyOrder(window));
	}
	
	@Test
	public void shouldFindHeavyVanProducts() {
		ProductCatalogue catalogue = new ProductCatalogue();
		catalogue.isSuppliedBy(bobs);
		catalogue.isSuppliedBy(kates);
		
		assertThat(catalogue.heavyVanProducts(),containsInAnyOrder(door,floorPanel));
	}
}









