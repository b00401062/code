package leetcode;

import java.util.HashMap;
import java.util.Map;

class RomanToInt {
    private static final Map<String, Integer> MAP = new HashMap<>() {{
        put("I", 1);
        put("IV", 4);
        put("V", 5);
        put("IX", 9);
        put("X", 10);
        put("XL", 40);
        put("L", 50);
        put("XC", 90);
        put("C", 100);
        put("CD", 400);
        put("D", 500);
        put("CM", 900);
        put("M", 1000);
    }};

    public static int romanToInt(String s) {
        var i = 0;
        var num = 0;
        while (i < s.length()) {
            if (i < s.length() - 1 && MAP.containsKey(s.substring(i, i + 2))) {
                num += MAP.get(s.substring(i, i + 2));
                i += 2;
            } else {
                num += MAP.get(s.substring(i, i + 1));
                i++;
            }
        }
        return num;
    }
}
