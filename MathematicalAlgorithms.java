import java.util.Arrays;

public class MathematicalAlgorithms {
    public static void main(String[] args) {
        int n = 20;
        SieveOfSundaram(n);
        System.out.println();
        sieveOfEratosthenes(n);
    }
    static int SieveOfSundaram(int n) {
    // In general Sieve of Sundaram, produces 
    // primes smaller than (2*x + 2) for a number
    // given number x. Since we want primes 
    // smaller than n, we reduce n to half
    int nNew = (n - 1) / 2;
    // This array is used to separate numbers of the 
    // form i+j+2ij from others where 1 <= i <= j
    boolean marked[] = new boolean[nNew + 1];
    // Initialize all elements as not marked
    Arrays.fill(marked, false);
    // Main logic of Sundaram. Mark all numbers of the
    // form i + j + 2ij as true where 1 <= i <= j
    for (int i = 1; i <= nNew; i++)
    for (int j = i; (i + j + 2 * i * j) <= nNew; j++)
        marked[i + j + 2 * i * j] = true;
    // Since 2 is a prime number
    if (n >= 2)
    System.out.print(2 + " ");
    // Print other primes. Remaining primes are of 
    // the form 2*i + 1 such that marked[i] is false.
    for (int i = 1; i <= nNew; i++)
    if (marked[i] == false)
        System.out.print(2 * i + 1 + " ");
    return -1;
}
static void sieveOfEratosthenes(int n)
    {
        // Create a boolean array "prime[0..n]" and
        // initialize all entries it as true. A value in
        // prime[i] will finally be false if i is Not a
        // prime, else true.
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;
 
        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true) {
                // Update all multiples of p greater than or
                // equal to the square of it numbers which
                // are multiple of p and are less than p^2
                // are already been marked.
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
 
        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                System.out.print(i + " ");
        }
    }
}
