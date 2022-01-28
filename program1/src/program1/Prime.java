package program1;
import java.lang.Math;

public class Prime extends Thread {
	static int maxNum = (int)Math.pow(10, 8);
	//(int)Math.pow(10, 8)
	static int [] primes = new int [maxNum];
	static Counter primeCount = new Counter(0);
	static long sum = 0;
	static int primeNum = 0;
	static Counter count = new Counter(1);
	
	public void run() {
		int num =count.getAndIncrement();
		while(num <=maxNum ) {
			if (isPrime(num)){
				primes[primeCount.getAndIncrement()] = num;
				primeNum++;
	            sum += num; 
			}
			num = count.getAndIncrement();
		}
   }
    
    static boolean isPrime(int num) {
    //*
    if (num < 2) {
    	return false;    	
    }
    if (num == 2 || num == 3) {
    	//System.out.println(num+" is a prime number");
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
    //*/
    //System.out.println(num+" is a prime number");
    return true;
    }
}
