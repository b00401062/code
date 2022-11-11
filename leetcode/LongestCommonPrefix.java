package leetcode;

import java.util.Arrays;

class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        return Arrays.stream(strs).reduce((s1, s2) -> {
            var maxCommonPrefixLen = Math.min(s1.length(), s2.length());
            for (var i = 0; i < maxCommonPrefixLen; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return s1.substring(0, i);
                }
            }
            return s1.substring(0, maxCommonPrefixLen);
        }).orElse("");
    }
}
