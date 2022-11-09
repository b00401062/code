package leetcode;

class UniquePaths {
    private static int choose(int n, int k) {
        var res = 1L;
        for (var i = 0; i < k; i++) {
            res = res * (n - i) / (i + 1);
        }
        return (int) res;
    }

    public static int uniquePaths(int m, int n) {
        return choose(m + n - 2, Math.min(m - 1, n - 1));
    }
}
