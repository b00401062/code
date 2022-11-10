package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

class NthUglyNumber {
    private static class UglyNumber implements Iterable<Integer> {
        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                private final List<Integer> cache = new ArrayList<Integer>(List.of(1));

                private boolean isUgly(int i) {
                    var last = cache.get(cache.size() - 1);
                    while (i > last) {
                        if (i % 5 == 0) i /= 5;
                        else if (i % 3 == 0) i /= 3;
                        else if (i % 2 == 0) i /= 2;
                        else return false;
                    }
                    return Collections.binarySearch(cache, i) >= 0;
                }

                @Override
                public boolean hasNext() {
                    return true;
                }

                @Override
                public Integer next() {
                    var last = cache.get(cache.size() - 1);
                    for (var i = last + 1; ; i++) {
                        if (isUgly(i)) {
                            cache.add(i);
                            return last;
                        }
                    }
                }
            };
        }
    }

    public static int nthUglyNumber(int n) {
        return StreamSupport.stream(new UglyNumber().spliterator(), false).skip(n - 1).findFirst().get();
    }
}
