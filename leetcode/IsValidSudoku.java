package leetcode;

class IsValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        var col = new boolean[9][9];
        var row = new boolean[9][9];
        var box = new boolean[9][9];
        for (i in 0 until 9) {
            for (j in 0 until 9) {
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
