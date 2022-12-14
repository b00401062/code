package leetcode;

class HasPathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        else if (root.left == null && root.right == null) return targetSum == root.val;
        else return (
            hasPathSum(root.left, targetSum - root.val) ||
            hasPathSum(root.right, targetSum - root.val)
        );
    }
}
