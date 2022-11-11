package leetcode;

class SearchInsert {
    private static int searchInsertInRange(int[] nums, int lt, int rt, int target) {
        if (lt == rt) return lt;
        else if (lt + 1 == rt) return target <= nums[lt] ? lt : rt;
        var mid = (lt + rt) / 2;
        if (target < nums[mid])
            return searchInsertInRange(nums, lt, mid, target);
        else if (target == nums[mid])
            return mid;
        else
            return searchInsertInRange(nums, mid, rt, target);
    }

    public static int searchInsert(int[] nums, int target) {
        return searchInsertInRange(nums, 0, nums.length, target);
    }
}
