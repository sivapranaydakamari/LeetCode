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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return  new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> rightSideElements = new ArrayList<>();
        rightSideElements.add(root.val);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rightView = false;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.right != null){
                    queue.offer(node.right);
                    if(!rightView){
                        rightSideElements.add(node.right.val);
                        rightView = true;
                    }
                }
                if(node.left != null){
                    queue.offer(node.left);
                    if(!rightView){
                        rightSideElements.add(node.left.val);
                        rightView = true;
                    }
                }
            }
        }

        return rightSideElements;
    }
}