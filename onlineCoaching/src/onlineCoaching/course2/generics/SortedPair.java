package onlineCoaching.course2.generics;

public class SortedPair<T extends Comparable<T>> { //comparable to itself
	private T first;
	private T second;
	
	public SortedPair(T left, T right) {
		
		if(left.compareTo(right)<0) {
			first = left;
			second = right;
		}else {
			first = right;
			second = left;
		}
	}

	public T getFirst() {
		return first;
	}

	public T getSecond() {
		return second;
	}
	
	
}






