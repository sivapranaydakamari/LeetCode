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
    private int diameter = 0;
    private int height(TreeNode root){
        if(root == null) return 0;

        int lheight = height(root.left);
        int rheight = height(root.right);
        diameter = Math.max(diameter, lheight + rheight);
        int height = 1 + Math.max(lheight, rheight);
        return height;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
}