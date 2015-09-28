package src.main.java.lakios.tools;

/**
 * Created by eugene on 29.03.15.
 */
public class Combinations {
    // BAD!!! rounding fail this algorithm
    private static long combinationsBAD1(long n, long k) {
        if (k == 1) return n;
        return (long) ( ((double) n / (double) k) * (double) combinationsBAD1(n - 1, k - 1) );
    }

    // BAD!!! not tail recursion
    private static long combinationsBAD2(long n, long k) {
        if (k == 1 || n == k + 1) return n;
        return combinationsBAD2(n - 1, k - 1) + combinationsBAD2(n - 1, k);
    }

    public static void main(String[] args) {
        System.out.println(combinationsBAD2(2400000,1700000));
    }
}
