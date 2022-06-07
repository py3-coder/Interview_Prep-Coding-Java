/*************************
Link  : https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
Move all negative numbers to beginning and positive to end with constant extra space

Difficulty Level : Easy
Last Updated : 03 Jun, 2022
An array contains both positive and negative numbers in random order. Rearrange the array elements so that all negative numbers appear before all positive numbers.

Examples : 

Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
Output: -12 -13 -5 -7 -3 -6 11 6 5

Note: Order of elements is not important here.
*************************/
public class Main
{
	public static void main(String[] args) {
	    int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        int n = arr.length;
 
        arrrange_sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
	}
	public static void arrrange_sort(int arr[]){
	    int j=0,temp=0;
	    for(int i =0;i<arr.length;i++){
	        if(arr[i]<0){
	            if(i != j){
	                temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] =temp;
	            }
	            j++;
	        }
	    }
	}
}
