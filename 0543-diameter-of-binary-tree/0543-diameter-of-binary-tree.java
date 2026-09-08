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
    public class info{
        int diam;
        int ht;
        info(int diam ,int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    public info diam(TreeNode root){
        if(root == null){
            return new info(0,0);
        }
        info left = diam(root.left);
        info right = diam(root.right);

        int ht = Math.max(left.ht, right.ht) + 1;
        int diam = Math.max(left.ht+right.ht+1, Math.max(left.diam,right.diam));
        return new info(diam,ht);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        info ans = diam(root);
        return ans.diam-1;
    }
}