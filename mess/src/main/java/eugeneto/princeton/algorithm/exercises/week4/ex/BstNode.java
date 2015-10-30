package eugeneto.princeton.algorithm.exercises.week4.ex;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 29.10.15
 * Time: 10:27
 * To change this template use File | Settings | File Templates.
 */
public class BstNode<T extends Comparable<T>> {
    private T value;
    private BstNode left;
    private BstNode right;

    public BstNode(T value) {
        this.value = value;
    }

    public BstNode<T> getLeft() {
        return left;
    }

    public void setLeft(BstNode left) {
        this.left = left;
    }

    public BstNode<T> getRight() {
        return right;
    }

    public void setRight(BstNode right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
