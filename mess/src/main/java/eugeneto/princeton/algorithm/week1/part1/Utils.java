package eugeneto.princeton.algorithm.week1.part1;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 06.10.15
 * Time: 10:58
 * To change this template use File | Settings | File Templates.
 */
public class Utils {
    public static int[] strToIntArray(String[] strArr) {
        int[] intarr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intarr[i] = Integer.valueOf(strArr[i]);
        }
        return intarr;
    }
}
