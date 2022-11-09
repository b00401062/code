package leetcode;

class Divide {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        var sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        var dvd = Math.abs((long) dividend);
        var dvs = Math.abs((long) divisor);
        var quotient = 0;
        while (dvd >= dvs) {
            dvd -= dvs;
            quotient++;
        }
        return sign * quotient;
    }
}
