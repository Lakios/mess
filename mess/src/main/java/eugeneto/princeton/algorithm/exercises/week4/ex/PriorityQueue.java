package eugeneto.princeton.algorithm.exercises.week4.ex;

import eugeneto.princeton.algorithm.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: Tochilkin
 * Date: 22.10.15
 * Time: 10:00
 * To change this template use File | Settings | File Templates.
 */
public class PriorityQueue {
    private static String sorted = "77 76 66 60 54 44 65 10 27 48";
    private static String insert = "79 59 75";
    private static String sortedToDel = "76 75 60 24 70 10 36 13 21 67";

    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        List<Integer> listToDel = new ArrayList<>();
        Arrays.stream(Utils.strToIntArray(sorted.split("\\s"))).forEach(e -> list.add(e));
        Arrays.stream(Utils.strToIntArray(sortedToDel.split("\\s"))).forEach(e -> listToDel.add(e));
        int ins[] = Utils.strToIntArray(insert.split("\\s"));

        for (int ie : ins) {
            list.add(ie);
            int sw = list.size() - 1;
            while (sw > 0) {
                sw = swim(sw, list);
            }
        }
        System.out.println(list.stream().map(i -> i.toString()).collect(Collectors.joining(" ")));

        System.out.println("----------------------------------");

        for (int i = 0; i < 3; i++) {
            //System.out.println(listToDel.stream().map(iee -> iee.toString()).collect(Collectors.joining(" ")));
            listToDel.set(0, listToDel.get(listToDel.size() - 1));
            listToDel.remove(listToDel.size() - 1);
            int pos = 0;
            while (pos >= 0) {
                pos = sink(pos, listToDel);
            }
        }
        System.out.println(listToDel.stream().map(i -> i.toString()).collect(Collectors.joining(" ")));
    }

    private static int swim(int pos, List<Integer> list) {
        if (list.get(pos) > list.get((pos - 1) / 2)) {
            int urr = list.get(pos);
            list.set(pos, list.get((pos - 1) / 2));
            list.set((pos - 1) / 2, urr);
            return (pos - 1) / 2;
        }
        return -1;
    }

    private static int sink(int pos, List<Integer> list) {
        if ((pos + 1) * 2 - 1 >= list.size()) return -1;

        int left = list.get((pos + 1) * 2 - 1);
        int right = (pos + 1) * 2 < list.size() ? list.get((pos + 1) * 2) : Integer.MIN_VALUE;

        if (list.get(pos) < left && list.get(pos) < right) {
            if (left < right) {
                list.set((pos + 1) * 2, list.get(pos));
                list.set(pos, right);
                return (pos + 1) * 2;
            } else {
                list.set((pos + 1) * 2 - 1, list.get(pos));
                list.set(pos, left);
                return (pos + 1) * 2 - 1;
            }
        } else if (list.get(pos) < left) {
            list.set((pos + 1) * 2 -1 , list.get(pos));
            list.set(pos, left);
            return (pos + 1) * 2 - 1;
        } else if (list.get(pos) < right) {
            list.set((pos + 1) * 2, list.get(pos));
            list.set(pos, right);
            return (pos + 1) * 2;
        } else {
            return -1;
        }
    }
}
