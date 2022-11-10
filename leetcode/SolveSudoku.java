package leetcode

private fun solve(
    board: Array<CharArray>,
    col: Array<BooleanArray>,
    row: Array<BooleanArray>,
    box: Array<BooleanArray>,
    n: Int
): Boolean {
    var i = n / 9
    var j = n % 9
    if (n == 81)
        return true
    if (board[i][j] != '.')
        return solve(board, col, row, box, n + 1)
    var boxIndex = i / 3 * 3 + j / 3
    var candidates = (0..8).filter { !(col[j][it] || row[i][it] || box[boxIndex][it]) }
    for (candidate in candidates) {
        board[i][j] = '1' + candidate
        col[j][candidate] = true
        row[i][candidate] = true
        box[boxIndex][candidate] = true
        if (solve(board, col, row, box, n + 1))
            return true
        board[i][j] = '.'
        col[j][candidate] = false
        row[i][candidate] = false
        box[boxIndex][candidate] = false
    }
    return false
}

fun solveSudoku(board: Array<CharArray>): Unit {
    var col = Array(9) { BooleanArray(9) }
    var row = Array(9) { BooleanArray(9) }
    var box = Array(9) { BooleanArray(9) }
    for (var i = 0; i < 9; i++) {
        for (var j = 0; j < 9; j++) {
            if (board[i][j] != '.') {
                var num = board[i][j] - '1'
                var boxIndex = i / 3 * 3 + j / 3
                col[j][num] = true
                row[i][num] = true
                box[boxIndex][num] = true
            }
        }
    }
    solve(board, col, row, box, 0)
}
