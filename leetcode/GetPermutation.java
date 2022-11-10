package leetcode;

class GetPermutation {
    private static int factorial(int n) {
        return n == 1 ? 1 : n * factorial(n - 1);
    }

    public static String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }
        var flags = new boolean[n];
        var res = new StringBuilder();
        var curN = n;
        var curK = k;
        while (curN >= 1) {
            var nPerm = factorial(curN);
            var pos = (curK - 1) / (nPerm / curN);
            for (var i = 0; i < n; i++) {
                if (flags[i]) continue;
                pos--;
                if (pos < 0) {
                    flags[i] = true;
                    res.append(String.valueOf(i + 1));
                    break;
                }
            }
            curK = (curK - 1) % (nPerm / curN) + 1;
            curN--;
        }
        return res.toString();
    }
}
