package eugeneto.princeton.algorithm.exercises.week1.progs;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

import java.util.stream.IntStream;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 28.09.15
 * Time: 19:38
 * To change this template use File | Settings | File Templates.
 */
public class PercolationStats {
    private double[] results;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) throw new IllegalArgumentException();

        results = new double[T];
        IntStream.range(0, T).forEach(launchNumber -> {
            Percolation percolation = new Percolation(N);
            int iteration = 0;
            while (!percolation.percolates()) {
                boolean isOpen = true;
                int i = -1;
                int j = -1;
                while (isOpen) {
                    i = StdRandom.uniform(N);
                    j = StdRandom.uniform(N);
                    isOpen = percolation.isOpen(i + 1, j + 1);
                }
                percolation.open(i + 1, j + 1);
                iteration++;
            }
            results[launchNumber] = ((double) iteration) / (N * N);
        });
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(results.length);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(results.length);
    }

    // test client (described below)
    public static void main(String[] args) {
        if (args.length != 2) throw new IllegalArgumentException();
        try {
            int N = Integer.valueOf(args[0]);
            int T = Integer.valueOf(args[1]);

            PercolationStats stats = new PercolationStats(N, T);
            StdOut.printf("mean                    = %f\n", stats.mean());
            StdOut.printf("stddev                  = %f\n", stats.stddev());
            StdOut.printf("95%% confidence interval = %f, %f", stats.confidenceLo(), stats.confidenceHi());


        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
