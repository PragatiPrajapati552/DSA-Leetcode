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
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     if(root == null)
    //     return list;

        
    //     inorderTraversal(root.left);
    //     list.add(root.val);
    //     inorderTraversal(root.right);

    //     return list;
    // }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null || !s.isEmpty()){

            while(curr != null){
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();
            list.add(curr.val);

            curr = curr.right;
        }
        return list;
    }

}