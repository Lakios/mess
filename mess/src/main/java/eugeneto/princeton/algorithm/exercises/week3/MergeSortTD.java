package eugeneto.princeton.algorithm.exercises.week3;

import eugeneto.princeton.algorithm.Utils;

import java.util.Arrays;

/**
 * Created by eugene on 11.10.15.
 */
public class MergeSortTD {
    private static int[] arr;
    private static int[] aux;
    private static String str = "32 77 76 65 26 41 54 55 16 86 19 25";

    public static void main(String[] args) {
        arr = Utils.strToIntArray(str.split("\\s"));
        aux = new int[arr.length];
        sort(0, arr.length - 1);
    }

    private static void sort(int from, int to) {
        if (from == to) return;
        sort(from, (from + to) / 2);
        sort((from + to) / 2 + 1, to);
        merge(from, (from + to) / 2, to);
        System.out.println(Arrays.toString(arr).replaceAll(",", ""));
    }

    private static void merge(int from, int mid, int to) {
        for (int i = 0; i < arr.length; i++) {
            aux[i] = arr[i];
        }
        int k = from;
        int i = from;
        int j = mid + 1;
        //System.out.println(i + " " + j + " " + k);
        while (k <= to) {
            //ystem.out.println("--->>> " + i + " " + j + " " + k);
            if (i > mid)
                arr[k] = aux[j++];
            else if (j > to)
                arr[k] = aux[i++];
            else if (aux[i] <= aux[j])
                arr[k] = aux[i++];
            else
                arr[k] = aux[j++];
            k++;
        }
    }
}
