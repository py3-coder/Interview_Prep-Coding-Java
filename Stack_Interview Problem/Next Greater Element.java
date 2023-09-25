//Problem  Statement : https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        //Lets play with Stack::
        //Brute Force :::
        long[] res = new long[n];
        int k=n-1;
        Stack<Long> st = new Stack();
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                res[i] =-1;
            }else if(st.peek()>arr[i]){
                res[i] =st.peek();
            }else{
                while(!st.isEmpty() && st.peek()<=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    res[i] =-1;
                }else{
                    res[i] =st.peek();
                }
            }
            st.push(arr[i]);
        }
        return res;
    } 
}
