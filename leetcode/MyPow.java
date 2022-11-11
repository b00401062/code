package leetcode;

class MyPow {
    public static double myPow(double x, int n) {
        return (
            n == 0 ? 1.0 :
            n == 1 ? x :
            n == 2 ? x * x :
            n == -1 ? 1 / x :
            myPow(x, n % 2) * myPow(myPow(x, n / 2), 2)
        );
    }
}
