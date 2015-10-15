package eugeneto.princeton.algorithm.exercises.week3;

import eugeneto.princeton.algorithm.Utils;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 14.10.15
 * Time: 10:18
 * To change this template use File | Settings | File Templates.
 */
public class QSort3 {
    private static String str = "42 99 79 40 98 26 42 42 48 76";

    public static void main(String[] args) {
        int[] arr = Utils.strToIntArray(str.split("\\s"));
        int lt = 0;
        int i = 1;
        int gt = arr.length - 1;

        while (true) {
            if (arr[i] < arr[lt]) {
                int e = arr[i];
                arr[i] = arr[lt];
                arr[lt] = e;
                lt++;
                i++;
            } else if (arr[i] > arr[lt]) {
                int e = arr[i];
                arr[i] = arr[gt];
                arr[gt] = e;
                gt--;
            } else {
                i++;
            }
            if (i > gt) break;
        }
        System.out.println(Arrays.toString(arr).replaceAll(",", ""));
    }
}
