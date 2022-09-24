/*
Interview Bits : https://www.interviewbit.com/problems/generate-all-parentheses-ii/
Generate all Parentheses II
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
Make sure the returned list of strings are sorted.
*/
public class Solution {
    public String[] generateParenthesis(int A) {
        int Open =A;
        int close=A;
        String Op="";
        List<String> res = new ArrayList<>();
        Solve(Open,close,Op,res);
        String str[] = new String[res.size()];
        int k=0;
        for(String st: res){
            str[k++] = st;
        }
        return str;
    }
    public static void Solve(int Open,int close,String Op,List<String> res){
        if(Open==0 && close==0){
            res.add(Op);
            return;
        }
        if(Open!=0){
            Solve(Open-1,close,Op+'(',res);
        }
        if(close>Open){
            Solve(Open,close-1,Op+')',res);
        }
    }
}
