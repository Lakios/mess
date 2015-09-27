package lakios;

import java.util.Scanner;

public class Task50A {
    static Scanner sc = new Scanner(System.in);
    static long n,m,a;
    public static void main(String[] args) {
        while(sc.hasNext()){
            n=sc.nextInt();
            m=sc.nextInt();

            System.out.println(Math.min(n,m)*(Math.max(n,m)/2) + (Math.max(m,n)%2)*(Math.min(m,n)/2));
        }
    }

}

