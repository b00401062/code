package leetcode;

class SingleNumber {
    public static int singleNumber(int[] nums) {
        var res = 0;
        for (var num : nums) {
            res ^= num;
        }
        return res;
    }
}
