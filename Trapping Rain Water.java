/************************
Leet Code Problem :42. Trapping Rain Water
Link :https://leetcode.com/problems/trapping-rain-water/ 

Problem Statement :
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*************************//
class Solution {
    public int trap(int[] height) {
        int h= height.length;
        int left=0,right=h-1;
        int left_max=0,right_max=0,total_w=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=left_max){
                    left_max=height[left];
                }
                else{
                    total_w +=left_max-height[left];
                }
                left++;
            }
            else{
                if(height[right]>=right_max){
                    right_max=height[right];
                }
                else{
                    total_w +=right_max-height[right];
                }
                right--;  
            }
        }
        return total_w;
    }
}
/*****
Runtime: 1 ms, faster than 92.78% of Java online submissions for Trapping Rain Water.
Memory Usage: 47 MB, less than 16.96% of Java online submissions for Trapping Rain Water.
*****/
