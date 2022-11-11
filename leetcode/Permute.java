package leetcode;

fun permute(nums: IntArray): List<List<Int>> {
    if (nums.isEmpty())
        return listOf()
    var list = mutableListOf<List<Int>>()
    list.add(nums.copyOf().asList())
    var times = (1..nums.size).reduce { x1: Int, x2: Int -> x1 * x2 }
    repeat(times - 1) {
        nextPermutation(nums)
        list.add(nums.copyOf().asList())
    }
    return list
}
