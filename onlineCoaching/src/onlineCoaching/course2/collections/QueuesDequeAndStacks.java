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



package onlineCoaching.course2.collections;

import static onlineCoaching.course2.collections.Category.PRINTER;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

public class QueuesDequeAndStacks {
	public static void main(String[] args) {
//		HelpDesk h = new HelpDesk();
//		h.enquire(Customer.JACK, Category.PHONE);
//		h.enquire(Customer.JILL, Category.PRINTER);
//		
//		h.processAllEnqueries();
		
		CategorisedHelpDesk h = new CategorisedHelpDesk();
		h.enquire(Customer.JACK, Category.PHONE);
		h.enquire(Customer.JILL, Category.PRINTER);
		
		h.processPrinterEnquiry();
		h.processGeneralEnquiry();
		h.processPrinterEnquiry();
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










