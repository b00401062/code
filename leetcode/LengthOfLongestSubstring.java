package leetcode;

class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        var length = 0;
        var substring = "";
        for (var c : s.toCharArray()) {
            substring = substring.substring(substring.indexOf(c) + 1) + c;
            length = Math.max(length, substring.length());
        }
        return length;
    }
}
