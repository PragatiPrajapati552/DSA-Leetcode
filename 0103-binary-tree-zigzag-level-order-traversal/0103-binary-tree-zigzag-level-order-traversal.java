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
    List<List<Integer>> list = new ArrayList<>();
    public void level(TreeNode root, int k){
        List<Integer> l = new ArrayList<>();
        if(root == null)
        return;

        if(list.size() == k)
        list.add(new ArrayList<>());
        
        if(k%2 == 0){
            list.get(k).add(root.val); // right to left

        }
        else{
            list.get(k).add(0, root.val); //left to right
        }
        level(root.left, k+1);
        level(root.right, k+1);
        
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        level(root, 0);
        return list;
    }
}