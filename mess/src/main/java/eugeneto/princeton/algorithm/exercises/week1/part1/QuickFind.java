package eugeneto.princeton.algorithm.exercises.week1.part1;

/**
 * Created by eugene on 27.09.15.
 */
public class QuickFind {
    static int ids[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        //8-5 9-0 1-0 6-0 0-4 2-8
        for (String a : "9-7 1-3 4-5 0-7 1-0 7-4".split(" ")) {
            String[] kk = a.split("-");
            union(Integer.valueOf(kk[0]), Integer.valueOf(kk[1]));
        }

        for (int id : ids) {
            System.out.print(id + " ");
        }
    }

    static void union(int p, int q) {
        int s = ids[p];
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == s) {
                ids[i] = ids[q];
            }
        }

    }
}