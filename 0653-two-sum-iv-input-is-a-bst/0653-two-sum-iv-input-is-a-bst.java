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
class Solution {  // inorder + two pointer approach
    List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        inorder(root);

        int left = 0;
        int right = list.size() - 1;

        while(left < right){
            int sum = list.get(left) + list.get(right);

            if (sum == k) return true;
            if (sum < k) left++;
            else right--;
        }
        
        return false;
    }

    private void inorder(TreeNode root){
        if (root == null) return;

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}