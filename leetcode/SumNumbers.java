package leetcode;

fun traverse(node: TreeNode?, root_sum: Int): Int {
    if (node == null) {
        return 0
    }
    var curr_sum = root_sum * 10 + node.`val`
    if (node.left == null && node.right == null) {
        return curr_sum
    }
    var left_sum = traverse(node.left, curr_sum)
    var right_sum = traverse(node.right, curr_sum)
    return left_sum + right_sum
}

fun sumNumbers(root: TreeNode?): Int {
    return traverse(root, 0)
}
