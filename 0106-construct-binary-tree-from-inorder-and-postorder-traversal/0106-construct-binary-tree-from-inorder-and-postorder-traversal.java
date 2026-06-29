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

    int postIndex;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        // Store inorder positions
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right){

        // Empty subtree
        if(left > right)
            return null;

        // Last postorder element is root
        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;

        // Divide inorder
        int mid = map.get(root.val);

        // IMPORTANT: Build RIGHT first
        root.right = build(postorder, mid + 1, right);

        // Then LEFT
        root.left = build(postorder, left, mid - 1);

        return root;
    }
}