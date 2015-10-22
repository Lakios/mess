package eugeneto.princeton.algorithm.exercises.week3.prog;

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
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException();
                }
                for (int k = j + 1; k < points.length; k++) {
                    if (points[i].compareTo(points[k]) == 0 ||
                            points[j].compareTo(points[k]) == 0) {
                        throw new IllegalArgumentException();
                    }
                    for (int l = k + 1; l < points.length; l++) {
                        if (points[i].compareTo(points[l]) == 0 ||
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

    }
}
