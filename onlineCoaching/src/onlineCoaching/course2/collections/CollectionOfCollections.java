/*
 * 							Collection							|		
 * 								 								|
 * 			List				Set				Queue			|	Map	
 * 	     (ArrayList)		  (HashSet)		(PriorityQueue)		| (HashMap)					
 * 		 (LinkedList)			  |					|			|	  |
 * 							  SortedSet			  Deque			| SortedMap
 * 							  (TreeSet)		   (LinkedList)		| (TreeMap)
 * 											   (ArrayDeque)		|
 */

/*
 * 			Interfaces							Implementation
 * 		Multiple Data Structures				Specific Data Structure
 * 		Functional Characteristics				Performance Characteristics
 * 		Prefer as a variable type				Concrete and Instantiable
 * 		Often has a popular implementation
 */

/*
 * 							Deciding which Collection to pick
 *																					  Map	 							
 * 									ELEMENTS ARE KEYED?								   |			
 * 				   Set						|		\_______________YES                |No
 * 					|No						|No                      Order is Important|
 * 					Order is Important?		|										   |Yes	 
 * 					|Yes		^------Elements are Unique?                            |
 * 				 SortedSet								\							SortedMap	
 * 														 \No
 * 											No			  \
 * 							LIFO  <----------------------FIFO
 * 						No	/  \ Yes                 Yes / \ Yes
 * 						   /	\_________Deque_________/   \
 * 						List							   Queue		
 */

/*
 *  all collections extend Collection interface which inturn extend Iterable interface
 *  An iterable defines something which can be iterated over
 * 	 
 */

/*
 * 					Outline of Collection Interface
 * 	size()						Get the number of elements in the Collection
 * 	isEmpty()					True if size() == 0,false otherwise
 * 	add(element)				Add the element at the beginning of this collection
 * 	addAll(collection)			Add all the elements of the argument collection to this collection
 * 	remove(element)				Remove the element from this collection
 * 	removeAll(collection)		remove all the elements of the argument collection to this collection
 * 	retainAll(collection)		remove all the elements of this collection not in the argument collection
 *  contains(element)			True if the element is in this collection,false otherwise
 *  containsAll(collection)		True if all the elements of the argument collection are in this collection
 *  clear()						Remove all the elements from this collection
 */

package onlineCoaching.course2.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class CollectionOfCollections {
	public static void main(String[] args) {
		Product door = new Product("Wooden Door",35);
		Product floorPanel = new Product("Floor Panel",25);
		Product window = new Product("Glass Window",10);
		
		Collection<Product> products = new ArrayList<>();
		products.add(door);
		products.add(floorPanel);
		products.add(window);
		
//		System.out.println(products);
		
		Iterator<Product> productIterator= products.iterator();
		while(productIterator.hasNext()) {
			Product product = productIterator.next();
			System.out.println(product);
		}
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		
		for(Product product : products)
			System.out.println(product);
		
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		
		//So why iterator????????????????????????????
		/*
		 * 	if the weight is above 20 kgs print product, if below remove the product from collection
		 * 
		 */
								//This is WHY?
//		Iterator<Product> WhyIterator= products.iterator();
//		while(WhyIterator.hasNext()) {
//			Product product = WhyIterator.next();
//			if(product.getWeight()>20)
//				System.out.println(product);
//			else
//				WhyIterator.remove();
//		}
		
		System.out.println(products.size());
		System.out.println(products.isEmpty());
		System.out.println(products.contains(window));
		System.out.println(products.contains(door));
		
		Collection<Product> otherProducts = new ArrayList<>();
		otherProducts.add(window);
		otherProducts.add(door);
		
		//products.removeAll(otherProducts);
		
		System.out.println(products);
		
		System.out.println("\\\\\\\\\n trying with for loop the above iterator");
		for(Product product: products) {
			if(product.getWeight()>20)
				System.out.println(product);
			else
				products.remove(product);
		}
		
		System.out.println(products);
		//concurrentModificationException
	}
	
	
}

class Product{
	//for java less than 8
//	public static final Comparator<Product> BY_WEIGHT = new Comparator<Product>() {
//		public int compare(final Product p1,final Product p2) {
//			return Integer.compare(p1.getWeight(),p2.getWeight());
//		}
//	};
	
	//for java 8
	//comparing from the Comparable interface
	public static final Comparator<Product> BY_WEIGHT = Comparator.comparing(Product::getWeight);
	
	public static final Comparator<Product> BY_NAME = Comparator.comparing(Product::getName);

	private final String name;
	private final int weight;
	
	public Product(String name,int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}
	
	
	public String toString() {
		return "Product{"+"name="+name+",weight="+weight+'}';
	}

	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + weight;
//		return result;
		
		//Java 7 introduced a class called Objects
		return Objects.hash(name,weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (weight != other.weight)
//			return false;
//		return true;
		return Objects.equals(name, other.name);
	}
	
	
}









