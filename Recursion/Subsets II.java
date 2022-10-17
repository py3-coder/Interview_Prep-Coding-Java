Link : https://leetcode.com/problems/subsets-ii/
90. Subsets II
Medium
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:
Input: nums = [0]
Output: [[],[0]]
Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        Solve(0,nums,ans,res);
        for(List<Integer> obj:res){
            set.add(obj);
        }
        res.removeAll(res);
        for(List<Integer> obj:set){
            res.add(obj);
        }
        return res;
    }
    public static void Solve(int i ,int nums[],ArrayList<Integer> ans ,List<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        //Pick
        ans.add(nums[i]);  // add elemnet
        Solve(i+1,nums,ans,res); // call for Pick
        ans.remove(ans.size()-1); // remove the last for not pick
        //Not pick 
        Solve(i+1,nums,ans,res); // call for not pick
    }
}
