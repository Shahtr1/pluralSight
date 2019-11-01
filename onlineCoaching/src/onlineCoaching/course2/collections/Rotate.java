package onlineCoaching.course2.collections;

import static onlineCoaching.course2.collections.ProductFixtures.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rotate {
	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(door);
		products.add(floorPanel);
		products.add(window);
		
		System.out.println(products);
		System.out.println();
		
		Collections.rotate(products, 1);
		System.out.println(products);
		System.out.println();
		
		Collections.rotate(products, 1);
		System.out.println(products);
		System.out.println();
		
		Collections.rotate(products, 1);
		System.out.println(products);
		System.out.println();
	}
}
