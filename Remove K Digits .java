/*****************
Leet code : 402. Remove K Digits
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
*****************/


class Solution {
    public String removeKdigits(String num, int k) {
     int len = num.length();
     if(len==k)
         return "0";
     Stack<Character> st = new Stack<>();
     for(int i=0;i<len;i++){
         while(k >0 && !st.isEmpty() && st.peek()>num.charAt(i)){
             st.pop();
             k--;
         }
         st.push(num.charAt(i));
     }
     while(k>0){
         st.pop();
         k--;
     }
        
    ////convert stack to string..
    StringBuilder sb = new StringBuilder();
    while(!st.isEmpty()){
        sb.append(st.pop());
    }
    while(sb.length() > 1 && sb.charAt(sb.length()-1) == '0'){
        sb.deleteCharAt(sb.length()-1);
    }
    return sb.reverse().toString();
}

}
/***********
Runtime: 15 ms, faster than 56.40% of Java online submissions for Remove K Digits.
Memory Usage: 45.8 MB, less than 22.97% of Java online submissions for Remove K Digits.
***********/
                        
