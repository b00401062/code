package leetcode;

class IsValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        var col = new boolean[9][9];
        var row = new boolean[9][9];
        var box = new boolean[9][9];
        for (var i = 0; i < 9; i++) {
            for (var j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    var num = board[i][j] - '1';
                    var boxIndex = i / 3 * 3 + j / 3;
                    if (col[j][num] || row[i][num] || box[boxIndex][num])
                        return false;
                    col[j][num] = true;
                    row[i][num] = true;
                    box[boxIndex][num] = true;
                }
            }
        }
        return true;
    }
}
