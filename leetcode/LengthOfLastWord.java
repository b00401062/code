package leetcode;

class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        var isalpha = false;
        var lt = -1;
        var rt = -1;
        for (var i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && !isalpha) {
                rt = i;
                isalpha = true;
            } else if (s.charAt(i) == ' ' && isalpha) {
                lt = i;
                break;
            }
        }
        return rt - lt;
    }
}
