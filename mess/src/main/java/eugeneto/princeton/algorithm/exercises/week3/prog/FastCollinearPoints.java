package eugeneto.princeton.algorithm.exercises.week3.prog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 15.10.15
 * Time: 11:06
 * To change this template use File | Settings | File Templates.
 */
public class FastCollinearPoints {
    /*private ArrayList<eugeneto.princeton.algorithm.exercises.week3.prog.Point> minPoints = new ArrayList<>();
    private ArrayList<eugeneto.princeton.algorithm.exercises.week3.prog.Point> maxPoints = new ArrayList<>();*/
    private List<LineSegment> lines = new ArrayList<>();
    private Point[] points;
    private Point[] dupPoints;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] p) {
        points = new Point[p.length];
        dupPoints = new Point[p.length];
        for (int i = 0; i < p.length; i++) {
            dupPoints[i] = p[i];
            points[i] = p[i];
        }
        if (points.length == 2 && points[0].compareTo(points[1]) == 0) throw new IllegalArgumentException();

        for (int i = 0; i < points.length; i++) {
            Arrays.sort(points, dupPoints[i].slopeOrder());
            double curSlope = points[0].slopeTo(points[1]);
            int dotCounts = -1;
            Point min = points[0];
            Point max = points[0];
            for (int k = 1; k < points.length; k++) {
                double newSlope = points[0].slopeTo(points[k]);
                if (newSlope == curSlope) {
                    dotCounts++;
                } else {
                    if (dotCounts >= 2 && min.compareTo(points[0]) == 0) {
                        addLine(min, max);
                    }
                    curSlope = newSlope;
                    dotCounts = 0;
                    min = points[0];
                    max = points[0];
                }
                if (min.compareTo(points[k]) > 0) {
                    min = points[k];
                }
                if (max.compareTo(points[k]) < 0) max = points[k];
            }
            if (dotCounts >= 2 && min.compareTo(points[0]) == 0) {
                addLine(min, max);
            }
        }

    }

    private void addLine(Point min, Point max) {
        lines.add(new LineSegment(min, max));
    }

    // the number of line segments
    public int numberOfSegments() {
        return lines.size();
    }

    // the line segments
    public LineSegment[] segments() {
        return lines.toArray(new LineSegment[]{});
    }
}
