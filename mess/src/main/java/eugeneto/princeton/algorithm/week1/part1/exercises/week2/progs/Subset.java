package eugeneto.princeton.algorithm.week1.part1.exercises.week2.progs;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by eugene on 11.10.15.
 */
public class Subset {
    public static void main(String[] args) {
        int k = Integer.valueOf(args[0]);
        RandomizedQueue q = new RandomizedQueue();
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            StdOut.println(q.dequeue());
        }
    }
}
