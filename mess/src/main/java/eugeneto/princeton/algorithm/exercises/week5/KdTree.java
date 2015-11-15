package eugeneto.princeton.algorithm.exercises.week5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 15.11.15.
 */
public class KdTree {
    private Node root = null;
    private int count = 0;

    // construct an empty set of points
    public KdTree() {}

    // is the set empty?
    public boolean isEmpty() {
        return count == 0;
    }

    // number of points in the set
    public int size() {
        return count;
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null) throw new NullPointerException();
        //System.out.println("add " + p);
        root = insert(root, p, true);
    }

    private Node insert(Node node, Point2D p, boolean prevCompareX) {
        if (node == null) {
            //System.out.println("insert " + p + " with" + prevCompareX);
            Node newNode = new Node();
            newNode.point = p;
            newNode.compareX = prevCompareX;
            count++;
            return newNode;
        } else if (node.point.equals(p)) {
            return node;
        } else {
            if (node.compareX && node.point.x() > p.x() || !node.compareX && node.point.y() > p.y()) {
                //System.out.println("go left");
                node.left = insert(node.left, p, !node.compareX);
            } else {
                //System.out.println("go right");
                node.right = insert(node.right, p, !node.compareX);
            }
            return node;
        }
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) throw new NullPointerException();
        return contains(root, p);
    }

    private boolean contains(Node node, Point2D p) {
        if (node == null) return false;
        if (node.point.equals(p)) return true;
        if (node.compareX && node.point.x() > p.x() || !node.compareX && node.point.y() > p.y()) {
            return contains(node.left, p);
        } else {
            return contains(node.right, p);
        }
    }

    // draw all points to standard draw
    public void draw() {
        //System.out.println("=======================");
        draw(root);
    }

    private void draw(Node node) {
        if (node == null) return;
        //System.out.println(node.point + ": " + node.compareX);
        node.point.draw();
        draw(node.left);
        draw(node.right);
    }

    // all points that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        if (root == null) return new ArrayList<>();
        if (rect == null) throw new NullPointerException();
        List<Point2D> points = new ArrayList<>();
        intersects(rect, root, points);
        return points;
    }

    private void intersects(RectHV rect, Node node, List<Point2D> points) {
        if (node == null) return;
        if (rect.contains(node.point)) {
            points.add(node.point);
        }
        if (node.compareX && node.point.x() >= rect.xmin() || !node.compareX && node.point.y() >= rect.ymin()) {
            intersects(rect, node.left, points);
        }
        if (node.compareX && node.point.x() <= rect.xmax() || !node.compareX && node.point.y() <= rect.ymax()) {
            intersects(rect, node.right, points);
        }
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        //System.out.println("========================= " + p);
        if (p == null) throw new NullPointerException();
        if (root == null) return null;
        return nearest(p, root, root.point);
    }

    private Point2D nearest(Point2D p, Node node, Point2D curNearest) {
        //System.out.println("--> " + p + " cur " + (node != null ? node.point : null ) + " nearest " + curNearest);
        if (node == null) return curNearest;
        if (p.distanceSquaredTo(curNearest) > p.distanceSquaredTo(node.point)) {
            curNearest = node.point;
        }

        boolean goLeft = node.compareX && p.x() <= node.point.x() || !node.compareX && p.y() <= node.point.y();
        if (goLeft) {
            //System.out.println("f left");
            curNearest = nearest(p, node.left, curNearest);
        } else {
            //System.out.println("f right");
            curNearest = nearest(p, node.right, curNearest);
        }

        Point2D iPoint = null;
        if (node.compareX) {
            iPoint = new Point2D(node.point.x(), p.y());
        } else {
            iPoint = new Point2D(p.x(), node.point.y());
        }

        if (p.distanceSquaredTo(curNearest) >= p.distanceSquaredTo(iPoint)) {
            if (goLeft) {
                //System.out.println("s right");
                curNearest = nearest(p, node.right, curNearest);
            } else {
                //System.out.println("s left");
                curNearest = nearest(p, node.left, curNearest);
            }
        }
        //System.out.println("res " + curNearest);
        return curNearest;
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {
        KdTree tree = new KdTree();
        for (double i = 0; i <= 1; i += 0.5) {
            for (double j = 0; j <= 1; j += 0.5) {
                tree.insert(new Point2D(i, j));
            }
        }
        //System.out.printf("nearest " + tree.nearest(new Point2D(0.3, 0.3)));
    }

    private static class Node {
        private Point2D point;
        private boolean compareX = true;
        private Node left;
        private Node right;


    }
}
