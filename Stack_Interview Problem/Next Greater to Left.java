//Problem Statement : Nearest Greater to Left::
//IP :: 1,3,2,4
//OP :: -1,-1,3,-1
//Lets Play with Stack::

import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    int arr[] = new int[]{5,3,2,4,3,6,8,2};
	    int res[] =nextGreaterLeft(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(res[i]+" ");
        }
	}
	public static int[] nextGreaterLeft(int[] arr){
	    Stack<Integer> st = new Stack<>();
	    int res[] = new int[arr.length];
	    
	    for(int i=0;i<arr.length;i++){
	        if(st.isEmpty()){
	            res[i]=-1;
	        }else if(st.peek()>arr[i]){
	            res[i]=st.peek();
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
