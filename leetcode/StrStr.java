package leetcode;

private fun compile(needle: String): IntArray {
    var table = IntArray(needle.length)
    table[0] = -1
    var k = -1
    for (var i = 1; i < needle.length; i++) {
        while (k >= 0 && needle[k + 1] != needle[i])
            k = table[k]
        if (needle[k + 1] == needle[i])
            k++
        table[i] = k
    }
    return table
}

fun strStr(haystack: String, needle: String): Int {
    if (needle.isEmpty())
        return 0
    var table = compile(needle)
    var k = -1
    for (i in haystack.indices) {
        while (k >= 0 && needle[k + 1] != haystack[i])
            k = table[k]
        if (needle[k + 1] == haystack[i])
            k++
        if (k == needle.lastIndex)
            return i - k
    }
    return -1
}
