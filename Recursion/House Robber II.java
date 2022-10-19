/*************
Leet Code : 213. House Robber II
Link :https://leetcode.com/problems/house-robber-ii/
Problem Statement :
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
Example 1:
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:
Input: nums = [1,2,3]
Output: 3
 
Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 1000
*************/
class Solution {
    public int rob(int[] nums) {
       int n = nums.length;
        if(n==0 || nums == null){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        return Math.max(rob(nums,0,n-1),rob(nums,1,n));
        
  }
  public static int rob(int arr[],int start, int end){
     int prev2=0,prev1=0;
      for(int i=start;i<end;i++){
          int temp= Math.max(arr[i]+prev2,prev1);
          prev2=prev1;
          prev1=temp;
      }
      return prev1;
  }
}

/************
Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber II.
Memory Usage: 42.3 MB, less than 5.27% of Java online submissions for House Robber II.
************/
