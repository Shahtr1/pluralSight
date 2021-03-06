package onlineCoaching.collections;

public class MyClass1 implements Comparable<MyClass1>{
	//implementing comparable
	String label,value;
	public String toString() {
		return label + " | " + value;
	}
	MyClass1(String v1,String v2){
		label = v1;
		value = v2;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public boolean equals(Object o) {
		MyClass1 other = (MyClass1) o;
		return value.equalsIgnoreCase(other.value);
	}
	
	/*
	 *		-	:	this  <  other
	 *		0	:	this  =  other
	 *		+	:	this  >  other
	 */
	public int compareTo(MyClass1 other) { 
		return value.compareToIgnoreCase(other.value);
	}
}
