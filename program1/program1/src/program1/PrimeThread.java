package program1;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException; 

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
