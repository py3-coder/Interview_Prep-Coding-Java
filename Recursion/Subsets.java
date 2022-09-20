/*
78. Subsets
Medium

Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 
Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> data= new ArrayList<>();
        Solve(0,nums,data,res);
        return res;
    }
    public static void Solve(int i,int[] nums,ArrayList<Integer> data,List<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList<Integer>(data));
            return;
        }
        data.add(nums[i]);
        Solve(i+1,nums,data,res);
        data.remove(data.size()-1);
        Solve(i+1,nums,data,res);
        
    }
}
