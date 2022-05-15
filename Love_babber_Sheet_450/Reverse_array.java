/*
Reverse array :01

*/

import java.util.*;
import java.lang.*;
public class Main
{
    public static void Reverse_arr(int arr[]){
        int l=arr.length;
        int start = 0;
        int end=l-1;
        int temp=0;
        for(start =0,end=l-1;start !=end;start++,end--){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        for (int i=0;i<l;i++){
            System.out.print(arr[i]+" ");
        }
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int [] arr = new int[5];
	    for(int i=0;i<5;i++){
	        arr[i] = sc.nextInt();
	    }
	    Reverse_arr(arr);
	}
}
