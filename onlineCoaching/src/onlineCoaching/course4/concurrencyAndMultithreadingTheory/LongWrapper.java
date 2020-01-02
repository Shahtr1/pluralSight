package onlineCoaching.course4.concurrencyAndMultithreadingTheory;

public class LongWrapper {
	
	private Object key = new Object();
	private long l;
	public LongWrapper(long l) {
		this.l = l;
	}
	public long getValue() {
		return l;
	}
	public void incrementValue() {
		synchronized(key) {
			l += 1;
		}
	}
}
