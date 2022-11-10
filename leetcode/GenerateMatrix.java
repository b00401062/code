package leetcode;

class GenerateMatrix {
    public static int[][] generateMatrix(int n) {
        var a = new int[n][n];
        var r = 0;
        var c = 0;
        var dr = new int[] { 0, 1, 0, -1 };
        var dc = new int[] { 1, 0, -1, 0 };
        var d = 0;
        var k = 1;
        for (var i = 0; i < n * n; i++) {
            a[r][c] = k++;
            var nr = r + dr[d];
            var nc = c + dc[d];
            if (nc >= 0 && nr >= 0 && nc < n && nr < n && a[nr][nc] == 0) {
                r = nr;
                c = nc;
            } else {
                d = (d + 1) % 4;
                r += dr[d];
                c += dc[d];
            }
        }
        return a;
    }
}
