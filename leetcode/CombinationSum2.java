package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

class CombinationSum2 {
    private static Map<Integer, Integer> table;

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target == 0)
            return List.of(List.of());
        else if (candidates.length == 0)
            return List.of();
        var res = new ArrayList<List<Integer>>();
        for (var i = 0; i < candidates.length; i++) {
            var candidate = candidates[i];
            if (target < candidate)
                break;
            else if (target == candidate) {
                res.add(List.of(candidate));
                break;
            } else for (var n = 1; n <= Math.min(target / candidate, table.get(candidate)); n++) {
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

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        table = new HashMap<>();
        for (var candidate : candidates) {
            table.put(candidate, table.getOrDefault(candidate, 0) + 1);
        }
        return combinationSum(table.keySet().stream().sorted().mapToInt(x -> x).toArray(), target);
    }
}
