package onlineCoaching.collections;

//Lambda expressions
/*
* 	Simplify passing code as arguments
* 		forEach
* 			inherited from the iterable interface
* 			perform code for each member
* 		removeif
* 			takes a predicate, so resolves to true or false
*/
import java.util.ArrayList;

public class LambdaExpressions {
	public static void main(String[] args) {
	//Lambda Expressions
			ArrayList<MyClass> listA = new ArrayList<>();
			MyClass va = new MyClass("va","abc");
			MyClass vb = new MyClass("vb","xyz");
			MyClass vc = new MyClass("vc","abc");
			
			listA.add(va);
			listA.add(vb);
			listA.add(vc);
			
			System.out.println("through lambda expressions forEach");
			listA.forEach(m ->System.out.println(m.getLabel()));
			
			
			//Using removeIf method
			System.out.println("through lambda expressions forEach");
			listA.removeIf(m -> m.getValue().equals("abc"));
			listA.forEach(m ->System.out.println(m.getLabel()));
	}
}
