package leetcode;

class CombinationSum4 {
    public static int combinationSum4(int[] nums, int target) {
        var cache = new int[target + 1];
        cache[0] = 1;
        for (var i = 1; i <= target; i++) {
            for (var num : nums) {
                if (num > i) continue;
                cache[i] += cache[i - num];
            }
        }
        return cache[target];
    }
}
