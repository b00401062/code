package leetcode;

class Change {
    public static int change(int amount, int[] coins) {
        var cache = new int[amount + 1];
        cache[0] = 1;
        for (var coin : coins) {
            for (var i = coin; i <= amount; i++) {
                cache[i] += cache[i - coin];
            }
        }
        return cache[amount];
    }
}
