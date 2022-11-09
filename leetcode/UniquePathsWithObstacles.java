package leetcode;

class UniquePathsWithObstacles {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        var nrow = obstacleGrid.length;
        var ncol = obstacleGrid[0].length;
        var dp = new int[nrow + 1][ncol + 1];
        dp[0][1] = 1;
        for (var i = 0; i < nrow; i++) {
            for (var j = 0; j < ncol; j++) {
                dp[i + 1][j + 1] = obstacleGrid[i][j] == 0 ? dp[i][j + 1] + dp[i + 1][j] : 0;
            }
        }
        return dp[nrow][ncol];
    }
}
