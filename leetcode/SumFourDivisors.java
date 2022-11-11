package leetcode;

class SumFourDivisors {
    public static int sumFourDivisors(int[] nums) {
        var res = 0;
        for (var num : nums) {
            var d = 0;
            for (var i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    if (d == 0) {
                        d = i;
                    } else {
                        d = 0;
                        break;
                    }
                }
            }
            if (d > 0 && d * d != num) {
                res += 1 + num + d + num / d;
            }
        }
        return res;
    }
}
