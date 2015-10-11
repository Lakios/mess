package eugeneto.princeton.algorithm.exercises.week1.part1;

import java.util.Arrays;

/**
 * Created by eugene on 27.09.15.
 */
public class QuickUnionCheck {
    private static int[] a = toArr("4 0 4 6 4 0 0 2 1 0");
    private static int[] b = toArr("1 2 9 2 2 1 2 2 1 8");
    private static int[] c = toArr("0 1 2 0 4 5 6 0 8 8");
    private static int[] d = toArr("6 1 3 6 1 3 1 6 8 2");
    private static int[] e = toArr("8 7 8 0 8 8 5 5 8 8");

    public static void main(String[] args) {
        System.out.println(check(a));
        System.out.println(check(b));
        System.out.println(check(c));
        System.out.println(check(d));
        System.out.println(check(e));
    }

    private static int[] toArr(String str) {
        int[] ll = new int[10];
        int i = 0;
        for (String s : str.split(" ") ) {
            ll[i] = Integer.valueOf(s);
            i++;
        }
        return ll;
    }

    private static boolean check(int[] arr) {
        System.out.println("checking " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            int length = rootLength(arr, i);
            if(length > 3) {
                System.out.println("failed on " + i + " (" + length + ")");
                return false;
            }
        }
        return true;
    }

    private static int rootLength(int[] arr, int i) {
        int k = 0;
        while (arr[i] != i && k < 50) {
            i = arr[i];
            k++;
        }
        return k;
    }

}
