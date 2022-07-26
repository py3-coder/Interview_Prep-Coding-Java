
/*
300. Longest Increasing Subsequence
Medium

Given an integer array nums, return the length of the longest strictly increasing subsequence.
A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1
 
Constraints:
1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 
*/


class Solution {
    public int solveR(int idx,int prev_idx,int arr[],int n){
        if(idx == n){
            return 0;
        }
        int not_take = 0+solveR(idx+1,prev_idx,arr,n);
        int take=0;
        if(prev_idx == -1 || arr[idx]>arr[prev_idx])
          take = 1+solveR(idx+1,idx,arr,n);
        
        
        int LIS = Math.max(not_take,take);
        return LIS;
    }
    
    public int solveM(int idx,int prev_idx,int arr[],int n,int dp[][]){
        if(idx == n){
            return 0;
        }
        if(dp[idx][prev_idx+1] != -1){
            return dp[idx][prev_idx+1];
        }
        int not_take = 0+solveM(idx+1,prev_idx,arr,n,dp);
        int take=0;
        if(prev_idx == -1 || arr[idx]>arr[prev_idx])
          take = 1+solveM(idx+1,idx,arr,n,dp);
        
        
        dp[idx][prev_idx+1] = Math.max(not_take,take);
        return dp[idx][prev_idx+1];
    }
    public int solveTab(int[] nums){
        int dp[] = new int[nums.length];
        dp[0]=1;
        int omax =0;
        for(int i=1;i<dp.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i] =1+max;
        }
        for(int i=0;i<dp.length;i++){
            if(dp[i]>omax)
                omax=dp[i];
            }
        return omax;
        }
    
    public int lengthOfLIS(int[] nums) {
        //return solveR(0,-1,nums,nums.length);
        //int dp[][] = new int[nums.length][nums.length+1];
        //for(int i=0;i<nums.length;i++){
        //    for(int j=0;j<nums.length;j++){
        //        dp[i][j] =-1;
        //    }
        //}
        //return solveM(0,-1,nums,nums.length,dp);
        return solveTab(nums);
    }
}
