package eugeneto.princeton.algorithm.exercises.week4.ex;

import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 30.10.15
 * Time: 18:08
 * To change this template use File | Settings | File Templates.
 */
public class Solver {
    private MinPQ<Solution> solutions = new MinPQ<>();
    private Solution solution;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        solution = new Solution(Arrays.asList(initial));
        if (solution.isGoal()) return;
        solutions.insert(solution);
        int k = 0;
        while (true) {
            //System.out.println(initial);
            try {
                solution = solutions.delMin();
            } catch (java.util.NoSuchElementException ex) {
                return;
            }
            initial = solution.getLast();
            Board prev = solution.getPrev();
            for (Board board : initial.neighbors()) {
                if (board.isGoal()) {
                    solution.add(board);
                    return;
                }
                if(prev == null || !prev.equals(board)) {
                    Solution clone = solution.clone();
                    boolean added = clone.add(board);
                    if (added) {
                        solutions.insert(clone);
                    }
                }
            }

            k++;
            if (k >= 100000) return;
        }
    }

    // is the initial board solvable?
    public boolean isSolvable() {
        return solution.isGoal();
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return solution.moves() - 1;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        return solution.isGoal() ? solution.getBoards() : null;
    }

    // solve a slider puzzle (given below)
    public static void main(String[] args)  {

    }

    private static class Solution implements Comparable<Solution> {
        private List<Board> boards = new ArrayList<>(128);

        public Solution(List<Board> list) {
            this.boards.addAll(list);
        }

        @Override
        public int compareTo(Solution o) {
            Board o2 = o.getLast();
            Board o1 = this.getLast();
            int r = (o1.manhattan() - o2.manhattan()) + (this.boards.size() - o.boards.size());
            if (r != 0) return r;
            return (o1.hamming() - o2.hamming()) + (this.boards.size() - o.boards.size());
        }

        public boolean add(Board board) {
            for (Board b : boards) {
                if (b.equals(board)) return false;
            }
            boards.add(board);
            return true;
        }

        public boolean isGoal() {
            return getLast().isGoal();
        }

        public Board getLast() {
            return boards.get(boards.size() - 1);
        }

        public Board getPrev() {
            return boards.size() >= 2 ? boards.get(boards.size() - 2) : null;
        }

        public Solution clone() {
            return new Solution(this.boards);
        }

        public int moves() {
            return isGoal() ? boards.size() : 0;
        }

        public List<Board> getBoards() {
            return boards;
        }
    }
}
