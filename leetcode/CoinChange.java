package leetcode;

import java.util.Arrays;

class LeetCode {
    public static int coinChange(int[] coins, int amount) {
        var cache = new int[amount + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;
        for (var coin : coins) {
            for (var i = coin; i <= amount; i++) {
                if (cache[i - coin] == Integer.MAX_VALUE) continue;
                cache[i] = Math.min(cache[i - coin] + 1, cache[i]);
            }
        }
        return cache[amount] == Integer.MAX_VALUE ? -1 : cache[amount];
    }
}
