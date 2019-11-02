package onlineCoaching.course2.generics;

public class TypeUnsafeExample {
//	public static void main(String[] args) {
//		StringCircularBuffer buffer = new StringCircularBuffer(10);
//		
//		buffer.offer("a");
//		buffer.offer("bc");
//		buffer.offer("d");
//		
////		buffer.offer(1); //java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String
//		
//		String value =concatenate(buffer);
//		System.out.println(value);
//	} 
	
	public static void main(String[] args) {
		CircularBuffer<String> buffer = new CircularBuffer<>(10);
		
		buffer.offer("a");
		buffer.offer("bc");
		buffer.offer("d");
		
//		buffer.offer(1); //java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String
		
		String value =concatenate(buffer);
		System.out.println(value);
	} 
	
	private static String concatenate(CircularBuffer<String> buffer) {
		StringBuilder result = new StringBuilder();
		
		String value;
		while((value = buffer.poll()) != null) {
			result.append(value);
		}
		
		return result.toString();
	}
}
