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
     static class Info{
        int vd;
        TreeNode node;
        Info(int vd, TreeNode node){
            this.vd = vd;
            this.node = node;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int max = 0;
        if(root == null)
        return list;
        q.add(new Info(0, root));
        while(!q.isEmpty()){
            Info curr = q.remove();
            // if(!map.containsKey(curr.hd))
            map.put(curr.vd, curr.node);

            if(curr.node.left != null){
                q.add(new Info(curr.vd+1, curr.node.left));
                max = Math.max(curr.vd +1 , max);
            }
            if(curr.node.right != null){
                q.add(new Info(curr.vd+1, curr.node.right));
                max = Math.max(curr.vd +1 , max);
            }
        }
        for(int i = 0;i<=max;i++){
            list.add(map.get(i).val);
        }
        return list;
    }
}
