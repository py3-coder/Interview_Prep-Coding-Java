// Heap Questions::: (VVIP) -- Flipkart Interview Problem
// Given an array of n elements, where each element is at most k away from its target position, 
// devise an algorithm that sorts in O(n log k) time.
// For example, let us consider k is 2, an element at index 7 in the sorted array,
// can be at indexes 5, 6, 7, 8, 9 in the given array.
// Example:
// Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
// k = 3 
// Output : arr[] = {2, 3, 5, 6, 8, 9, 10} . 


// TC : O(nlogk)
// SC : O(k)
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    int arr[] = new int[]{6,5,3,2,8,10,9};
	    int k=3;
	    int res[] =kSortedArray(arr,k);
	    for(int ele:res){
	        System.out.print(ele+" ");
	    }
		//Lets Check :: 2,3,5,6,8,9
	}
	public static int[] kSortedArray(int[] arr,int k){
	    //Largets given:: so we will make min heap::
	    int res[] =new int[arr.length];
	    int m=0;
	    PriorityQueue<Integer> minheap =new PriorityQueue<>();
	    for(int i=0;i<arr.length;i++){
	        minheap.add(arr[i]);
	        if(minheap.size()>k){
	            res[m++] =minheap.peek();
	            minheap.poll();
	        }
	    }
	    while(!minheap.isEmpty()){
	        res[m++] =minheap.poll();
	    }
	    return res;
	}
}
