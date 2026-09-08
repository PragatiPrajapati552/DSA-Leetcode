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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
        return list;

        q.add(root);
        q.add(null);
        List<Integer> l = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                if(q.isEmpty())
                break;
                else{
                q.add(null);
                list.add(l);
                // l.clear();
                l = new ArrayList<>();
                }
            }
            else{
            l.add(curr.val);
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
            }     
        }
        list.add(l);
        return list;
    }
}