package leetcode;

class SumNumbers {
    private static int traverse(TreeNode node, int rootSum) {
        if (node == null) {
            return 0;
        }
        var currSum = rootSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return currSum;
        }
        var ltSum = traverse(node.left, currSum);
        var rtSum = traverse(node.right, currSum);
        return ltSum + rtSum;
    }

    public static int sumNumbers(TreeNode root) {
        return traverse(root, 0);
    }
}
