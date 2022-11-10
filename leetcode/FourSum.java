package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        var list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (var i = 0; i < nums.length - 3; i++) {
            for (var j = i + 1; j < nums.length - 2; j++) {
                var l = j + 1;
                var r = nums.length - 1;
                while (l < r) {
                    var sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    System.out.println(sum);
                    if (sum < target)
                        l++;
                    else if (sum > target)
                        r--;
                    else {
                        var e = List.of(nums[i], nums[j], nums[l], nums[r]);
                        if (!list.contains(e))
                            list.add(e);
                        l++;
                        r--;
                    }
                }
            }
        }
        return list;
    }
}
