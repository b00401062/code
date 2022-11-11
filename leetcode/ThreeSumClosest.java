package leetcode;

import java.util.Arrays;

class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        var delta = nums[0] + nums[1] + nums[2] - target;
        Arrays.sort(nums);
        for (var i = 0; i < nums.length - 2; i++) {
            var l = i + 1;
            var r = nums.length - 1;
            while (l < r) {
                var sum = nums[i] + nums[l] + nums[r];
                if (sum <= target - Math.abs(delta))
                    l++;
                else if (sum >= target + Math.abs(delta))
                    r--;
                else {
                    delta = sum - target;
                    if (delta == 0) return target;
                }
            }
        }
        return target + delta;
    }
}
