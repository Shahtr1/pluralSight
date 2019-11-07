package onlineCoaching.course2.generics.classLiterals;

public class Main {
	public static void main(String[] args) {
		Injector injector = new Injector().with("Hello World");
		
		Logger logger =  injector.newInstance(Logger.class);
		logger.log();
	}
}
