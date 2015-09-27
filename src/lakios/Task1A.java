package lakios;

import java.util.Scanner;

public class Task1A {
    static Scanner sc = new Scanner(System.in);
    static long n,m,a;
    public static void main(String[] args) {
        while(sc.hasNext()){
            n=sc.nextInt();
            m=sc.nextInt();
            a=sc.nextInt();
            if (a == 0) {
                System.out.println(1);
            } else {
                long x = (n / a) + (n%a > 0 ? 1 : 0);
                long y = (m / a) + (m%a > 0 ? 1 : 0);
                System.out.println(x * y);
            }
        }
    }

}