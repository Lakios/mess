package eugeneto.princeton.algorithm.week1.part1.exercises.week1.part2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 02.10.15
 * Time: 10:46
 * To change this template use File | Settings | File Templates.
 */
public class OrderOfGrowsEstimation {
    private static String str = "512     0.000\n" +
            "     1024     0.001\n" +
            "     2048     0.004\n" +
            "     4096     0.014\n" +
            "     8192     0.053\n" +
            "    16384     0.202\n" +
            "    32768     0.768\n" +
            "    65536     2.882\n" +
            "   131072    10.956\n" +
            "   262144    41.490\n" +
            "   524288   156.390\n" +
            "  1048576   588.714\n" +
            "  2097152  2222.601";

    public static void main(String[] args) {
        Double previous = null;
        List<Double> list = Arrays.stream(str.split("[\\s\n]"))
                .filter(s -> s.contains("."))
                .filter(s -> s != null && s.trim().length() > 0)
                .map(s -> Double.valueOf(s))
                .filter(d -> d > 0)
                .map(d -> Math.log(d) / Math.log(2))
                .collect(Collectors.toList());
        for (Double d : list) {
            if (previous != null) {
                System.out.println((d - previous));
            }
            previous = d;
        }
    }
}
