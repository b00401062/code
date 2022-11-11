package leetcode;

class MyAtoi {
    public static int myAtoi(String s) {
        var trimmed = s.trim();
        if (trimmed.isEmpty() || "0123456789+-".indexOf(trimmed.charAt(0)) < 0)
            return 0;
        var sign = (trimmed.charAt(0) == '-') ? -1 : 1;
        var value = 0;
        var valid = false;
        for (var i = 0; i < trimmed.length(); i++) {
            if (i == 0 && "+-".indexOf(trimmed.charAt(0)) >= 0)
                continue;
            if ("0123456789".indexOf(trimmed.charAt(i)) < 0)
                break;
            var digit = trimmed.charAt(i) - '0';
            if (
                value > Integer.MAX_VALUE / 10
                || value == Integer.MAX_VALUE / 10 && digit > 7
            ) return Integer.MAX_VALUE;
            if (
                value < Integer.MIN_VALUE / 10
                || value == Integer.MIN_VALUE / 10 && digit > 8
            ) return Integer.MIN_VALUE;
            value = value * 10 + digit * sign;
            valid = true;
        }
        return valid ? value : 0;
    }
}
