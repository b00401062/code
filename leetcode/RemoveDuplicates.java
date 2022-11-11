package leetcode;

class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        var count = 1;
        var log = nums[0];
        for (var it = 0; it < nums.length; it++) {
            if (nums[it] != log) {
                log = nums[it];
                nums[count] = log;
                count++;
            }
        }
        return count;
    }
}
