package eugeneto.princeton.algorithm.exercises.week4.ex;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 29.10.15
 * Time: 10:28
 * To change this template use File | Settings | File Templates.
 */
public class BstTree {
    private BstNode root;

    public void add(BstNode node) {
        root = add(root, node);
    }

    private BstNode add(BstNode locRoot, BstNode node) {
        if (locRoot == null) return node;
        if (node.getValue().compareTo(locRoot.getValue()) > 0) {
            locRoot.setRight(add(locRoot.getRight(), node));
        } else {
            locRoot.setLeft(add(locRoot.getLeft(), node));
        }
        return locRoot;
    }

    public void printLeftOrder() {
        printLeftRootRight(root);
        System.out.println();
    }

    private void printLeftRootRight(BstNode node) {
        System.out.print(node.getValue() + " ");
        if (node.getLeft() != null) {
            printLeftRootRight(node.getLeft());
        }
        if (node.getRight() != null) {
            printLeftRootRight(node.getRight());
        }
    }

    public static <T> void initFromLeftRootRight(T[] els) {

    }
}
