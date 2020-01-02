package onlineCoaching.course4.concurrencyAndMultithreadingTheory;

public class RaceCondition {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		LongWrapper longWrapper = new LongWrapper(0L);
		
		Runnable r = () -> {
			
			for(int i = 0; i < 1_000 ; i++) {
				longWrapper.incrementValue();
			}
		};
		
		Thread[] threads = new Thread[1_000];
		for(int i = 0 ; i < threads.length ; i++) {
			threads[i] = new Thread(r);
			threads[i].start();
		}
		
		for(int i = 0 ; i < threads.length ; i++) {
			threads[i].join();
		}
		
		//t.join(); // used to make sure that the code after this join method is executed once this thread has finished executing the above Runnable r.
		
		System.out.println("Value = " + longWrapper.getValue());
		
	}

}
