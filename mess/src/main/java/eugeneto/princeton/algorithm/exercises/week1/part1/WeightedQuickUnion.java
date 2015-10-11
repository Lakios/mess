package eugeneto.princeton.algorithm.exercises.week1.part1;

/**
 * Created by eugene on 27.09.15.
 */
public class WeightedQuickUnion {
    private static int[] ids = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static int[] weights = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    public static void main(String[] args) {
        // 1-0 5-9 5-4 7-6 9-2 7-1 8-5 9-3 1-5

        for (String a : "8-5 0-4 1-2 6-0 4-3 8-1 7-3 4-9 0-5".split(" ")) {
            String[] kk = a.split("-");
            wunion(Integer.valueOf(kk[0]), Integer.valueOf(kk[1]));
        }

        for (int id : ids) {
            System.out.print(id + " ");
        }
    }

    private static void wunion(int p, int q) {
        int rp = root(p);
        int rq = root(q);
        if (weights[rp] < weights[rq]) {
            ids[rp] = rq;
            weights[rq] = weights[rp] + weights[rq];
            weights[rq] = weights[rp] + weights[rq];
        } else if (weights[rp] >= weights[rq]) {
            ids[rq] = rp;
            weights[rp] = weights[rp] + weights[rq];
        }
    }

    private static int root(int i) {
        if (ids[i] == i) return i;
        return root(ids[i]);
    }
}
