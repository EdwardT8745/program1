# program1
COP4520 Programming Assignment 1

To run the code, you go the the directory with the "program1.java" file and run in the commandline "java program1.java".

It should create the text file "primes.txt" after it finishes running the "program1.java" file.

I moved all the code in PrimeThread.java, Prime.java, and Counter.java into one file, program1.java.

The code uses 8 threads to find all prime numbers up to 10^8. The code has three classes: Prime, PrimeThread, and Counter. Prime extends to Thread so that the 8 threads can use can use the same variables and methods. It uses the Counter class to keep track on the numbers, atomic variables, and the isPrime function to determine if the number is prime. The atomic variables makes sure that threads' changes does not overlap with each other. PrimeThread holds the main function which creates the 8 threads and prints the excution time, number of primes, the sum of the primes, and the last ten primes to the "prime.txt" file. The Counter class uses a synchronized method, "getAndIncrement", to increment the counter and give it to the thread. Having the method be synchronize makes sure that only one thread uses it at a time.
