package leetcode

import kotlin.math.min

fun rotate(matrix: Array<IntArray>): Unit {
    var n = matrix.size
    for (var i = 0; i < n - 1; i++) {
        for (j in 0..min(i, n - i - 2)) {
            var lt = matrix[i][j]
            var ur = matrix[j][n - i - 1]
            var rt = matrix[n - i - 1][n - j - 1]
            var lr = matrix[n - j - 1][i]
            matrix[i][j] = lr
            matrix[j][n - i - 1] = lt
            matrix[n - i - 1][n - j - 1] = ur
            matrix[n - j - 1][i] = rt
        }
    }
}
