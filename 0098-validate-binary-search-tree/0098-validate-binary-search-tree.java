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
    public Integer prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inOrder(root);
        
    }
    public boolean inOrder(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        if(!inOrder(root.left))
        {
            return false;
        }
        if(prev != null && root.val <= prev)
        {
            return false;
        }
        prev = root.val;
        return inOrder(root.right);

    }

}