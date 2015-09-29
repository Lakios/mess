package eugeneto.princeton.algorithm.week1.part1.prog;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.stream.IntStream;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 28.09.15
 * Time: 19:51
 * To change this template use File | Settings | File Templates.
 */
public class Percolation {
    private WeightedQuickUnionUF graph;
    private int N;
    private boolean[] opened;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        if (N <= 0) throw new IllegalArgumentException();
        this.N = N;
        graph = new WeightedQuickUnionUF(N*N + 2);
        opened = new boolean[N*N + 2];
        IntStream.range(1, N + 1).forEach(i -> graph.union(0, i));
        IntStream.range(1, N + 1).forEach(i -> graph.union(N * N + 1, N * N - i));
    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j) {
        validateIndexes(i, j);
        int me = index(i, j);
        opened[me] = true;

        if (i > 1) { // top
            unionIfOpened(me, me - N);
        }
        if (i < N) { //bottom
            unionIfOpened(me, me + N);
        }
        if (j > 1) { // left
            unionIfOpened(me, me - 1);
        }
        if (j < N) { // right
            unionIfOpened(me, me + 1);
        }
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        validateIndexes(i, j);
        return opened[index(i, j)];
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        validateIndexes(i, j);
        return isOpen(i, j) && graph.connected(0, index(i, j));
    }

    // does the system percolate?
    public boolean percolates() {
        return graph.connected(0, N * N + 1);
    }

    private void unionIfOpened(int me, int i) {
        if (opened[i]) graph.union(me, i);
    }

    private int index(int i, int j) {
        return (i - 1) * N + j;
    }

    private void validateIndexes(int i, int j) {
        if (i <= 0 || j <= 0 || i > N ||  j > N) throw new IllegalArgumentException(i + ":" + j);
    }
}
