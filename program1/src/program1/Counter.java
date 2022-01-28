package program1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	private int value;
	
	public Counter(int i) {
		value = i;
	}
	
	public synchronized int getAndIncrement () { 
		/*
		lock.lock();
		try {
				int temp = value; // in critical section
				value = temp + 1; // in critical section
				return temp;
		} 
		finally {
			lock.unlock(); // leave critical section
		}
		//*/
		
		int temp = value; // in critical section
		value = temp + 1; // in critical section
		return temp;
	}

}
