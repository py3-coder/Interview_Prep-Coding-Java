/*
Print All SubArray of array:
Simple Test case :
arr =[1,2,3,4,5]
O/P = [[1], [1, 2], [1, 2, 3], [1, 2, 3, 4], [1, 2, 3, 4, 5], [2], [2, 3], [2, 3, 4], [2, 3, 4, 5], [3], [3, 4], [3, 4, 5], [4], [4, 5], [5]]
*/

import java.util.*;
public class Main
{
    static void printSubArrays(int[] arr,ArrayList<Integer> res, ArrayList<ArrayList<Integer>> ans)
    {
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                for(int k=i;k<=j;k++){
                    res.add(arr[k]);
                }
                ans.add(new ArrayList<Integer>(res));
                res.clear();
            }
        }
    }
 
    public static void main(String args[])
    {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] arr = {1,2,3,4,5};
        printSubArrays(arr,res,ans);
        System.out.println(ans);
    }
}
