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
    int idx = 0; // to keept track

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int min, int max){
        if(idx == preorder.length) return null;  // all processed

        if(preorder[idx] < min || preorder[idx] > max) return null;  //val dsn't belong here

        TreeNode root = new TreeNode(preorder[idx]);  // create root
        idx++;

        // create left, right subtree
        root.left = build(preorder, min, root.val);
        root.right = build(preorder, root.val, max);

        return root;
    }
}