package leetcode;

import kotlin.math.max
import kotlin.math.min

fun trap(height: IntArray): Int {
    var amount = 0
    var ltMax = IntArray(height.size)
    var rtMax = IntArray(height.size)
    (1 until height.size).forEach {
        ltMax[it] = max(ltMax[it - 1], height[it - 1])
        rtMax[height.lastIndex - it] = max(rtMax[height.size - it], height[height.size - it])
    }
    height.indices.forEach {
        var minMax = min(ltMax[it], rtMax[it])
        var diff = minMax - height[it]
        amount += if (diff > 0) diff else 0
    }
    return amount
}
