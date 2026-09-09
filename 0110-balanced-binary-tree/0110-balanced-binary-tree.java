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
    private int checkHeight(TreeNode root){
        if(root == null) return 0;

        int left = checkHeight(root.left);
        if(left == -1) return -1;

        int right = checkHeight(root.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) == -1 ? false : true;
    }
}