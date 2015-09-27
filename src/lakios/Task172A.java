package lakios;

import java.util.Scanner;

/**
 * Created by eugene on 02.04.15.
 */
public class Task172A {
    static Scanner sc = new Scanner(System.in);
    static long n = 0;
    public static void main(String[] args) {
        long i = 0;
        char[] mask = null;
        int prefixLength = 0;
        while((n == 0 || i < n) && sc.hasNext()){
            if (n ==0) {
                n=sc.nextInt();
                continue;
            }
            String l = sc.nextLine();
            if (l == null || l.trim().equals("")) continue;
            if (i == 0) {
                i++;
                mask = l.toCharArray();
                prefixLength = mask.length;
            } else {
                i++;
                for (int k = 0; k < Math.min(prefixLength, l.length()); k++) {
                    if (mask[k] != l.toCharArray()[k]) {
                        prefixLength = k;
                        break;
                    }
                }
                if (prefixLength == 0) break;
            }
        }
        System.out.println(prefixLength);
    }
}
