/*******************
Leet Code : 
75. Sort Colors
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
 
Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.

Datch National Flag Algo
*******************/
/*********
Soln 1:
*********/
class Solution {
    public void sortColors(int[] a) {
        int low =0, mid=0,high=a.length-1,temp=0;
        while(mid<=high){
            switch (a[mid]){
                case 0:{
                    temp=a[mid];
                    a[mid]=a[low];
                    a[low] =temp;
                    mid++;
                    low++;
                    break;
                }
                case 1:{
                    mid++;
                    break;
                }
                case 2:{
                    temp= a[high];
                    a[high] =a[mid];
                    a[mid] = temp;
                    high--;
                    break;
                }
            }
        }
    }
}


/*********
Soln 2:
*********/
class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int Zero=0;
        int One=0;
        int Two=0;
        for(int i=0;i<len;i++){
            if(nums[i] == 0){
                Zero =Zero+1;
            }
            if(nums[i]==1){
                One =One+1;
            }
            if(nums[i] ==2){
                Two +=1;
            }
        }
        for(int i=0;i<Zero;i++){
            nums[i] = 0;
        }
        for(int i=Zero;i<Zero+One;i++){
            nums[i] = 1;
        }
        for(int i=Zero+One;i<Zero+One+Two;i++){
            nums[i] = 2;
        }
    }
}
