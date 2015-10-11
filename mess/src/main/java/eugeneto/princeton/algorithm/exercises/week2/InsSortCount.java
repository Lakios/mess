package eugeneto.princeton.algorithm.exercises.week2;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 07.10.15
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */
public class InsSortCount {
    static Comparable[] arr = {1, 0, 1, 0, 1, 0, 1, 0, 1, 0};
    static int counter = 0;

    public static void main(String[] args) {
        sort(arr);
        System.out.println(counter);
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    private static boolean less(Comparable v, Comparable w) {
        counter++;
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo+1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // exchange a[i] and a[j]  (for indirect sort)
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
