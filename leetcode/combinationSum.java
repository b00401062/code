package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LeetCode {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target == 0)
            return List.of(List.of());
        else if (candidates.length == 0)
            return List.of();
        var res = new ArrayList<List<Integer>>();
        for (var i = 0; i < candidates.length; i++) {
            var candidate = candidates[i];
            for (var n = 1; n <= target / candidate; n++) {
                for (var postfix : combinationSum(
                    Arrays.copyOfRange(candidates, i + 1, candidates.length),
                    target - candidate * n
                )) {
                    var prefix = Stream.generate(() -> candidate).limit(n).collect(Collectors.toList());
                    prefix.addAll(postfix);
                    res.add(prefix);
                }
            }
        }
        return res;
    }
}
