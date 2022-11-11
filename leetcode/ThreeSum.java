package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        var list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (var i = 0; i < nums.length - 2; i++) {
            var l = i + 1;
            var r = nums.length - 1;
            while (l < r) {
                var sum = nums[i] + nums[l] + nums[r];
                if (sum < 0)
                    l++;
                else if (sum > 0)
                    r--;
                else {
                    var e = List.of(nums[i], nums[l], nums[r]);
                    if (!list.contains(e))
                        list.add(e);
                    l++;
                    r--;
                }
            }
        }
        return list;
    }
}
