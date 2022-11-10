package leetcode;

class MaxArea {
    public static int maxArea(int[] height) {
        var l = 0;
        var r = height.length - 1;
        var a = (r - l) * Math.min(height[l], height[r]);
        while (l < r) {
            if (height[l] < height[r]) l++;
            else r--;
            a = Math.max(a, (r - l) * Math.min(height[l], height[r]));
        }
        return a;
    }
}
