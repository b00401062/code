package leetcode;

class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        var count = 0;
        for (var num : nums)
            if (num != val)
                nums[count++] = num;
        return count;
    }
}
