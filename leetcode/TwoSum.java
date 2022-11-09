package leetcode;

import java.util.Arrays;
import java.util.HashMap;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (var i = 0; i < nums.length; i++)
            if (map.containsKey(target - nums[i]))
                return new int[] { map.get(target - nums[i]), i };
            else
                map.put(nums[i], i);
        return null;
    }
}
