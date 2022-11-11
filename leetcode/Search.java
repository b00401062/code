package leetcode;

class Search {
    private static int bruteForceSearch(int[] nums, int lt, int rt, int target) {
        for (int i = lt; i < rt; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    private static int recursiveSearch(int[] nums, int lt, int rt, int target) {
        int m = (lt + rt) / 2;
        return (
            rt - lt < 2 ? bruteForceSearch(nums, lt, rt, target) :
            nums[m] == target ? m :
            (nums[lt] <= target) ^ (target < nums[m]) ^ (nums[lt] <= nums[m]) ? recursiveSearch(nums, lt, m, target) :
            recursiveSearch(nums, m + 1, rt, target)
        );
    }

    public static int search(int[] nums, int target) {
        return recursiveSearch(nums, 0, nums.length, target);
    }
}
