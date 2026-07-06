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
    int maxx = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxx;
    }

    private int dfs(TreeNode node){
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        maxx = Math.max(maxx, left + right);

        return 1 + Math.max(left, right);
    }
}