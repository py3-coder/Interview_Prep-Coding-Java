/*
784. Letter Case Permutation
Medium

Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create. Return the output in any order.


Example 1:
Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]

Example 2:
Input: s = "3z4"
Output: ["3z4","3Z4"]
 
Constraints:
1 <= s.length <= 12
s consists of lowercase English letters, uppercase English letters, and digits.
*/
//Code :
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans  = new ArrayList<String>();
        String Op ="";
        Solve(s,Op,ans);
        return ans;
        
    }
    public static void Solve(String Ip,String Op,List<String> ans){
        if(Ip.length()==0){
            ans.add(Op);
            return;
        }
        if(Character.isAlphabetic(Ip.charAt(0))){
            String Op1=Op;
            String Op2=Op;
            Op1 +=Character.toLowerCase(Ip.charAt(0));
            Op2 +=Character.toUpperCase(Ip.charAt(0));

            Ip =Ip.substring(1);

            Solve(Ip,Op1,ans);
            Solve(Ip,Op2,ans);
            
        }else{
            String Op1=Op;
            Op1+=Ip.charAt(0);
            Ip =Ip.substring(1);
            Solve(Ip,Op1,ans);
        }
        
    }
}
