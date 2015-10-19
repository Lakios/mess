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
    private ArrayList<Point> minPoints = new ArrayList<>();
    private ArrayList<Point> maxPoints = new ArrayList<>();

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        Arrays.sort(points);
        for (int i = 0; i < points.length - 1; i++) {
            Arrays.sort(points, i, points.length);
            Arrays.sort(points, i + 1, points.length, points[i].slopeOrder());
            double curSlope = points[i].slopeTo(points[i + 1]);
            int dotCounts = -1;
            Point min = points[i];
            Point max = points[i];
            for (int k = i + 1; k < points.length; k++) {
                double newSlope = points[i].slopeTo(points[k]);
                if (newSlope == curSlope) {
                    dotCounts++;
                } else {
                    if (dotCounts >= 2) {
                        addLine(min, max);
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
                addLine(min, max);
            }
        }

    }

    private void addLine(Point min, Point max) {
        for (int i = 0; i < minPoints.size(); i++) {
            if ((max.compareTo(maxPoints.get(i)) == 0 || min.compareTo(minPoints.get(i)) == 0)&&
                    (min.slopeTo(max) == minPoints.get(i).slopeTo(maxPoints.get(i)))) {
                return;
            }
        }
        minPoints.add(min);
        maxPoints.add(max);
    }

    // the number of line segments
    public int numberOfSegments() {
        return minPoints.size();
    }

    // the line segments
    public LineSegment[] segments() {
        LineSegment[] arr = new LineSegment[minPoints.size()];
        for (int i = 0; i < minPoints.size(); i++) {
            arr[i] = new LineSegment(minPoints.get(i), maxPoints.get(i));
        }
        return arr;
    }
}
