package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class FindMedianSortedArrays {
    private static double select(List<Integer> l1, List<Integer> l2, int k) {
        if (l1.size() == 0) return l2.get(k);
        if (l2.size() == 0) return l1.get(k);
        var pivot = l1.get(l1.size() / 2);
        var index = Collections.binarySearch(l2, pivot);
        var lt1 = l1.size() / 2;
        var lt2 = index >= 0 ? index : -index - 1;
        var lt = lt1 + lt2;
        if (k == lt) return pivot;
        else if (k < lt) return select(l1.subList(0, lt1), l2.subList(0, lt2), k);
        else return select(l1.subList(lt1 + 1, l1.size()), l2.subList(lt2, l2.size()), k - lt - 1);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var l1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        var l2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        var len = nums1.length + nums2.length;
        return len % 2 == 0 ? (select(l1, l2, len / 2 - 1) + select(l1, l2, len / 2)) / 2 : select(l1, l2, len / 2);
    }
}
