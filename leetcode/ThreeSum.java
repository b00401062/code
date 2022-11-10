package leetcode

fun threeSum(nums: IntArray): List<List<Int>> {
    var list = mutableListOf<List<Int>>()
    nums.sort()
    for (i in 0 until nums.size - 2) {
        var l = i + 1
        var r = nums.lastIndex
        while (l < r) {
            var sum = nums[i] + nums[l] + nums[r]
            if (sum < 0)
                l++
            else if (sum > 0)
                r--
            else {
                var e = listOf(nums[i], nums[l], nums[r])
                if (!list.contains(e))
                    list.add(e)
                l++
                r--
            }
        }
    }
    return list
}
