package program1;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	private int value;
	
	public Counter(int i) {
		value = i;
	}
	
	public synchronized int getAndIncrement () {
		int temp = value;
		value = temp + 1;
		return value;
	}
	
	public int get() {
		return value;
	}

}
