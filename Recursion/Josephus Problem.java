/*
Find the Safe Position

There are n people standing in a circle (numbered clockwise 1 to n) waiting to be executed.
The counting begins at point 1 in the circle and proceeds around the circle in a fixed direction (clockwise).
In each step, a certain number of people are skipped and the next person is executed. 
The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), 
until only the last person remains, who is given freedom.

Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle.
The task is to choose the place in the initial circle so that you are the last one remaining and so survive.

Example 1:

Input:
n = 2, k = 1
Output:
2
Explanation:
Here, n = 2 and k = 1, then safe position is
2 as the person at 1st position will be killed.
Example 2:

Input:
n = 4, k = 2
Output:
1
Explanation:
The safe position is 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function safePos() which takes an Integer n as input and returns the safe position.

Expected Time Complexity: O(n*n)
Expected Auxiliary Space: O(n)

Follow up: This problem can be solved in linear time. Can you come up with a solution?

Constraints:
1 <= n,k <= 500
*/

//CODE :
class Solution {
    static int safePos(int n, int k) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<=n;i++){
            arr.add(i);
        }
        k =k-1;
        int idx =0;
        int res= Solve(arr,k,idx);
        return res;
    }
    static int Solve(ArrayList<Integer> arr,int k,int idx){
        if(arr.size()==1) return arr.get(0);
        idx = (idx+k)%arr.size();
        arr.remove(idx);
        return Solve(arr,k,idx);
        
    }
};
/*
Test Case : 2095 / 2095
Runtime : --
*/
