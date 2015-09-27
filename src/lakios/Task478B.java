package lakios;

import java.util.Scanner;

/**
 * Created by eugene on 29.03.15.
 */
public class Task478B {
    static Scanner sc = new Scanner(System.in);
    static long n,m,a;
    public static void main(String[] args) {
        while (sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();

            long max = combinationsBy2(n - m + 1);
            long min = (n - (n /m ) * m) * combinationsBy2(n / m + 1) + (m - (n - (n /m ) * m)) * combinationsBy2(n / m);
            System.out.println(min + " " + max);
        }
    }

    private static long combinationsBy2(long x) {
        if ( x < 2) return 0;
        return x * (x - 1) / 2;
    }
}
