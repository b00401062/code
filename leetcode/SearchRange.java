package leetcode;

class SearchRange {
    private static int searchLtMargin(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        var lt = -1;
        var rt = nums.length;
        while (lt + 1 < rt) {
            var mid = (lt + rt) / 2;
            if (nums[mid] >= target)
                rt = mid;
            else
                lt = mid;
        }
        return rt < nums.length && nums[rt] == target ? rt : -1;
    }

    private static int searchRtMargin(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        var lt = -1;
        var rt = nums.length;
        while (lt + 1 < rt) {
            var mid = (lt + rt) / 2;
            if (nums[mid] <= target)
                lt = mid;
            else
                rt = mid;
        }
        return lt >= 0 && nums[lt] == target ? lt : -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[] {
            searchLtMargin(nums, target),
            searchRtMargin(nums, target)
        };
    }
}
