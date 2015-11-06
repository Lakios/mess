package eugeneto.princeton.algorithm.exercises.week4;

import java.util.ArrayList;
import java.util.List;

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
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] initBlocks) {
        if (initBlocks == null) throw new NullPointerException();
        blocks = new int[initBlocks.length][initBlocks.length];
        for (int i = 0; i < initBlocks.length; i++) {
            for (int j = 0; j < initBlocks[i].length; j++) {
                blocks[i][j] = initBlocks[i][j];
            }
        }
    }

    // board dimension N
    public int dimension() {
        return blocks.length;
    }

    // number of blocks out of place
    public int hamming() {
        int count = 0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (!inPosition(i, j)) {
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
                if (!inPosition(i, j)) {
                    count = count +
                            Math.abs(blocks[i][j] / blocks.length - i) +
                            Math.abs(blocks[i][j] % blocks.length - 1 - j);
                }
            }
        }
        return count;
    }

    // is this board the goal board?
    public boolean isGoal() {
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blocks[i][j] == 0) continue;
                if (!inPosition(i, j)) return false;
            }
        }
        return true;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        if (blocks.length <= 1) return new Board(blocks);
        Board newBoard = new Board(blocks);
        newBoard.exchange(0, 0, 1, 1);
        return newBoard;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == null) return false;
        if (!(y instanceof Board)) return false;
        int[][] arr = ((Board) y).blocks;
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
        List<Board> neighbors = new ArrayList<>();
        int i0 = -11;
        int j0 = -11;
        l1: for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blocks[i][j] == 0)  {
                    i0 = i;
                    j0 = j;
                    break l1;
                }
            }
        }

        int pos[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] p : pos) {
            if (exists(i0 + p[0], j0 + p[1])) {
                Board newBoard = new Board(blocks);
                newBoard.exchange(i0, j0, i0 + p[0], j0 + p[1]);
                neighbors.add(newBoard);
            }
        }

        return neighbors;
    }

    private boolean exists(int i, int j) {
        return i >= 0 && j >= 0 && i < blocks.length && j < blocks.length;
    }

    private void exchange(int i, int j, int in, int jn) {
        int val = blocks[i][j];
        blocks[i][j] = blocks[in][jn];
        blocks[in][jn]  = val;
    }

    // string representation of this board (in the output format specified below)
    public String toString() {
        String str = "";
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (j > 0) str += "\t";
                str += blocks[i][j];
            }
            str += "\n";
        }
        return str;
    }

    // unit tests (not graded)
    public static void main(String[] args) {

    }

    private boolean inPosition(int i, int j) {
        return blocks[i][j] != 0 && blocks[i][j] == (i * blocks.length + j + 1);
    }
}