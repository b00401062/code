package leetcode;

class LongestPalindrome {
    private static int[] check(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return new int[] { l + 1, r };
    }

    public static String longestPalindrome(String s) {
        var curB = new int[2];
        for (var i = 0; i < s.length(); i++) {
            var evenB = check(s, i - 1, i + 1);
            if (evenB[1] - evenB[0] > curB[1] - curB[0])
                curB = evenB;
            var oddB = check(s, i, i + 1);
            if (oddB[1] - oddB[0] > curB[1] - curB[0])
                curB = oddB;
        }
        return s.substring(curB[0], curB[1]);
    }
}
