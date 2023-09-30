// Heap Questions:::
//Problem Statement :: K largest Element in given array.
// IP : arr[] =7 10 4 3 20 15 ,k=3
// OP :  10,20,15

//TC : O(nlogk)
//SC : O(k)
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    int arr[] = new int[]{6,10,4,3,20,15,21,18,2};
	    int k=5;
	    kthSmallestele(arr,k);
		//Lets Check :: 2,3,4,6,10,15,18,20,21
	}
	public static void kthSmallestele(int[] arr,int k){
	    //Largest given:: so we will make min heap::
	    PriorityQueue<Integer> minheap =new PriorityQueue<>();
	    for(int i=0;i<arr.length;i++){
	        minheap.add(arr[i]);
	        if(minheap.size()>k){
	            minheap.poll();
	        }
	    }
	    while(!minheap.isEmpty()){
	        System.out.print(minheap.poll()+" ");
	    }
	}
}
/*
10 15 18 20 21 
*/
