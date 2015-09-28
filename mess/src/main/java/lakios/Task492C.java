package src.main.java.lakios;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by eugene on 29.03.15.
 */
public class Task492C {

    static Scanner sc = new Scanner(System.in);
    static int n,r,avg;
    private static long[] a, aN;
    private static long[] b, bN;

    private static Map<Long, Long> shortMap = new HashMap<>();

    public static void main(String[] args) {
        int i = 0;
        while((n == 0 || i < n) && sc.hasNext()) {
            if (n == 0) {
                n = sc.nextInt();
                r = sc.nextInt();
                avg = sc.nextInt();
                a = new long[n];
                b = new long[n];
            } else {
                a[i] = sc.nextLong();
                b[i] = sc.nextLong();
                i = i + 1;
            }
        }

        for (int k = 0; k < a.length; k++) {
            Long val = shortMap.get(b[k]);
            if (val != null) {
                shortMap.put(b[k], val - (r - a[k]));
            } else {
                shortMap.put(b[k], a[k]);
            }
        }
        aN = new long[shortMap.size()];
        bN = new long[shortMap.size()];
        int j = 0;
        for (Map.Entry<Long, Long> entry : shortMap.entrySet()) {
            aN[j] = entry.getValue();
            bN[j] = entry.getKey();
            j++;
        }

        quicksort(bN);

        long sumMarks = 0;
        for (int k = 0; k < a.length; k++) {
            sumMarks = sumMarks + a[k];
        }

        int examIndex = 0;
        long refsCount = 0;
        while (sumMarks < avg * n) {
            long add = Math.min(((long) avg) * ((long) n) - sumMarks, r - aN[examIndex]);
            refsCount += ((long) bN[examIndex]) * ((long) add);
            sumMarks += add;
            examIndex++;
        }

        System.out.println(refsCount);
    }

    public static void quicksort(long[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(long[] array, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(array, lo, hi);
            quicksort(array, lo, pivot - 1);
            quicksort(array, pivot + 1, hi);
        }
    }

    private static int partition(long[] array, int lo, int hi) {
        int pivotIndex = lo + (hi - lo) / 2;
        long pivotValue = array[pivotIndex];
        int storedIndex = lo;
        swap(array, pivotIndex, hi);
        for (int i = lo; i <= hi - 1; i++) {
            if (array[i] < pivotValue) {
                swap(array, i, storedIndex);
                storedIndex = storedIndex + 1;
            }
        }
        swap(array, storedIndex, hi);
        return storedIndex;
    }

    private static void swap(long[] array, int p1, int p2) {
        long remember = array[p1];
        array[p1] = array[p2];
        array[p2] = remember;

        long rememberB = aN[p1];
        aN[p1] = aN[p2];
        aN[p2] = rememberB;
    }
}
