package eugeneto.princeton.algorithm.exercises.week4;

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
        System.out.println("======================================");
        System.out.println(initial);
        System.out.println("======================================");

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

    private static int[][] parseBlocks() {
        // 3 / 18 steps !!!!
        String str =
            " 1  4  3 \n" +
            " 7  0  8 \n" +
            " 6  5  2 ";
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
