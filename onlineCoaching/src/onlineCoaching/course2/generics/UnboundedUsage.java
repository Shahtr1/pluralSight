package onlineCoaching.course2.generics;

import java.util.ArrayList;
import java.util.List;

public class UnboundedUsage {
	public static void main(String[] args) {
//		List<?> objects = new ArrayList<>();
//		objects.add(new Object());
//		objects.add(new Person("Don Draper",89));
//		System.out.println(objects);
		
//		no value can go above except this below
		List<? extends Object> objects = new ArrayList<>();
		objects.add(null);
		System.out.println(objects);
		
	}
}
