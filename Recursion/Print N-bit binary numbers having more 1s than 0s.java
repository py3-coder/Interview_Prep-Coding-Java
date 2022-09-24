/*
GFG Link :https://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1
Print N-bit binary numbers having more 1s than 0s
MediumAccuracy: 68.05%Submissions: 8781Points: 4
Given a positive integer N, the task is to find all the N bit binary numbers having more than or equal 1’s than 0’s for any prefix of the number.

Example 1:

Input:  N = 2
Output: 11 10
Explanation: 11 and 10 have more than 
or equal 1's than 0's
Example 2:

Input:  N = 3
Output: 111 110 101
Explanation: 111, 110 and 101 have more 
than or equal 1's than 0's
User Task:
Your task is to complete the function NBitBinary() which takes a single number as input and returns the list of strings in decreasing order. You need not take any input or print anything.

Expected Time Complexity: O(|2N|)
Expected Auxiliary Space: O(2N)

Constraints:
1 <= N <= 20
*/
class Solution {
    ArrayList<String> NBitBinary(int N) {
        ArrayList<String> str = new ArrayList<>();
        String Op="";
        int Ones =0;
        int zeros =0;
        Solve(N,Ones,zeros,Op,str);
        return str;
    }
    public static void Solve(int n,int Ones, int zeros,String Op,ArrayList<String> str){
        // Base case :
        if(n==0){
            str.add(Op);
            return;
        }
        // Hypothesis:-
        // Induction :-
        if(Ones>zeros){
            String Op1 =Op;
            String Op2 =Op;
            
            Op1 +="1";
            Op2 +="0";
            
            /// First Call for 1 :
            Solve(n-1,Ones+1,zeros,Op1,str);
            /// Second Call for 0 :
            Solve(n-1,Ones,zeros+1,Op2,str);
        }
        if(Ones == zeros){
            Op+="1";
            // Call for only since condition numbers of 0s and 1s can be equal or 1s>Os;
            Solve(n-1,Ones+1,zeros,Op,str);
        }
    }
}
