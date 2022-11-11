package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class SolveNQueens {
    private static void putNQueens(
        int N,
        int n,
        boolean[] cols,
        boolean[] dia1,
        boolean[] dia2,
        List<Integer> sol,
        List<List<String>> sols
    ) {
        if (n == N) {
            sols.add(sol.stream().map((it) -> {
                var row = new char[n];
                Arrays.fill(row, '.');
                row[it] = 'Q';
                return String.valueOf(row);
            }).collect(Collectors.toList()));
            return;
        }
        for (var i = 0; i < N; i++) {
            if (cols[i] || dia1[n + i] || dia2[N + n - i - 1])
                continue;
            cols[i] = true;
            dia1[n + i] = true;
            dia2[N + n - i - 1] = true;
            sol.add(i);
            putNQueens(N, n + 1, cols, dia1, dia2, sol, sols);
            cols[i] = false;
            dia1[n + i] = false;
            dia2[N + n - i - 1] = false;
            sol.remove(n);
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return List.of();
        }
        var cols = new boolean[n];
        var dia1 = new boolean[2 * n - 1];
        var dia2 = new boolean[2 * n - 1];
        var sol = new ArrayList<Integer>();
        var sols = new ArrayList<List<String>>();
        putNQueens(n, 0, cols, dia1, dia2, sol, sols);
        return sols;
    }
}
