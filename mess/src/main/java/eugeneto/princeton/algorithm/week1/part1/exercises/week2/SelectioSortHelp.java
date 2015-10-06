package eugeneto.princeton.algorithm.week1.part1.exercises.week2;

import eugeneto.princeton.algorithm.week1.part1.Utils;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 06.10.15
 * Time: 11:42
 * To change this template use File | Settings | File Templates.
 */
public class SelectioSortHelp {
    public static String str = "55 61 47 28 57 56 80 21 27 36";

    private static int exchangeCount = 0;

    private static int MAX_EX = 4;

    public static void main(String[] args) {
        int[] arr = Utils.strToIntArray(str.split("\\s"));
        for (int i = 0; i < arr.length; i++) {
            int minI = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minI]) {
                    minI = j;
                }
            }
            if (minI != i) {
                int val = arr[minI];
                arr[minI] = arr[i];
                arr[i] = val;
                exchangeCount++;
                if (exchangeCount >= MAX_EX) {
                    System.out.println(Arrays.toString(arr));
                    return;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
