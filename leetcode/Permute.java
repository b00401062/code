package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return List.of();
        var list = new ArrayList<List<Integer>>();
        list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        var times = IntStream.rangeClosed(1, nums.length).reduce((x1, x2) -> x1 * x2).getAsInt();
        while (--times > 0) {
            NextPermutation.nextPermutation(nums);
            list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        return list;
    }
}
