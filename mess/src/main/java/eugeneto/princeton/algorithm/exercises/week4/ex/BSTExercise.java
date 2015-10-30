package eugeneto.princeton.algorithm.exercises.week4.ex;

import eugeneto.princeton.algorithm.Utils;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 29.10.15
 * Time: 10:27
 * To change this template use File | Settings | File Templates.
 */
public class BSTExercise {
    private static String elems = "75 51 61 26 60 29 46 99 73 77";

    public static void main(String[] args) {
        BstTree tree = new BstTree();
        for (int e : Utils.strToIntArray(elems.split("\\s"))) {
            tree.add(new BstNode(e));
        }

        tree.printLeftOrder();
    }
}
