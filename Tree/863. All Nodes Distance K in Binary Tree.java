/*
863. All Nodes Distance K in Binary Tree
Medium

Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

 
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

Example 2:
Input: root = [1], target = 1, k = 3
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000
*/
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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        Set<TreeNode> vis = new HashSet<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode curr = que.poll();
            if(curr == target) break;
            if(curr.left!=null){
                map.put(curr.left,curr);
                que.add(curr.left);
            }
            if(curr.right!=null){
                map.put(curr.right,curr);
                que.add(curr.right);
            }
        }
        //System.out.println(map);
        que.clear();
        que.add(target);
        vis.add(target);
        while(k-->0){
            if(que.isEmpty()) return new ArrayList<>();
            for(int i=que.size();i>0;i--){
                TreeNode curr = que.poll();
                if(curr.left!=null && vis.add(curr.left))  que.add(curr.left);
                if(curr.right!=null && vis.add(curr.right))  que.add(curr.right);
                if(map.get(curr)!=null && vis.add(map.get(curr))) que.add(map.get(curr));   
            }
        } 
        while(!que.isEmpty()){
            res.add(que.poll().val);
        }
        return res;
    }
}
