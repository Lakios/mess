package src.main.java.lakios;

import java.util.stream.IntStream;
import java.util.Scanner;

/**
 * Created by eugene on 29.03.15.
 */
public class Task510A {
    static Scanner sc = new Scanner(System.in);
    static int n,m,a;
    public static void main(String[] args) {
        while(sc.hasNext()){
            n=sc.nextInt();
            m=sc.nextInt();

            String fill = repeat('#', m);
            String right = repeat('.', m - 1) + "#";
            String left = '#' + repeat('.', m - 1);
            for (int i = 0; i < n; i++) {
                if ((i + 1) % 2 == 1) {
                    System.out.println(fill);
                } else if ((i + 1) % 4 == 2) {
                    System.out.println(right);
                } else {
                    System.out.println(left);
                }
            }
        }
    }

    private static String repeat(char c, int times) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, times).forEach(i -> sb.append(c));
        return sb.toString();
    }
}
