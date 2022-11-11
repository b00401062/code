package leetcode;

class StrStr {
    private static int[] compile(String needle) {
        var table = new int[needle.length()];
        table[0] = -1;
        var k = -1;
        for (var i = 1; i < needle.length(); i++) {
            while (k >= 0 && needle.charAt(k + 1) != needle.charAt(i))
                k = table[k];
            if (needle.charAt(k + 1) == needle.charAt(i))
                k++;
            table[i] = k;
        }
        return table;
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;
        var table = compile(needle);
        var k = -1;
        for (var i = 0; i < haystack.length(); i++) {
            while (k >= 0 && needle.charAt(k + 1) != haystack.charAt(i))
                k = table[k];
            if (needle.charAt(k + 1) == haystack.charAt(i))
                k++;
            if (k == needle.length() - 1)
                return i - k;
        }
        return -1;
    }
}
