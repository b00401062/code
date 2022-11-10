package leetcode;

import java.util.ArrayList;

class Insert {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        var ans = new ArrayList<int[]>();
        var curInterval = newInterval;
        for (var i = 0; i < intervals.length; i++) {
            if (curInterval[1] < intervals[i][0]) {
                ans.add(curInterval);
                curInterval = intervals[i];
            } else if (intervals[i][1] < curInterval[0]) {
                ans.add(intervals[i]);
            } else {
                curInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                curInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }
        ans.add(curInterval);
        return ans.toArray(int[][]::new);
    }
}
