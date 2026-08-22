/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);

        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int lg = Math.max(0, dfs(node.left));
        int rg = Math.max(0, dfs(node.right));

        int curr = lg + node.val + rg;
        max = Math.max(max, curr);

        return node.val + Math.max(lg, rg);
    }
}