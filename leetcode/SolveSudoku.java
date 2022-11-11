package leetcode;

import java.util.stream.IntStream;

class SolveSudoku {
    private static boolean solve(
        char[][] board,
        boolean[][] col,
        boolean[][] row,
        boolean[][] box,
        int n
    ) {
        var i = n / 9;
        var j = n % 9;
        if (n == 81)
            return true;
        if (board[i][j] != '.')
            return solve(board, col, row, box, n + 1);
        var boxIndex = i / 3 * 3 + j / 3;
        var candidates = IntStream.range(0, 9)
            .filter((it) -> !(col[j][it] || row[i][it] || box[boxIndex][it]))
            .toArray();
        for (var candidate : candidates) {
            board[i][j] = (char) ('1' + candidate);
            col[j][candidate] = true;
            row[i][candidate] = true;
            box[boxIndex][candidate] = true;
            if (solve(board, col, row, box, n + 1))
                return true;
            board[i][j] = '.';
            col[j][candidate] = false;
            row[i][candidate] = false;
            box[boxIndex][candidate] = false;
        }
        return false;
    }

    public static void solveSudoku(char[][] board) {
        var col = new boolean[9][9];
        var row = new boolean[9][9];
        var box = new boolean[9][9];
        for (var i = 0; i < 9; i++) {
            for (var j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    var num = board[i][j] - '1';
                    var boxIndex = i / 3 * 3 + j / 3;
                    col[j][num] = true;
                    row[i][num] = true;
                    box[boxIndex][num] = true;
                }
            }
        }
        solve(board, col, row, box, 0);
    }
}
