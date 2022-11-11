package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class PermuteUnique {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0)
            return List.of();
        var list = new ArrayList<List<Integer>>();
        list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        var times = IntStream.rangeClosed(1, nums.length).reduce((x1, x2) -> x1 * x2).getAsInt();
        while (--times > 0) {
            NextPermutation.nextPermutation(nums);
            var candidate = Arrays.stream(nums).boxed().collect(Collectors.toList());
            if (list.get(0) == candidate) return list;
            list.add(candidate);
        }
        return list;
    }
}
