package onlineCoaching.course2.generics.classLiterals;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Injector {
	private Map<Class<?>, Object> objectGraph = new HashMap<>();
	
	public Injector with(Object value) {
		objectGraph.put(value.getClass(), value);
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T newInstance(final Class<T> type) {
//		if(objectGraph.containsKey(type)) {
//			return objectGraph.get(type);
//		}else {								//Java 7
//			instantiate(type);
//		}
		
		//Java 8
		System.out.println("new Instance method");
		return (T) objectGraph.computeIfAbsent(type, this::instantiate);
	}

	
	private Object instantiate(Class<?> type) {
		Object co = null;
		try {
			Constructor<?>[] constructors = type.getConstructors();
			
				for(Constructor<?> c : constructors) {
//					System.out.println(c.getName());
					co = c.newInstance("hi");
//					 System.out.println(co.toString());
				}
				return co;
			
			
			
		}catch(Exception e) {
			return null;
		}
	}
}
