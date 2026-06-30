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

// Main logic behind this is: prev.val > curr.val, BST Property breaks

class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        // find swapped nodes
        inorder(root);

        // swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;    
    }

    private void inorder(TreeNode root){
        if (root == null) return;

        inorder(root.left);

        // bst order breaks
        if(prev != null && prev.val > root.val) {
            if (first == null) first = prev;     // 1st wrong node
            second = root;                       // 2nd wrong node
        }

        prev = root;
        inorder(root.right);
    }
}