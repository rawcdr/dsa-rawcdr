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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;  // base case

        // search node
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // node found, now check
            // 1. left, 1 child, 2 child
            if (root.left == null) return root.right;  // no left child
            if (root.right == null) return root.left;  // no right child

            // 2 child
            TreeNode min = findMin(root.right);  // to replace
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode node){
        // returns the leftmost(smallest val) node
        while(node.left != null) node = node.left;
        return node;
    }
}