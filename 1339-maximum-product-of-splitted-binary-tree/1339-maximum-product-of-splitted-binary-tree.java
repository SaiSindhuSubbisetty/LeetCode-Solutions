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
    int mod=(int)1e9+7;
    long max=0;
    public int maxProduct(TreeNode root) {
        int totalsum=sum(root);
        dfs(root,totalsum);
        return (int)(max%mod);
    }
    public int sum(TreeNode root){
        if(root==null)return 0;
        return root.val+sum(root.left)+sum(root.right);
    }
    public long dfs(TreeNode root,int totalsum){
        if(root==null)return 0;
        long cur=dfs(root.left,totalsum)+dfs(root.right,totalsum)+root.val;
        max=Math.max(cur*(totalsum-cur),max);
        return cur;
    }
}