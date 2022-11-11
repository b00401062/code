package leetcode;

class PlusOne {
    private static int[] insert(int[] src, int idx, int element) {
        var dst = new int[src.length + 1];
        System.arraycopy(src, 0, dst, 0, idx);
        dst[idx] = element;
        System.arraycopy(src, idx, dst, idx + 1, src.length - idx);
        return dst;
    }

    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        for (var idx = digits.length - 1; idx >= 1; idx--) {
            if (digits[idx] >= 10) {
                digits[idx] -= 10;
                digits[idx - 1] += 1;
            } else {
                break;
            }
        }
        if (digits[0] >= 10) {
            digits[0] -= 10;
            return insert(digits, 0, 1);
        } else {
            return digits;
        }
    }
}
