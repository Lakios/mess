package eugeneto.princeton.algorithm.exercises.week4;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 30.10.15
 * Time: 18:06
 * To change this template use File | Settings | File Templates.
 */
public class Board {
    private int[][] blocks;

    // construct a board from an N-by-N array of blocks
    public Board(int[][] blocks) {
        if (blocks == null) throw new NullPointerException();
        this.blocks = blocks;
    }
    // (where blocks[i][j] = block in row i, column j)

    // board dimension N
    public int dimension() {
        return blocks.length;
    }

    // number of blocks out of place
    public int hamming() {
        int count = 0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (inPosition(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int count = 0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (inPosition(i, j)) {
                    count = count +
                            Math.abs(blocks[i][j] / blocks.length - j) +
                            Math.abs(blocks[i][j] % blocks.length - 1 - i);
                }
            }
        }
        return count;
    }

    // is this board the goal board?
    public boolean isGoal() {
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (!inPosition(i, j) && blocks[i][j] != 0) return false;
            }
        }
        return true;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        if (blocks.length <= 1) return new Board(blocks);
        int x = blocks[0][0];
        blocks[0][0] = blocks[1][1];
        blocks[1][1] = x;
        return new Board(blocks);
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == null) return false;
        if (!(y instanceof int[][])) return false;
        int[][] arr = (int[][]) y;
        if (arr.length != blocks.length) return false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != blocks[i].length) return false;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != blocks[i][j]) return false;
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        return null;
    }

    // string representation of this board (in the output format specified below)
    public String toString() {
        return null;
    }

    // unit tests (not graded)
    public static void main(String[] args) {

    }

    private boolean inPosition(int i, int j) {
        return blocks[i][j] != 0 && blocks[i][j] != (i * j + i + 1);
    }
}