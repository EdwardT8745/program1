import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException; 
import java.lang.Math;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class PrimeThread {
	
	public static void main(String args[]) {  
		long startTime = System.currentTimeMillis();
		
		int nThreads = 8;

        Prime[] pThreads = new Prime[nThreads];
        
        for(int i = 0; i<nThreads; i++){
            pThreads[i] = new Prime();
            pThreads[i].start();

        }
        try {
            for (int i = 0; i < nThreads; i++) {
            	pThreads[i].join();            	
            }
            
            //writing to the file
            FileWriter myWriter = new FileWriter("primes.txt");

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            myWriter.write("Execution time = : "+  elapsedTime+"ms, ");
            myWriter.write("Number of Primes = : "+  Prime.primeNum.get() +", ");
            myWriter.write("Sum of all primes found = : "+  Prime.sum.get());
            myWriter.write("\n");
            int len = Prime.maxNum;
            Arrays.sort(Prime.primes);
            myWriter.write(""+Prime.primes[len-10]);
           	for (int i = len-9; i <= len-1; i++) {
           		int num = Prime.primes[i];
           		myWriter.write(", ");
           		myWriter.write(""+num);
           	}
            myWriter.close();
        } 
        catch (InterruptedException | IOException e) {
            }

    }

}

//Counter file
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

//Prime file
public class Prime extends Thread {
	static int maxNum = (int)Math.pow(10, 8);
	static int [] primes = new int [maxNum];
	static Counter primeCount = new Counter(0);
	static AtomicLong sum = new AtomicLong(0);
	static AtomicInteger primeNum = new AtomicInteger(0);
	static Counter count = new Counter(1);
	
	public void run() {
		int num =count.getAndIncrement();
		while(num <=maxNum ) {
			if (isPrime(num)){
				primes[primeCount.getAndIncrement()] = num;
				primeNum.incrementAndGet();
	            sum.addAndGet((long)num); 
			}
			num = count.getAndIncrement();
		}
   }
    
    static boolean isPrime(int num) {
    	
    if (num < 2) {
    	return false;    	
    }
    
    if (num == 2 || num == 3) {
    	return true;
    }
    
    if (num % 2 == 0 || num % 3 == 0) {
    	return false;
    }
    
    int sqrtN = (int) Math.sqrt(num) + 1;
    for (int i = 6; i <= sqrtN; i += 6) {
        if (num % (i - 1) == 0 || num % (i + 1) == 0) {
            return false;
        }
    }
    return true;
    }
    
}


