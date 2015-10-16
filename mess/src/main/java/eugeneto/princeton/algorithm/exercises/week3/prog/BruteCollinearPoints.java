package eugeneto.princeton.algorithm.exercises.week3.prog;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 15.10.15
 * Time: 11:07
 * To change this template use File | Settings | File Templates.
 */
public class BruteCollinearPoints {
    private ArrayList<LineSegment> lines = new ArrayList<>();

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new NullPointerException();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        if (points[i].compareTo(points[j]) == 0 ||
                                points[i].compareTo(points[k]) == 0 ||
                                points[i].compareTo(points[l]) == 0 ||
                                points[j].compareTo(points[k]) == 0 ||
                                points[j].compareTo(points[l]) == 0 ||
                                points[k].compareTo(points[l]) == 0) {
                            throw new IllegalArgumentException();
                        }

                        double slope1 = points[i].slopeTo(points[j]);
                        double slope2 = points[j].slopeTo(points[k]);
                        double slope3 = points[k].slopeTo(points[l]);
                        if (slope1 == slope2 && slope2 == slope3) {
                            Point[] arr = new Point[] {points[i], points[j], points[k], points[l]};
                            Arrays.sort(arr);
                            lines.add(new LineSegment(arr[0], arr[arr.length - 1]));
                        }
                    }
                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return lines.size();
    }

    // the line segments
    public LineSegment[] segments() {
        return lines.toArray(new LineSegment[]{});
    }

    public static void main(String[] args) {

        // read the N points from a file
       /* In in = new In(args[0]);
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }*/
        Point[] points = new Point[8];
        points[0] = new Point(10000, 0);
        points[1] = new Point(0, 10000);
        points[2] = new Point(3000, 7000);
        points[3] = new Point(7000, 3000);
        points[4] = new Point(20000, 21000);
        points[5] = new Point(3000, 4000);
        points[6] = new Point(14000, 15000);
        points[7] = new Point(6000, 7000);

        // draw the points
        StdDraw.show(0);
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
    }
}
