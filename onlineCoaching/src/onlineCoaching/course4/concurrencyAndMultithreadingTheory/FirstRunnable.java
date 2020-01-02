package onlineCoaching.course4.concurrencyAndMultithreadingTheory;

public class FirstRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable runnable = () -> {
			System.out.println("I am running in " + Thread.currentThread().getName());
		};
		
		Thread t = new Thread(runnable);
		t.setName("My thread");
		t.start();
		//t.run(); //executes in the main thread
	}

}
