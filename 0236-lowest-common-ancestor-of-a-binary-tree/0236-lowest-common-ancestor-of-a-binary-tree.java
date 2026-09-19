/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean nodePath(TreeNode root, TreeNode n, List<TreeNode> path){
        if(root == null)
        return false;

        path.add(root);

        if(root.val == n.val)
        return true;
        

        boolean left = nodePath(root.left , n, path);
        boolean right = nodePath(root.right , n, path);

        if(left || right)
        return true;

        path.remove(path.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        nodePath(root,p,path1);
        nodePath(root,q,path2);
        int i=0;
        for(; i<path1.size() && i<path2.size();i++){
            if(path1.get(i) != path2.get(i))
            break;
        }
        return path1.get(i-1);

    }
}