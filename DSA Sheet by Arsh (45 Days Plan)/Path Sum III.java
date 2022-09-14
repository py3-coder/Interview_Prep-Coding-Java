/*
437. Path Sum III
Medium

Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

Example 1:
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.

Example 2:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3

Constraints:
The number of nodes in the tree is in the range [0, 1000].
-109 <= Node.val <= 109
-1000 <= targetSum <= 1000
*/

/*
Approch  :
1. Brute Force 
2. Prefix Sum Approch
*/
//Code1:  TC - O(n^2) worst case   SC - O(1)  but   [0(n) -- Auxillary Recursion Stack]  Testcase : 128/128 
class Solution {
    public int path(TreeNode root, int Sum, long sum){
        if(root==null) return 0;
        sum +=root.val;
        int res =0;
        if(sum == Sum) res++;
        res +=path(root.left,Sum,sum);
        res +=path(root.right,Sum,sum);
        sum -=root.val;
        return res;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        return pathSum(root.left,targetSum)+path(root,targetSum,0)+pathSum(root.right,targetSum);
    }
}
//Code 2: TC - O(n)     SC - O(n)   TestCase - 128/128 
class Solution {
    int count=0;
    // to store sum and freq.
    HashMap<Integer,Integer> map = new HashMap<>();
    public void dfs(TreeNode root, int targetSum, int cumsum){
        if(root==null) return;
        cumsum +=root.val;
        if(cumsum==targetSum) count++;
        count +=map.getOrDefault(cumsum-targetSum,0);
        map.put(cumsum,map.getOrDefault(cumsum,0)+1);
        dfs(root.left,targetSum,cumsum);
        dfs(root.right,targetSum,cumsum);
        
        map.put(cumsum,map.get(cumsum)-1);
        
    }
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,0);
        return count;
    }
}


