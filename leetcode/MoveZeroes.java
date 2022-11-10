package leetcode

fun moveZeroes(nums: IntArray): Unit {
    var non_zero_count = 0
    for (num in nums) {
        if (num == 0) continue
        nums[non_zero_count] = num
        non_zero_count += 1
    }
    for (var idx = non_zero_count; idx < nums.size; idx++) {
        nums[idx] = 0
    }
}
