/*
Link :https://practice.geeksforgeeks.org/problems/permutation-with-spaces3627/1
Permutation with Spaces

Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them. 
The output should be printed in sorted increasing order of strings
Example 1:

Input:
S = "ABC"
Output: (A B C)(A BC)(AB C)(ABC)
Explanation:
ABC
AB C
A BC
A B C
These are the possible combination of "ABC".
 

Example 2:

Input:
S = "AB"
Output: (A B)(AB)

Your Task:  
You don't need to read input or print anything. 
Your task is to complete the function permutation() which takes the string S as input parameters and returns the sorted array of the string denoting the different permutation (DON'T ADD '(' and ')' it will be handled by the driver code only).

Expected Time Complexity: O(2^n)
Expected Auxiliary Space: O(1)

 

CONSTRAINTS:
1 <= |S| < 10
S only contains lowercase and Uppercase English letters.
*/


class Solution{
    
    ArrayList<String> permutation(String S){
        // Code Here
        ArrayList<String> res = new ArrayList<>();
        if(S.length()==1){
            res.add(S);
            return res;
        }
        String Op=""+S.charAt(0);
        String Ip=S.substring(1);
        Solve(Ip,Op,res);
        Collections.reverse(res);
        return res;
    }
    static void Solve(String Ip, String Op,ArrayList<String> res){
        if(Ip.length()==0){
            res.add(Op);
            return;
        }
        String Op1 =Op;
        String Op2 =Op;
        
        Op1 +=Ip.charAt(0);
        Op2 +=" "+Ip.charAt(0);
        Ip = Ip.substring(1);
        
        Solve(Ip,Op1,res);
        Solve(Ip,Op2,res);
        
    }
    
}
