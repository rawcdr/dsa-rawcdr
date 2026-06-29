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
    int preIndex = 0;   // Current root in preorder
    HashMap<Integer, Integer> map = new HashMap<>();   // inorder value -> index

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store inorder positions for O(1) lookup
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        // No nodes left in this subtree
        if (left > right)
            return null;

        // First preorder element is the root
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;

        // Split inorder into left & right subtree
        int inIndex = map.get(root.val);

        // Build left subtree first (Preorder = Root -> Left -> Right)
        root.left = build(preorder, left, inIndex - 1);

        // Build right subtree
        root.right = build(preorder, inIndex + 1, right);

        return root;
    }
}