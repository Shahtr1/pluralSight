package onlineCoaching.string;

import java.util.StringJoiner;

public class StringJoiner1 {
	public static void main(String[] args) {
		StringJoiner sj = new StringJoiner(", ");
		sj.add("alpha").add("theta").add("gamma");
		String theResult = sj.toString();
		System.out.println(theResult);
		
		StringJoiner sj1 = new StringJoiner(", ","{","}");
		sj1.add("alpha").add("theta").add("gamma");
		String theResult1 = sj1.toString();
		System.out.println(theResult1);
		
		//Empty Handling
		StringJoiner sj2 = new StringJoiner(", ");
		sj2.setEmptyValue("EMPTY");
		String theResult2 = sj2.toString();
		System.out.println(theResult2);
		
		StringJoiner sj3 = new StringJoiner(", ","{","}");
		sj3.setEmptyValue("EMPTY");
		String theResult3 = sj3.toString();
		System.out.println(theResult3);
		
		StringJoiner sj4 = new StringJoiner(", ","{","}");
		sj2.setEmptyValue("EMPTY");
		sj2.add("");
		String theResult4 = sj4.toString();
		System.out.println(theResult4);
	}
}
