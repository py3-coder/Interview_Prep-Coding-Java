//Recursion Revison :)
// Reverse Array :-
import java.util.*;

public class Main
{
	public static void main(String[] args) {
		//System.out.println("Hello World");
		int[] arr = new int[]{3,4,7,8,2};
		reverseArr(0,arr);
		
		for(int ele : arr){
		   System.out.print(ele+" "); 
		}
		
	}
	
	public static void reverseArr(int indx ,int[] arr){
	    //Base Case::
	    if(indx==arr.length){
	        return;
	    }
	    int ele = arr[indx];
	    //Hypothese
	    reverseArr(indx+1,arr);
	    insert(ele,indx,arr);
	}
	
	public static void insert(int ele,int indx,int[] arr){
	    if(indx<0){
	        return;
	    }
	    arr[arr.length-(indx+1)] = ele;
	    return ;
	    
	}
}
