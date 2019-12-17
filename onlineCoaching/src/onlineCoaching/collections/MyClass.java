package onlineCoaching.collections;

public class MyClass {
	String label, value;

	MyClass(String v1,String v2){
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
		MyClass other = (MyClass) o;
		return value.equalsIgnoreCase(other.value);
	}
}






