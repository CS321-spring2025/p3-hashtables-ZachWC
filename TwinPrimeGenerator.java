public class TwinPrimeGenerator {

        // Helper method to check if a number is prime
        public static boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;  // num is divisible by i, not a prime
                }
            }
            return true;
        }
    
        // Method to generate a twin prime in the range [min, max]
        public static int generateTwinPrime(int min, int max) {
            // Iterate over the range to find twin primes
            for (int i = max; i >= min + 2; i--) {  // Start from max and move backwards
                if (isPrime(i) && isPrime(i - 2)) {
                    return i;  // Return the larger twin prime (i)
                }
            }
            // If no twin prime is found in the range, return -1 (or some indication)
            return -1;
        }    
    
}
