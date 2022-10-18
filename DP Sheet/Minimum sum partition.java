/*
LINK : https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
DP : PROBLEM
Minimum sum partition
Given an array arr of size N containing non-negative integers, the task is to divide it into two sets S1 and S2 such that the 
absolute difference between their sums is minimum and find the minimum difference


Example 1:

Input: N = 4, arr[] = {1, 6, 11, 5} 
Output: 1
Explanation: 
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11   
Example 2:
Input: N = 2, arr[] = {1, 4}
Output: 3
Explanation: 
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {4}, sum of Subset2 = 4

Your Task:  
You don't need to read input or print anything. Complete the function minDifference() which takes N and array arr as input parameters and returns the integer value


Expected Time Complexity: O(N*|sum of array elements|)
Expected Auxiliary Space: O(N*|sum of array elements|)


Constraints:
1 ≤ N*|sum of array elements| ≤ 106

The array contains non-negative integers.
*/

import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    int arr[] ={1,2,7};
	    int n =arr.length;
	    int res =minDifference(arr,n);
	    System.out.println();
		System.out.println(res);
	}
	public static int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum=0;
	    for(int i=0;i<n;i++){
	        sum +=arr[i];
	    }
	    List<Integer> res = new ArrayList<>();
	    subsetsum_tab(arr,sum/2+1,n,res);
	    
	    int mini =Integer.MAX_VALUE;
	    for(int ele :res){
	        mini =Math.min(mini,sum-(2*ele));
	    }
	    return mini;
	    
	} 
	public static void subsetsum_tab(int[] arr,int sum,int n,List<Integer> res){
        boolean dp[][] = new boolean[arr.length+1][sum+1];
        for(int i=0;i<n+1;i++){
            dp[i][0] =true;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]>j){
                    dp[i][j]= dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        for(int i=0;i<sum;i++){
            if(dp[n][i]==true){
                res.add(i);
                //System.out.print(i);
            }
        }
    }
}
