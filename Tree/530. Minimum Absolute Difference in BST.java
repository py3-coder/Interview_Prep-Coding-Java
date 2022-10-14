/*
Link : https://leetcode.com/problems/minimum-absolute-difference-in-bst/
530. Minimum Absolute Difference in BST
Easy

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1

Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 104].
0 <= Node.val <= 105
 

Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
*/
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
    public static List<Integer> res;
    public int getMinimumDifference(TreeNode root) {
        if(root==null)return 0;
        res = new ArrayList<>();
        inorder(root);
        int mini = Integer.MAX_VALUE;
        for(int i=1;i<res.size();i++){
            mini = Math.min(mini , res.get(i)-res.get(i-1));
        }
        return mini;
    }
    public void inorder(TreeNode root){
        if(root == null)  return ;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}
