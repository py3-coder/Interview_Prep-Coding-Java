/*
Count of Subsets with given Difference
Difficulty Level : Hard

Given an array arr[] of size N and a given difference diff, the task is to count the number of partitions that 
we can perform such that the difference between the sum of the two subsets is equal to the given difference.

Note: A partition in the array means dividing an array into two parts say S1 and S2 such that the union of S1 and S2 is equal to the
original array and each element is present in only of the subsets.

Examples:

Input: N = 4, arr[] = [5, 2, 6, 4], diff = 3
Output: 1
Explanation: We can only have a single partition which is shown below:
{5, 2} and {6, 4} such that S1 = 7 and S2 = 10 and thus the difference is 3

Input: N = 5, arr[] = [1, 2, 3, 1, 2], diff = 1
Output: 5
Explanation: We can have five partitions which is shown below
{1, 3, 1} and {2, 2} – S1 = 5, S2 = 4
{1, 2, 2} and {1, 3} – S1 = 5, S2 = 4
{3, 2} and {1, 1, 2} – S1 = 5, S2 = 4
{1, 2, 2} and {1, 3} – S1 = 5, S2 = 4
{3, 2} and {1, 1, 2} – S1 = 5, S2 = 4
*/
//CODE :

import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    int arr[] ={ 1, 2, 3, 1, 2 };
	    int diff =1;
	    int n= arr.length;
	    int count =count_subset_diff(arr,n,diff);
		System.out.println(count);
	}
	// DP Problem : Count of subset sum with given difference
	public static int count_subset_diff(int arr[] ,int n,int diff){
	    int sum =0;
	    for(int i=0;i<n;i++){
	        sum +=arr[i];
	    }
	    int target = (sum+diff)/2;
	    //return count_subset_count(arr,n-1,target);
	    //int dp[][] = new int[n+1][target+1];
	    //Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
	    //return count_subset_count_Memo(arr,n-1,target,dp);
	    return count_subset_count_tab(arr,target);
	}
	//Recursive Approch
	public static int count_subset_count(int arr[],int n,int target){
	    if(target==0) return 1;
	    if(n<0) return 0;
	    
	    if(arr[n]>target){
	        return count_subset_count(arr,n-1,target);
	    }else{
	        return count_subset_count(arr,n-1,target) + count_subset_count(arr,n-1,target-arr[n]);
	    }
	}
	//Memoization
	public static int count_subset_count_Memo(int arr[],int n,int target,int dp[][]){
	    if(target==0) return 1;
	    if(n<0) return 0;
	    if(dp[n][target]!=-1) return dp[n][target];
	    if(arr[n]>target){
	        dp[n][target]=count_subset_count_Memo(arr,n-1,target,dp);
	    }else{
	        dp[n][target]=count_subset_count_Memo(arr,n-1,target,dp)+count_subset_count_Memo(arr,n-1,target-arr[n],dp);
	    }
	    return dp[n][target];
	}
	// Tabulation
	public static int count_subset_count_tab(int[] arr,int target){
	    int dp[][] =new int[arr.length+1][target+1];
	    for(int i=0;i<arr.length+1;i++){
	        dp[i][0] =1;
	    }
	    for(int i=1;i<arr.length+1;i++){
	        for(int j=1;j<target+1;j++){
	            if(arr[i-1]>j){
	                dp[i][j] =dp[i-1][j];
	            }else{
	                dp[i][j] =dp[i-1][j] +dp[i-1][j-arr[i-1]];
	            }
	        }
	    }
	    return dp[arr.length][target];
	}
}
