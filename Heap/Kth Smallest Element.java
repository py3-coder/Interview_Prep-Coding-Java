// Heap Questions:::
//Problem Statement :: Kth Smallest Element in given array.
// IP : arr[] =7 10 4 3 20 15 ,k=3
// OP : 7

/*
Broute Force :: Array Sort:
TC : O(nlogn)
SC : O(1)

Optimal Approch:: Heap Method::
TC : O(nlogk)
SC : O(k)

*/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    int arr[] = new int[]{6,10,4,3,20,15,21,18,2};
	    int k=5;
	    int val =kthSmallestele(arr,k);
		System.out.println(k+"th Smallest ::"+val);
		 val =kthSmallestele(arr,7);
		System.out.println("7th Smallest ::"+val);
		 val =kthSmallestele(arr,3);
		System.out.println("3rd Smallest ::"+val);
		 val =kthSmallestele(arr,8);
		System.out.println("8th Smallest ::"+val);
		//Lets Check :: 2,3,4,6,10,15,18,20,21
	}
	public static int kthSmallestele(int[] arr,int k){
	    //Smallest given:: so we will make Max heap::
	    PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b)->b-a);
	    for(int i=0;i<arr.length;i++){
	        maxheap.add(arr[i]);
	        if(maxheap.size()>k){
	            maxheap.poll();
	        }
	    }
	    return maxheap.peek();
	}
}

/*
OutPut ::
5th Smallest ::10
7th Smallest ::18
3rd Smallest ::4
8th Smallest ::20
*/
