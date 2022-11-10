package leetcode

private fun putNQueens(
    N: Int,
    n: Int,
    cols: BooleanArray,
    dia1: BooleanArray,
    dia2: BooleanArray,
    sol: MutableList<Int>,
    sols: MutableList<List<String>>
) {
    if (n == N) {
        sols.add(sol.map {
            var row = CharArray(n) { '.' }
            row[it] = 'Q'
            row.joinToString("")
        })
        return
    }
    for (i in 0 until N) {
        if (cols[i] || dia1[n + i] || dia2[N + n - i - 1]) continue
        cols[i] = true
        dia1[n + i] = true
        dia2[N + n - i - 1] = true
        sol.add(i)
        putNQueens(N, n + 1, cols, dia1, dia2, sol, sols)
        cols[i] = false
        dia1[n + i] = false
        dia2[N + n - i - 1] = false
        sol.removeAt(n)
    }
}

fun totalNQueens(n: Int): Int {
    if (n < 1) {
        return 0
    }
    var cols = BooleanArray(n) { false }
    var dia1 = BooleanArray(2 * n - 1) { false }
    var dia2 = BooleanArray(2 * n - 1) { false }
    var sol: MutableList<Int> = mutableListOf()
    var sols: MutableList<List<String>> = mutableListOf()
    putNQueens(n, 0, cols, dia1, dia2, sol, sols)
    return sols.size
}
