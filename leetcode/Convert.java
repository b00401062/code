package leetcode;

class Convert {
    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        var y = new char[s.length()];
        var i = 0;
        for (var r = 0; r < numRows; r++) {
            var jumps = new int[] { (numRows - r - 1) * 2, r * 2 };
            var p = r;
            var j = 0;
            while (p < s.length()) {
                y[i++] = s.charAt(p);
                if (jumps[j] == 0)
                    j = 1 - j;
                p += jumps[j];
                j = 1 - j;
            }
        }
        return String.valueOf(y);
    }
}
