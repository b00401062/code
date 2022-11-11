package leetcode;

class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        var sb = new StringBuilder(s);
        var changed = false;
        do {
            changed = false;
            var lt_idx = -1;
            for (var i = 0; i < sb.length(); i++) {
                var c = sb.charAt(i);
                if (c == '(') {
                    lt_idx = i;
                } else if (c == ')' && lt_idx != -1) {
                    sb.setCharAt(lt_idx, '*');
                    sb.setCharAt(i, '*');
                    lt_idx = -1;
                    changed = true;
                }
            }
        } while (changed);
        var res = 0;
        var cnt = 0;
        for (var c : sb.toString().toCharArray()) {
            if (c != '*') {
                res = Math.max(res, cnt);
                cnt = 0;
            } else
                cnt++;
        }
        res = Math.max(res, cnt);
        return res;
    }
}
