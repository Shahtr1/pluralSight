package onlineCoaching.collections;

import java.util.Comparator;

public class MyComparator implements Comparator<MyClass1>{
	/*
	 * 		-	:	x  <  y
	 * 		0	:	x  =  y
	 * 		+	:	x  >  y
	 */
	@Override
	public int compare(MyClass1 x, MyClass1 y) {
		return x.getLabel().compareToIgnoreCase(y.getLabel());
	}
}
