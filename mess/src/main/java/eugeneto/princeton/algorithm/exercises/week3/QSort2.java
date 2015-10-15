package eugeneto.princeton.algorithm.exercises.week3;

import eugeneto.princeton.algorithm.Utils;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 14.10.15
 * Time: 10:02
 * To change this template use File | Settings | File Templates.
 */
public class QSort2 {
    private static String str = "26 52 64 15 73 81 87 16 92 28 34 97";

    public static void main(String[] args) {
        int[] arr = Utils.strToIntArray(str.split("\\s"));
        int i = 1;
        int j = arr.length - 1;

        while (true) {
            while(arr[i] < arr[0]) i++;
            while(arr[j] > arr[0]) j--;
            if (i > j) {
                int e = arr[0];
                arr[0] = arr[j];
                arr[j] = e;
                break;
            }

            System.out.println(i + " " + j);
            int e = arr[i];
            arr[i] = arr[j];
            arr[j] = e;
        }
        System.out.println(Arrays.toString(arr).replaceAll(",", ""));
    }
}
