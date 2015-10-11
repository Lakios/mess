package eugeneto.princeton.algorithm.exercises.week3;

import eugeneto.princeton.algorithm.Utils;

import java.util.Arrays;

/**
 * Created by eugene on 11.10.15.
 */
public class MergeSortBU {
    private static int[] arr;
    private static int[] aux;
    private static String str = "57 39 99 33 47 52 61 54 85 55";

    public static void main(String[] args) {
        arr = Utils.strToIntArray(str.split("\\s"));
        aux = new int[arr.length];
        int st = 2;
        loop: while (true) {
            //System.out.println("==================== " + st);
            for (int i = 0; i < arr.length; i += st) {
                if ((i + st - 1) < arr.length){
                    merge(i, i + st / 2 -1 , i + st - 1);
                    System.out.println(Arrays.toString(arr).replaceAll(",", ""));
                } else {
                    merge(i, i + st / 2 - 1, arr.length - 1);
                    System.out.println(Arrays.toString(arr).replaceAll(",", ""));
                    if (i == 0) break loop;
                }
            }
            st = st * 2;
        }
        //System.out.println(Arrays.toString(arr));
    }

    private static void merge(int from, int mid, int to) {
        //System.out.println(from + " " + mid + " " + to);
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
