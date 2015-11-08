package eugeneto.princeton.algorithm.exercises.week4.ex;

import edu.princeton.cs.algs4.StdOut;
import eugeneto.princeton.algorithm.Utils;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 30.10.15
 * Time: 18:09
 * To change this template use File | Settings | File Templates.
 */
public class Tester {
    public static void main(String[] args) {
        int[][] blocks = parseBlocks();
        Board initial = new Board(blocks);
        System.out.println("init hamming " + initial.hamming());
        System.out.println("init manhattan " + initial.manhattan());
        System.out.println("======================================");
        System.out.println(initial);
        System.out.println("======================================");

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable()) {
            StdOut.println("No solution possible");
            StdOut.println("Minimum number of moves = " + solver.moves());
        } else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution()) {
                StdOut.println(board);
                StdOut.println();
            }
        }
    }

    private static int[][] parseBlocks() {
        // 3 / 18 steps !!!!
        String str =
            " 8  6  7 \n" +
                    " 2  5  4 \n" +
                    " 3  0  1 ";
        String[] split = str.split("\n");
        int[][] arr = new int[split.length][split.length];
        int k = 0;
        for (String s : split) {
            s = s.replaceAll("\\s+", " ").trim();
            arr[k] = Utils.strToIntArray(s.split("\\s"));
            k++;
        }
        return arr;
    }
}
