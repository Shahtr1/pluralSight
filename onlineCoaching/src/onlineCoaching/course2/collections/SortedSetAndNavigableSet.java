/*
 * 	SortedSet and NavigableSet
 * 
 * 		SortedSet
 * 			Defines an order
 * 			No indexes, but subset views possible 
 * 		
 * 			E first();
 * 			E last();
 * 			SortedSet<E> tailSet(E fromElement);
 * 			SortedSet<E> headSet(E toElement);
 * 			SortedSet<E> subSet(E fromElement, E toElement);
 * 			to is always excluded			
 * 
 * 
 * 		NavigableSet
 * 			Extends SortedSet
 * 			Provides ways to move through the order
 * 			Implemented by TreeSet
 * 
 * 			E lower(E e);
 * 			E higher(E e);
 * 			E floor(E e);
 * 			E ceiling(E e);
 * 			E pollFirst();
 * 			E pollLast();
 */

package onlineCoaching.course2.collections;

public class SortedSetAndNavigableSet {
	public static void main(String[] args) throws Exception {
		ProductCatalogueTest pct = new ProductCatalogueTest();
		pct.shouldOnlyHoldUniqueProducts();
		pct.shouldFindHeavyVanProducts();
		pct.shouldFindLightVanProducts();
	}
}




