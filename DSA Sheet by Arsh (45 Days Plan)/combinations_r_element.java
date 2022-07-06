/*
Print all possible combinations of r elements in a given array of size n
Difficulty Level : Hard
Last Updated : 19 Jan, 2022
Given an array of size n, generate and print all possible combinations of r elements in array.
For example, if input array is {1, 2, 3, 4} and r is 2, then output should be {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}.
*/
/*
Code:
*/
import java.util.*;
public class Main
{
    public static void Combination_print(int arr[] ,int data[], int start,int end , int index , int r){
        if(index == r){
            for(int m=0;m<r;m++)
                System.out.print(data[m]+" ");
            System.out.println("");
            return;
        }
        for(int i =start ;i<=end && end-i+1>=r-index;i++){
            data[index] =arr[i];
            Combination_print(arr,data,i+1,end,index+1,r);
        }
    }
    public static void printComb(int arr[],int n,int r){
        int data[] = new int[r];
        Combination_print(arr,data,0,n-1,0,r);
    }
	public static void main(String[] args) {
	    int arr[] = {1,2,3,4,5,6};
	    int r =4;
	    printComb(arr,arr.length,r);
	}
}
