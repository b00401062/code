package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Merge {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, Comparator.comparingInt((it) -> it[0]));
        var mergedIntervals = new ArrayList<int[]>();
        var lowerLimit = intervals[0][0];
        var upperLimit = intervals[0][1];
        for (var interval : intervals) {
            if (interval[0] > upperLimit) {
                mergedIntervals.add(new int[] { lowerLimit, upperLimit });
                lowerLimit = interval[0];
                upperLimit = interval[1];
            } else {
                upperLimit = Math.max(upperLimit, interval[1]);
            }
        }
        mergedIntervals.add(new int[] { lowerLimit, upperLimit });
        return mergedIntervals.toArray(int[][]::new);
    }
}
