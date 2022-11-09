package leetcode;

class CanJump {
    public static boolean canJump(int[] nums) {
        var maxIndex = 0;
        for (var curIndex = 0; curIndex < nums.length; curIndex++) {
            if (curIndex > maxIndex)
                return false;
            maxIndex = Math.max(maxIndex, curIndex + nums[curIndex]);
        }
        return true;
    }
}
