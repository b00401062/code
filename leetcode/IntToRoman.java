package leetcode;

import java.util.List;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

class IntToRoman {
    private static final List<Entry<Integer, String>> map = List.of(
        new SimpleImmutableEntry<>(1000, "M"),
        new SimpleImmutableEntry<>(900, "CM"),
        new SimpleImmutableEntry<>(500, "D"),
        new SimpleImmutableEntry<>(400, "CD"),
        new SimpleImmutableEntry<>(100, "C"),
        new SimpleImmutableEntry<>(90, "XC"),
        new SimpleImmutableEntry<>(50, "L"),
        new SimpleImmutableEntry<>(40, "XL"),
        new SimpleImmutableEntry<>(10, "X"),
        new SimpleImmutableEntry<>(9, "IX"),
        new SimpleImmutableEntry<>(5, "V"),
        new SimpleImmutableEntry<>(4, "IV"),
        new SimpleImmutableEntry<>(1, "I")
    );

    public static String intToRoman(int num) {
        var roman = new StringBuilder();
        var i = num;
        for (var entry : map) {
            var k = entry.getKey();
            var v = entry.getValue();
            while (i >= k) {
                i -= k;
                roman.append(v);
            }
        }
        return roman.toString();
    }
}
