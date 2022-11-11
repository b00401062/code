package leetcode;

class Rotate {
    public static void rotate(int[][] matrix) {
        var n = matrix.length;
        for (var i = 0; i < n - 1; i++) {
            for (var j = 0; j <= Math.min(i, n - i - 2); j++) {
                var lt = matrix[i][j];
                var ur = matrix[j][n - i - 1];
                var rt = matrix[n - i - 1][n - j - 1];
                var lr = matrix[n - j - 1][i];
                matrix[i][j] = lr;
                matrix[j][n - i - 1] = lt;
                matrix[n - i - 1][n - j - 1] = ur;
                matrix[n - j - 1][i] = rt;
            }
        }
    }
}
