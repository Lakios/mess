package eugeneto.princeton.algorithm.exercises.week2;

import eugeneto.princeton.algorithm.Utils;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 06.10.15
 * Time: 11:14
 * To change this template use File | Settings | File Templates.
 */
public class FourSortingPhaseHelper {
    public static String str = "88 56 91 31 34 25 71 49 37 11";

    public static void main(String[] args) {
        int[] arr = Utils.strToIntArray(str.split("\\s"));
        for (int i = 4; i < arr.length; i++) {
            for (int j = i; j >= 4; j = j - 4) {
                if (arr[j] < arr[j - 4]) {
                    System.out.println("ahhha " + (j) + " " + (j - 4));
                    int val = arr[j];
                    arr[j] = arr[j-4];
                    arr[j-4] = val;
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr).replaceAll(",", ""));
    }
}
