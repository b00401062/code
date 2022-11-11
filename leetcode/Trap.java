package leetcode;

class Trap {
    public static int trap(int[] height) {
        var amount = 0;
        var ltMax = new int[height.length];
        var rtMax = new int[height.length];
        for (var it = 1; it < height.length; it++) {
            ltMax[it] = Math.max(ltMax[it - 1], height[it - 1]);
            rtMax[height.length - 1 - it] = Math.max(rtMax[height.length - it], height[height.length - it]);
        }
        for (var it = 1; it < height.length; it++) {
            var minMax = Math.min(ltMax[it], rtMax[it]);
            var diff = minMax - height[it];
            amount += diff > 0 ? diff : 0;
        }
        return amount;
    }
}
