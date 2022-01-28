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
            //*
            /*
            File myObj = new File("primes.txt");
            if (myObj.createNewFile()) {
            } else {
            }
            //*/
            FileWriter myWriter = new FileWriter("primes.txt");
            //myWriter.write("Files in Java might be tricky, but it is fun enough!");
            //myWriter.close();
            //*/

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("Execution time = : "+  elapsedTime+"ms");
            myWriter.write("Execution time = : "+  elapsedTime+"ms, ");
            myWriter.write("Number of Primes = : "+  Prime.primeNum +", ");
            myWriter.write("Sum of all primes found = : "+  Prime.sum);
            myWriter.write("\n");
            int len = Prime.maxNum;
            Arrays.sort(Prime.primes);
            //System.out.print(Prime.primes[len-10]);
            myWriter.write(""+Prime.primes[len-10]);
           	for (int i = len-9; i <= len-1; i++) {
           		int num = Prime.primes[i];
           		//System.out.print(", ");
           		myWriter.write(", ");
           		//System.out.print(Prime.primes[i]);
           		myWriter.write(""+num);
           	}
            //99999787 99999821	99999827 99999839 99999847 99999931	99999941 99999959 99999971 99999989
            myWriter.close();
        } 
        catch (InterruptedException | IOException e) {
            }

    }

}
