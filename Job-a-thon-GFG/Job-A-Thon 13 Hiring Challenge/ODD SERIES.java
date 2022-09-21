/*
ODD SERIES

Input:
N = 6
Output: 14
Explanation: 
f(0) = 0, f(1) = 1, f(2) = 1, 
f(3) = 2, f(4) = 3, f(5) = 11 
f(6) = f(4) + f(5) = 3 + 11 = 14
Answer would be 14 % (109 + 7) that is 14.
Complete Question :
Problem 1 : https://practice.geeksforgeeks.org/contest/job-a-thon-13-hiring-challenge/problems/#
Code : Below 
*/
class Solution{
    public int findNth(int n){
        // Code your solution here.
        boolean flag = true;
        int dp[] = new int[100001];
        if(flag==true){
          return solve(n,dp);  
        }
        flag = false;
        return dp[n];
    }
    public int solve(int n,int[] dp){
        int mod = (int)1e9+7;
        dp[0] =0;
        dp[1] =1;
        for(int i=2;i<=100000;i++){
            if(i%5==0){
                dp[i] = 11;
            }else{
                int val = dp[i-1]+dp[i-2];
                dp[i] = val%mod;
                
            }
        }
        return dp[n];
    }
}
