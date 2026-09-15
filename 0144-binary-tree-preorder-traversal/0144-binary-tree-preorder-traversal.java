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
    // List<Integer> list = new ArrayList<>();
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     if(root == null)
    //     return list;

    //     list.add(root.val);
    //     preorderTraversal(root.left);
    //     preorderTraversal(root.right);

    //     return list;
    // }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null)
        return list; 

        s.push(root);

        while(!s.isEmpty()){
            TreeNode curr = s.pop();

            list.add(curr.val);

            if(curr.right != null){ //push right first as its LIFO
                s.push(curr.right);
            }
            if(curr.left != null){
                s.push(curr.left);
            }  
        }
        return list;
    }
    
}