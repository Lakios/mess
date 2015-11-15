package eugeneto.princeton.algorithm.exercises.week5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.TreeSet;

import static java.util.stream.Collectors.toList;

/**
 * Created by eugene on 15.11.15.
 */
public class PointSET {
    private TreeSet<Point2D> bst;

    // construct an empty set of points
    public PointSET() {
        bst = new TreeSet<>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    // number of points in the set
    public int size() {
        return bst.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null) throw new NullPointerException();
        bst.add(p);
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) throw new NullPointerException();
        return bst.contains(p);
    }

    // draw all points to standard draw
    public void draw() {
        bst.forEach(Point2D::draw);
    }

    // all points that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new NullPointerException();
        if (rect == null) throw new NullPointerException();
        return bst.stream().filter(rect::contains).collect(toList());
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if (p == null) throw new NullPointerException();
        return bst.stream().max((p1, p2) -> {
            double d1 = p1.distanceSquaredTo(p);
            double d2 = p2.distanceSquaredTo(p);
            if (d1 > d2) return -1;
            if (d1 < d2) return 1;
            return 0;
        }).orElse(null);
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {

    }
}
