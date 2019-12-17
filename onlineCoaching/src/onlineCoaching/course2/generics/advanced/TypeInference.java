/*
 * 	Type Inference allows us to infer the types of method parameters from their context
 * 		They work in much the same way as diamond operator, which tells the javac go put the type from its context
 * 		
 * 	How does type inference interplay with Generics???????? 		
 */

package onlineCoaching.course2.generics.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import onlineCoaching.course2.generics.Person;

public class TypeInference {
	 public static void main(String[] args) {
		final Person donDraper = new Person("Don Draper", 89);
		final Person peggyOlson = new Person("Peggy Olson", 75);
		final Person bertCooper = new Person("Bert Cooper", 100);
		
		//Predicate is an interface
		/*
		 * 	public interface Predicate<T>{
		 * 		boolean test(T t);
		 * 	}
		 */
		
		Predicate<Person> isOld = person -> person.getAge() > 80;
		System.out.println(isOld.test(donDraper));
		System.out.println(isOld.test(peggyOlson));
		
		List<Person> people = new ArrayList<>();
		people.add(donDraper);
		people.add(peggyOlson);
		people.add(bertCooper);
		
		//Collectors framework
		final Map<Boolean, List<Person>> oldAndYoungPeople =  people.stream().collect(Collectors.partitioningBy(person -> person.getAge() > 80));
		System.out.println(oldAndYoungPeople);
		
		System.out.println();
		
		final Map<Boolean, Long> oldAndYoung =  people.stream().collect(Collectors.partitioningBy(person -> person.getAge() > 80,Collectors.counting()));
		System.out.println(oldAndYoung);
		
		//if you ever see an error check first the target type of lambda expression is correct or not
	 }
}









