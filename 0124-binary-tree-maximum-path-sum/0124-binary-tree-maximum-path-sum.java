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
    int max  = Integer.MIN_VALUE;
    public int maxx(TreeNode root){
        if(root == null)
        return 0;

        int left = Math.max(0,maxx(root.left));
        int right = Math.max(0,maxx(root.right)); //remove negative child
        
        int data = root.val;
        int sum = data + left + right;
        max =  Math.max(max, sum);
        return data + Math.max(left,right); // rootnode included 
    }
    public int maxPathSum(TreeNode root) {
        maxx(root);
        return max;
    }
}