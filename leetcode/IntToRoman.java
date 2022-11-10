package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

class IntToRoman {
    private static final List<Entry<Integer, String>> map = new ArrayList<>() {{
        add(new SimpleImmutableEntry<>(1000, "M"));
        add(new SimpleImmutableEntry<>(900, "CM"));
        add(new SimpleImmutableEntry<>(500, "D"));
        add(new SimpleImmutableEntry<>(400, "CD"));
        add(new SimpleImmutableEntry<>(100, "C"));
        add(new SimpleImmutableEntry<>(90, "XC"));
        add(new SimpleImmutableEntry<>(50, "L"));
        add(new SimpleImmutableEntry<>(40, "XL"));
        add(new SimpleImmutableEntry<>(10, "X"));
        add(new SimpleImmutableEntry<>(9, "IX"));
        add(new SimpleImmutableEntry<>(5, "V"));
        add(new SimpleImmutableEntry<>(4, "IV"));
        add(new SimpleImmutableEntry<>(1, "I"));
    }};

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
