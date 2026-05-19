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
import java.util.*;
class Solution {
    int preOrderIndex;
    Map<Integer,Integer> inOrderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder){
        preOrderIndex = 0;
        inOrderMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            inOrderMap.put(inorder[i],i);
        }
        return constructTree(preorder,0,preorder.length-1);
    }
    public TreeNode constructTree(int[] preorder,int left,int right)
    {
        if(left>right)
        {
            return null;
        }
        int rootValue = preorder[preOrderIndex];
        preOrderIndex++;
        TreeNode root = new TreeNode(rootValue);
        root.left = constructTree(preorder,left,inOrderMap.get(rootValue)-1);
        root.right = constructTree(preorder,inOrderMap.get(rootValue)+1,right);
        return root;
    }
}

