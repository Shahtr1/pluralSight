package onlineCoaching.course2.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectonUtilities {
	public static void main(String[] args) {
		Product door = ProductFixtures.door;
		Product floorPanel = ProductFixtures.floorPanel;
		Product window = ProductFixtures.window;
		
		List<Product> products = new ArrayList<>();
//		products.add(door);
//		products.add(floorPanel);
//		products.add(window);
		Collections.addAll(products, door,floorPanel,window);
		
		final Product product = Collections.min(products,Product.BY_NAME);
		System.out.println(product);
		
		final Product productW = Collections.max(products,Product.BY_WEIGHT);
		System.out.println(productW);
	}
}
