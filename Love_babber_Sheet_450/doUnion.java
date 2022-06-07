/***************
Union of two arrays 
Basic Accuracy: 52.81% Submissions: 100k+ Points: 1
Given two arrays a[] and b[] of size n and m respectively. The task is to find union between these two arrays.

Union of the two arrays can be defined as the set containing distinct elements from both the arrays. If there are repetitions, then only one occurrence of element should be printed in the union.

Example 1:

Input:
5 3
1 2 3 4 5
1 2 3
Output: 
5
Explanation: 
1, 2, 3, 4 and 5 are the
elements which comes in the union set
of both arrays. So count is 5.
Example 2:

Input:
6 2 
85 25 1 32 54 6
85 2 
Output: 
7
Explanation: 
85, 25, 1, 32, 54, 6, and
2 are the elements which comes in the
union set of both arrays. So count is 7.
Your Task:
Complete doUnion funciton that takes a, n, b, m as parameters and returns the count of union elements of the two arrays. The printing is done by the driver code.

Constraints:
1 ≤ n, m ≤ 105
0 ≤ a[i], b[i] < 105

Expected Time Complexity : O((n+m)log(n+m))
Expected Auxilliary Space : O(n+m)
****************/

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //Taking input using class Scanner
		Scanner sc=new Scanner(System.in);
		
		//Taking total count of testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    
		    int n,m;
		    
		    //taking size of array a
		    n=sc.nextInt();
		    
		    //taking size of array b
		    m=sc.nextInt();
		    
		    //Creating 2 array of size n and m
		    int a[]=new int[n];
		    int b[]=new int[m];
		    
		    //inserting elements to array a
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    
		    //inserting elements to array b
		    for(int i=0;i<m;i++)
		    {
		        b[i]=sc.nextInt();
		    }
		    Solution ob=new Solution();
		    //calling doUnion method and printing the results
		    System.out.println(ob.doUnion(a,n,b,m));
		}
		
	}
}// } Driver Code Ends


//User function Template for Java


class Solution{
    public static int doUnion(int a[], int n, int b[], int m) 
    {
        //Your code here
        Set<Integer> set = new HashSet<Integer>();
        for(int i : a){
            set.add(i);
        }
        for(int j : b){
            set.add(j);
        }
        int result = set.size();
        return result;
    }
}
