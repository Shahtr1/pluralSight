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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListInterface {
	public static void main(String[] args) throws Exception {
		ShipmentTest test = new ShipmentTest();
		test.shouldAddItems();
	}
}

class ShipmentTest{
	private Shipment shipment = new Shipment();
	
	public void shouldAddItems() throws Exception{
		shipment.add(ProductFixtures.door);
		shipment.add(ProductFixtures.window);
		
	}
	
	public void shouldReplaceItems()throws Exception{
		shipment.add(ProductFixtures.door);
		shipment.add(ProductFixtures.window);
		
		shipment.replace(ProductFixtures.door,ProductFixtures.floorPanel);
	}
}

class ProductFixtures{
	public static Product door = new Product("Wooden Door",35);
	public static Product floorPanel = new Product("Floor Panel",25);
	public static Product window = new Product("Glass Window",10);
}

class Shipment implements Iterable<Product>{
	
	private static final int LIGHT_VAN_MAX_WEIGHT = 20;
	
	private final List<Product> products = new ArrayList<>();
	
	public void add(Product product) {
		products.add(product);
	}
	
	public void replace(Product oldProduct,Product newProduct) {
		
	}
	
	public void prepare() {
		
	}
	
	public List<Product> getHeavyVanProducts(){
		return null;
	}
	
	public List<Product> getLightVanProducts(){
		return null;
	}

	@Override
	public Iterator<Product> iterator() {
		
		return products.iterator();
	}
	
}










