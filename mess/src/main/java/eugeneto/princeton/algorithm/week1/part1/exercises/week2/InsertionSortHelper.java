package eugeneto.princeton.algorithm.week1.part1.exercises.week2;

import eugeneto.princeton.algorithm.week1.part1.Utils;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 06.10.15
 * Time: 10:56
 * To change this template use File | Settings | File Templates.
 */
public class InsertionSortHelper {
    public static String str = "12 25 50 61 75 70 68 18 41 63";

    private static int exchangeCount = 0;

    private static int MAX_EX = 6;

    public static void main(String[] args) {
        int[] arr = Utils.strToIntArray(str.split("\\s"));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) {
                    System.out.println("ahhha " + (j+1) + " " + j);
                    int val = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = val;
                    exchangeCount++;
                    if (exchangeCount >= MAX_EX) {
                        System.out.println(Arrays.toString(arr).replaceAll(",", ""));
                        return;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
