package leetcode;

class NextPermutation {
    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j] ^ (nums[j] = nums[i]);
    }

    private static void reverse (int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    public static void nextPermutation(int[] nums) {
        var l = nums.length - 2;
        while (l >= 0 && nums[l] >= nums[l + 1])
            l--;
        if (l == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        var r = l + 1;
        while (r < nums.length - 1 && nums[l] < nums[r + 1])
            r++;
        swap(nums, l, r);
        reverse(nums, l + 1, nums.length - 1);
    }
}
