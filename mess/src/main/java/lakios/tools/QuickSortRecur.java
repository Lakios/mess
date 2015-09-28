package src.main.java.lakios.tools;

/**
 * Created by eugene on 30.03.15.
 */
public class QuickSortRecur {
    public static void main(String[] args)  throws  Exception {
        int[] ar = new int[]{6, 2, 8, 4, 7, 9, 4, 1, 33};
        quicksort(ar);
        print(ar, 0, ar.length - 1);
    }

    private static void print(int[] ar, int lo, int hi) {
        System.out.printf(lo +" - " + hi + ": \t");
        for (int i = 0; i < ar.length; i++) {
            if (i >= lo && i <= hi)  System.out.print(ar[i] + ", ");
        }
        System.out.println();
    }

    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(a, lo, hi);
            quicksort(a, lo, pivot - 1);
            quicksort(a, pivot + 1, hi);
        }
    }

    private static int partition(int[] a, int lo, int hi) {
        int pivotIndex = lo + (hi - lo) / 2;
        int pivotValue = a[pivotIndex];
        int storedIndex = lo;
        swap(a, pivotIndex, hi);
        for (int i = lo; i <= hi - 1; i++) {
            if (a[i] < pivotValue) {
                swap(a, i, storedIndex);
                storedIndex = storedIndex + 1;
            }
        }
        swap(a, storedIndex, hi);
        return storedIndex;
    }

    private static void swap(int[] a, int p1, int p2) {
        int remember = a[p1];
        a[p1] = a[p2];
        a[p2] = remember;
    }
}
