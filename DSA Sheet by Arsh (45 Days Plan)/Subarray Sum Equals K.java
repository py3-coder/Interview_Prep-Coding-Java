/***********
974. Subarray Sums Divisible by K
Medium
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
A subarray is a contiguous part of an array.

Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
Example 2:

Input: nums = [5], k = 9
Output: 0
 

Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
2 <= k <= 104
***********/
/***
Sol1: Brute Force
Code :
***/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0,res=0;
        for(int i=0;i<nums.length;i++){
            sum=0;
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
                if(sum == k){
                    res +=1;
                }
            }
        }
        return res;
    }
}
/*Sol2:Optimized Hashmap use
Code:
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
         int sum=0,res=0,need=0;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            need = sum-k;
            if(map.containsKey(need)){
                res+=map.get(need);   
            }
            map.put(sum ,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
