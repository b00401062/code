package leetcode;

class CountAndSay {
    public static String countAndSay(int n) {
        var s = "1";
        while (--n > 0) {
            var res = new StringBuilder();
            var i = 0;
            while (i < s.length()) {
                var count = 1;
                while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                    count++;
                }
                res.append(count).append(s.charAt(i));
                i++;
            }
            s = res.toString();
        }
        return s;
    }
}
