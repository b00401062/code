package leetcode;

class Reverse {
    public static int reverse(int x) {
        var y = 0;
        while (x != 0) {
            var pop = x % 10;
            x /= 10;
            if (
                y > Integer.MAX_VALUE / 10
                || y == Integer.MAX_VALUE / 10 && pop > 7
                || y < Integer.MIN_VALUE / 10
                || y == Integer.MIN_VALUE / 10 && pop < -8
            ) return 0;
            y = y * 10 + pop;
        }
        return y;
    }
}
