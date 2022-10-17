/*
LINK :https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
Partition Equal Subset Sum

Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is the same.

Example 1:

Input: N = 4
arr = {1, 5, 11, 5}
Output: YES
Explanation: 
The two parts are {1, 5, 5} and {11}.
Example 2:

Input: N = 3
arr = {1, 3, 5}
Output: NO
Explanation: This array can never be 
partitioned into two such parts.

Your Task:
You do not need to read input or print anything. Your task is to complete the function equalPartition() which takes the value N and the array as input parameters and returns 1 if the partition is possible. Otherwise, returns 0.


Expected Time Complexity: O(N*sum of elements)
Expected Auxiliary Space: O(N*sum of elements)


Constraints:
1 ≤ N ≤ 100
1 ≤ arr[i] ≤ 1000
*/
class Solution{
    static int equalPartition(int n, int arr[])
    {
        // code here
        int sum =0;
        for(int i=0;i<n;i++){
            sum +=arr[i];
        }
        if(sum%2!=0){
            return 0;
        }else{
            sum =sum/2;
            Boolean dp[][] = new Boolean[n+1][sum+1];
            boolean res= subsetsum_Memo(arr, sum,n-1,dp);
            if(res==true) return 1;
            else return 0;
        }
    }
    public static boolean subsetsum_Memo(int[] arr,int sum,int n,Boolean dp[][]){
        if(sum==0) return true;
        if(n==0) return false;
        if(dp[n][sum]!=null){
            return dp[n][sum];
        }
        if(arr[n]>sum){
            return subsetsum_Memo(arr,sum,n-1,dp);
        }else{
            boolean pick = subsetsum_Memo(arr,sum-arr[n],n-1,dp);
            boolean not_pick =subsetsum_Memo(arr,sum,n-1,dp);
            
            dp[n][sum]=(pick||not_pick);
            return dp[n][sum];
        }
    }
}
