/*
 * 	Lists are collections with iteration order
 * 	each element has index which says where there position is
 * 	
 */

/*	Methods of List
 * 		void add(int index,E e);
 * 		E get(int index);
 * 		E remove(int index);
 * 		E set(int index,E element); //replaces
 * 		boolean addAll(int index, Collection<? extends E> c);
 * 		
 * 		int indexOf(Object o);
 * 		int lastIndexOf(Object o);
 * 
 * 		List<E> subList(int fromIndex,int toIndex); //this is a view, which means that if we add something here it would be added to original, as it is only a view
 * 			fromIndex is inclusive, and toIndex is exclusive
 */

package onlineCoaching.course2.collections;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.contains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class ListInterface {
	public static void main(String[] args) throws Exception {
		ShipmentTest test = new ShipmentTest();
		//test.shouldAddItems();
//		test.shouldReplaceItems();
//		test.shouldNotReplaceMissingItems();
		test.shouldIdentifyVanRequirements();
	}
}

class ShipmentTest{
	private Shipment shipment = new Shipment();
	
	@Test
	public void shouldAddItems() throws Exception{
		shipment.add(ProductFixtures.door);
		shipment.add(ProductFixtures.window);
		
		assertThat(shipment, contains(ProductFixtures.door,ProductFixtures.window));
	}
	
	@Test
	public void shouldReplaceItems()throws Exception{
		shipment.add(ProductFixtures.door);
		shipment.add(ProductFixtures.window);
		
		shipment.replace(ProductFixtures.door,ProductFixtures.floorPanel);
		assertThat(shipment,contains(ProductFixtures.floorPanel,ProductFixtures.window));
	}
	
	@Test
	public void shouldNotReplaceMissingItems() {
		shipment.add(ProductFixtures.window);
		shipment.replace(ProductFixtures.door, ProductFixtures.floorPanel);
		assertThat(shipment,contains(ProductFixtures.window));
	}
	
	@Test
	public void shouldIdentifyVanRequirements() {
		shipment.add(ProductFixtures.door);
		shipment.add(ProductFixtures.floorPanel);
		shipment.add(ProductFixtures.window);
		
		shipment.prepare();
		
		assertThat(shipment.getLightVanProducts(),contains(ProductFixtures.window));
		assertThat(shipment.getHeavyVanProducts(),contains(ProductFixtures.floorPanel,ProductFixtures.door));
		
	}
}

class ProductFixtures{
	public static Product door = new Product("Wooden Door",35);
	public static Product floorPanel = new Product("Floor Panel",25);
	public static Product window = new Product("Glass Window",10);
	
	public static Supplier bobs = new Supplier("Bob's Household Supplies");
	public static Supplier kates = new Supplier("Kate's Home Goods");
	
	static {
		bobs.products().add(door);
		bobs.products().add(floorPanel);
		bobs.products().add(window);
		
		kates.products().add(floorPanel);
//		kates.products().add(door);
		kates.products().add(new Product("Wooden Door",35));
		kates.products().add(window);
	}
}

class Supplier{
	private String supplierName;
	List<Product> pl = new ArrayList<>();
	
	public Supplier(String supplierName) {
		this.supplierName=supplierName;
	}

	public List<Product> products() {
		return pl;
	}

	public String getSupplierName() {
		return supplierName;
	}
	
}

class Shipment implements Iterable<Product>{
	
	private static final int LIGHT_VAN_MAX_WEIGHT = 20;
	private static final int PRODUCT_NOT_PRESENT = -1;
	
	private final List<Product> products = new ArrayList<>();
	
	private List<Product> lightVanProducts;
	private List<Product> heavyVanProducts;
	
	public void add(Product product) {
		products.add(product);
	}
	
	public void replace(Product oldProduct,Product newProduct) {
		final int index =  products.indexOf(oldProduct);
		if(index != PRODUCT_NOT_PRESENT)
			products.set(index, newProduct);
	}
	
	public void prepare() {
		//sort our list of products by weight
//		Collections.sort(products,Product.BY_WEIGHT); //if we are using java less than 8
		products.sort(Product.BY_WEIGHT);//for java 8
		//it takes comparator as an argument, comparator is an interface that defines ordering in java
		
		
		//find the product index that needs the heavy van
		int splitPoint = findSplitPoint();
		
		//assigns the views of the product list for heavy and light vans
		lightVanProducts = products.subList(0, splitPoint);
		heavyVanProducts = products.subList(splitPoint, products.size());
	}
	
	private int findSplitPoint() {
		for(int i=0;i<products.size();i++) {
			final Product product = products.get(i);
			if(product.getWeight() > LIGHT_VAN_MAX_WEIGHT) {
				return i;
			}
		}
		return 0;
	}
	
	public List<Product> getHeavyVanProducts(){
		return heavyVanProducts;
	}
	
	public List<Product> getLightVanProducts(){
		return lightVanProducts;
	}

	@Override
	public Iterator<Product> iterator() {
		
		return products.iterator();
	}
	
}











