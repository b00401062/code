package leetcode;

import java.util.HashSet;

class IsHappy {
    public static boolean isHappy(int n) {
        var curr = n;
        var seen = new HashSet<Integer>();
        while (curr != 1 && !seen.contains(curr)) {
            seen.add(curr);
            var next = 0;
            while (curr != 0) {
                var digit = curr % 10;
                curr /= 10;
                next += digit * digit;
            }
            curr = next;
        }
        return curr == 1;
    }
}
