package onlineCoaching.course2.generics.classLiterals;

public class Logger {
	private String value;
	public Logger(String value) {this.value = value;}
	public void log() {System.out.println(value);}
	
	@Override
	public String toString() {
		return "Logger [value=" + value + "]";
	}
	
	
}
