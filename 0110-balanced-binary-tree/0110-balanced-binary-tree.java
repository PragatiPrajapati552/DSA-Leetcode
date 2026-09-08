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
    public int dist(TreeNode root){
        if(root == null)
        return 0;

        int left = dist(root.left);
        int right = dist(root.right);

        return Math.max(left, right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
        return true;

        int left = dist(root.left);
        int right = dist(root.right);
        if(Math.abs(left - right) > 1)
        return false;
       
        boolean lf = isBalanced(root.left);
        boolean rg = isBalanced(root.right);
        
        if(lf && rg)
        return true;
        else 
        return false;
    }
}