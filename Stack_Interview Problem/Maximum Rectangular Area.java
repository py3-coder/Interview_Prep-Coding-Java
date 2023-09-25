//Problem Link ::https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long arr[], long n) 
    {
        // your code here
        //Lets Play with Stack::::
        int[] right=nsr(arr);
        int[] left =nsl(arr);
        
        //NSR , NSL ::
       
        long width=0;
        long maxi=0;
        for(int i=0;i<arr.length;i++){
            width =right[i]-left[i]-1;
            maxi =Math.max(width*arr[i],maxi);
        }
        return maxi;
    }
    public static int[] nsr(long[] arr){
        Stack<Integer> st = new Stack();
        int[] right=new int[arr.length];
         for(int i=arr.length-1;i>=0;i--){
            if(st.isEmpty()){
                right[i] =arr.length;
            }else if(arr[st.peek()]<arr[i]){
                right[i] =st.peek();
            }else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    right[i] =arr.length;
                }else{
                    right[i] =st.peek();
                }
            }
            st.push(i);
        }
        return right;
    }
    public static int[] nsl(long[] arr){
        int[] left = new int[arr.length];
        Stack<Integer> st = new Stack();
        for(int i=0;i<arr.length;i++){
            if(st.isEmpty()){
                left[i] =-1;
            }else if(arr[st.peek()]<arr[i]){
                left[i] =st.peek();
            }else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    left[i] =-1;
                }else{
                    left[i] =st.peek();
                }
            }
            st.push(i);
        }
        return left;
    }
        
}
