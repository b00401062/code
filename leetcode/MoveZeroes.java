package leetcode;

class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        var non_zero_count = 0;
        for (var num : nums) {
            if (num == 0) continue;
            nums[non_zero_count] = num;
            non_zero_count++;
        }
        for (var idx = non_zero_count; idx < nums.length; idx++) {
            nums[idx] = 0;
        }
    }
}
