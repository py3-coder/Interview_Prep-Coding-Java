/*
Link :https://practice.geeksforgeeks.org/contest/job-a-thon-13-hiring-challenge/problems/#
*/
class Solution{
    
    public int minCapacity(int a[], int n){
        // Code your solution here. 
        int ans= 0;
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            ans = Math.max(ans, a[i]-i);
        }
        return ans;
    }
}
