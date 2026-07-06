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
    public List<Integer> inorderTraversal(TreeNode root) {
        // Pointer & Stack approach

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !st.isEmpty()){
            // walk to leftmost
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            // process the node
            curr = st.pop();
            res.add(curr.val);
            // check right and move
            curr = curr.right;
        }
        
        return res;
    }
}