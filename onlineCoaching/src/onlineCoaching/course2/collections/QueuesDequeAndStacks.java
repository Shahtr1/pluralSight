/*
 * 	First In, First Out
 * 	Queue
 * 		Adding elements
 * 			boolean offer(E e)
 * 			boolean add(E e)
 * 
 * 			offer (returns false if the queue is full)
 * 			add (exceptions if the queue is full)
 * 				Collection API requires that it only returns false if element is already present
 * 				
 * 			E remove() //corner case is when it is empty, so throws exception
 * 			E poll() //returns null when queue is empty
 * 			
 * 			Read without removing
 * 				E element()
 * 				E peek()
 * 				element throws Exception when empty,peek returns null
 * 			
 */

/*
 * 	Priority Queues
 * 		Highest Priority Out
 * 		Priority really just defines ordering
 * 	
 */

/*
 * 	Stacks
 * 	Last In, First Out
 * 		But Stack implementation is deprecated in Java, Why?
 * 			The original implementation of java.util.Stack was not very good, it synchronized all of its methods, to be thread safe
 * 			when many uses of stacks don't need thread safety.
 * 		Java introduces Deques(Double Ended Queues)
 */

/*
 *  Deque(Double Ended Queue)
 *  	Correct way to use stacks
 *  	can add or remove from both ends
 *  	Deque Interface extends the Queue interface
 *  
 *  	Adding elements
 *  		boolean offerFirst(E e)
 *  		boolean offerLast(E e)
 *  		void addFirst(E e)
 *  		void addLast(E e)
 *  	
 *  		offer (returns false if the queue is full)
 *  		add(inherited from Collection,throws an exception if the queue is full)  	  	
 *  		
 *  	Removing and returning the element
 *  		E removeFirst()
 *  		E removeLast()
 *  		E pollFirst()
 *  		E pollLast()
 *  		
 *  		remove throws Exception when empty, poll returns null
 *  
 *  	Read without removing
 *  		E getFirst()
 *  		E getLast()
 *  		E peekFirst()
 *  		E peekLast()
 *  
 *  		get throws Exception when empty , peek returns null
 *  
 *  	Semantic naming for Stacks/LIFO
 *  		void push(E e)
 *  		E pop()
 */

/*
 * 	Implementations of Queue
 * 							Comparison Layout
 * 		ArrayDeque									LinkedList
 * 	RingBuffer based implementation				Previously discussed in Lists
 * 	Constant time addition/removal				Very seldom used as a Queue
 * 	Less Memory,Faster							Has random access!
 * 													- But its O(N)
 * 	No random access							Allows null elements(bad)
 * 
 * 					prefer ArrayDeque than LinkedList	
 */



package onlineCoaching.course2.collections;

import static onlineCoaching.course2.collections.Category.PRINTER;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Predicate;

public class QueuesDequeAndStacks {
	public static void main(String[] args) {
//		HelpDesk h = new HelpDesk();
//		h.enquire(Customer.JACK, Category.PHONE);
//		h.enquire(Customer.JILL, Category.PRINTER);
//		
//		h.processAllEnqueries();
		
//		CategorisedHelpDesk h = new CategorisedHelpDesk();
//		h.enquire(Customer.JACK, Category.PHONE);
//		h.enquire(Customer.JILL, Category.PRINTER);
//		
//		h.processPrinterEnquiry();
//		h.processGeneralEnquiry();
//		h.processPrinterEnquiry();
		
		
//		PriorityHelpDesk p = new PriorityHelpDesk();
//		p.enquire(Customer.JACK, Category.PHONE);
//		p.enquire(Customer.JILL, Category.PRINTER);
//		p.enquire(Customer.MARY, Category.COMPUTER);
//		
//		p.processAllEnqueries();
	}
}

class HelpDesk{
	
	private final Queue<Enquiry> enquiries = new ArrayDeque<>();
	
	public void enquire(final Customer customer,final Category category) {
		enquiries.offer(new Enquiry(customer, category));
	}
	
	public void processAllEnqueries() {
//		while(!enquiries.isEmpty()) {
//			final Enquiry enquiry = enquiries.remove();
//			enquiry.getCustomer().reply("Have you tried turning it off and on again?");
//		}
		
		//for poll method
			Enquiry enquiry;
			while((enquiry = enquiries.poll()) != null) {
				enquiry.getCustomer().reply("Have you tried turning it off and on again?");
			}
	}
	
}

class Customer{
	public static final Customer JACK = new Customer("Jack");
	public static final Customer JILL = new Customer("JILL");
	public static final Customer MARY = new Customer("MARY");
	
	private final String name;
	
	public Customer(final String name) {this.name=name;}
	public void reply(final String message) {System.out.printf("%s:%s\n",name,message);}
}

enum Category{
	PRINTER,
	COMPUTER,
	PHONE,
	TABLET
}

class Enquiry{
	private final Customer customer;
	private final Category category;
	
	public Enquiry(final Customer customer,final Category category) {
		this.customer = customer;
		this.category = category; 
	}

	public Customer getCustomer() {
		return customer;
	}

	public Category getCategory() {
		return category;
	}
	
	public String toString() {
		return "Enquiry{"+"customer="+customer+'\''+", category="+category+'}';
	}
}

class CategorisedHelpDesk{
	
	private final Queue<Enquiry> enquiries = new ArrayDeque<>();
	
	public void enquire(final Customer customer,final Category type) {
		enquiries.offer(new Enquiry(customer, type));
	}
	
//	//For Java 7
//	public void processPrinterEnquiry() {
//		final Enquiry enquiry = enquiries.peek();
//		if(enquiry != null && enquiry.getCategory() == PRINTER) {
//			enquiries.remove();
//			enquiry.getCustomer().reply("Is it out of paper?");
//		}else {
//			System.out.println("No work to do, lets have some coffee!!");
//		}
//	}
//	
//	public void processGeneralEnquiry() {
//		final Enquiry enquiry = enquiries.peek();
//		if(enquiry != null && enquiry.getCategory() != PRINTER) {
//			enquiries.remove();
//			enquiry.getCustomer().reply("Have you tried turning it off and on again?");
//		}else {
//			System.out.println("No work to do, lets have some coffee!!");
//		}	
//	}
	

	//For Java 8 and above
	public void processPrinterEnquiry() {
		processEnquiry(enq -> enq.getCategory() == PRINTER, "Is it out of paper?");
	}

	private void processEnquiry(final Predicate<Enquiry> predicate, final String message) {
		final Enquiry enquiry = enquiries.peek();
		if(enquiry != null && predicate.test(enquiry)) {
			enquiries.remove();
			
			enquiry.getCustomer().reply(message);
		}else {
			System.out.println("No work to do, lets have some coffee!!");
		}
	}
	
	public void processGeneralEnquiry() {
		processEnquiry(enq -> enq.getCategory() != PRINTER, "Have you tried turning it off and on again?");	
	}	
	
	
}

class PriorityHelpDesk{
	
//	private static final Comparator<Enquiry> By_CATEGORY = Comparator.comparing(Enquiry::getCategory);
	
	private static final Comparator<Enquiry> By_CATEGORY = new Comparator<Enquiry>() {
		public int compare(final Enquiry o1,final Enquiry o2) {
			return o1.getCategory().compareTo(o2.getCategory());
		}
	};
	
	//we rely on the fact that there is a compareTo method on the enum that is implemented by every enum class. So we will just have the ordering of the values in the enum's order 
	
	private final Queue<Enquiry> enquiries = new PriorityQueue<>(By_CATEGORY);//a comparator based constructor
	
	public void enquire(final Customer customer,final Category type) {
		enquiries.offer(new Enquiry(customer, type));
	}
	
	public void processAllEnqueries() {
			Enquiry enquiry;
			while((enquiry = enquiries.poll()) != null) {
				enquiry.getCustomer().reply("Have you tried turning it off and on again?");
			}
	}
}










