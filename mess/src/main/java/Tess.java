import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 16.10.15
 * Time: 17:44
 * To change this template use File | Settings | File Templates.
 */
public class Tess {
    public static void main(String[] args) throws Exception {
        Point[] points = Files.lines(Paths.get("D:\\bm\\mess\\collinear-testing\\collinear\\input299.txt"))
                .skip(1)
                .filter(s -> s != null && !s.trim().isEmpty())
                .map(s -> s.replaceAll("\\s+", " "))
                .map(s -> {
                    s = s.trim();
                    return new Point(Integer.valueOf(s.split("\\s")[0]), Integer.valueOf(s.split("\\s")[1]));
                }).collect(toList()).toArray(new Point[]{});


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
