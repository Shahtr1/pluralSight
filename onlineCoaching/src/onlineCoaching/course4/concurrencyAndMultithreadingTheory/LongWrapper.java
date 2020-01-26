package onlineCoaching.course4.concurrencyAndMultithreadingTheory;

public class LongWrapper {
	
	private Object key = new Object();
	private long l;
//	private volatile long l;
	public LongWrapper(long l) {
		this.l = l;
	}
	public long getValue() {
		synchronized(key) {
			return l;
		}	
	}
	public void incrementValue() {
		synchronized(key) {
			l += 1;
		}
	}
}
