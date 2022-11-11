package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class LetterCombinations {
    private static final Map<Character, List<String>> map = Map.of(
        '2', List.of("a", "b", "c"),
        '3', List.of("d", "e", "f"),
        '4', List.of("g", "h", "i"),
        '5', List.of("j", "k", "l"),
        '6', List.of("m", "n", "o"),
        '7', List.of("p", "q", "r", "s"),
        '8', List.of("t", "u", "v"),
        '9', List.of("w", "x", "y", "z")
    );

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return List.of();
        var suffixes = letterCombinations(digits.substring(1));
        if (suffixes.isEmpty())
            return map.get(digits.charAt(0));
        var list = new ArrayList<String>();
        for (var c : map.get(digits.charAt(0)))
            for (var suffix : suffixes)
                list.add(c + suffix);
        return list;
    }
}
