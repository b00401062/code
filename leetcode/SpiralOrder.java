package leetcode;

import java.util.ArrayList;
import java.util.List;

class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        var list = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return list;
        }
        var m = matrix.length - 1;
        var n = matrix[0].length - 1;
        var r = 0;
        var c = 0;
        while (r <= m && c <= n) {
            for (var j = r; j <= n; j++) {
                list.add(matrix[r][j]);
            }
            r++;
            for (var i = r; i <= m; i++) {
                list.add(matrix[i][n]);
            }
            n--;
            if (r <= m) {
                for (var j = n; j >= c; j--) {
                    list.add(matrix[m][j]);
                }
                m--;
            }
            if (c <= n) {
                for (var i = m; i >= r; i--) {
                    list.add(matrix[i][c]);
                }
                c++;
            }
        }
        return list;
    }
}
