/*
95. Unique Binary Search Trees II
Medium

Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

Example 1:
Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 8
Accepted
330,573
Submissions
644,998
*/
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return solve(1,n);
    }
    public List<TreeNode> solve(int start , int end){
        List<TreeNode> ans= new ArrayList<>();
        if(start>end){
            ans.add(null);
            return ans;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> left = solve(start,i-1);
            List<TreeNode> right = solve(i+1,end);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root =new TreeNode(i);
                    root.left = l;
                    root.right= r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
