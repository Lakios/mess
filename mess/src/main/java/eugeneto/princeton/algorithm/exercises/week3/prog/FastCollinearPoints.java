package eugeneto.princeton.algorithm.exercises.week3.prog;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 15.10.15
 * Time: 11:06
 * To change this template use File | Settings | File Templates.
 */
public class FastCollinearPoints {
    private ArrayList<LineSegment> lines = new ArrayList<>();

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            Arrays.sort(points, i + 1, points.length, points[i].slopeOrder());
            double curSlope = points[i].slopeTo(points[i + 1]);
            int dotCounts = -1;
            Point min = points[i];
            Point max = points[i];
            for (int k = i + 1; k < points.length; k++) {
                double newSlope = points[i].slopeTo(points[k]);
                if (newSlope - curSlope == 0) {
                    dotCounts++;
                } else {
                    if (dotCounts >= 2) {
                        lines.add(new LineSegment(min, max));
                    }
                    curSlope = newSlope;
                    dotCounts = 0;
                    min = points[i];
                    max = points[i];
                }
                if (min.compareTo(points[k]) > 0) min = points[k];
                if (max.compareTo(points[k]) < 0) max = points[k];
            }
            if (dotCounts >= 2) {
                lines.add(new LineSegment(min, max));
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
}
