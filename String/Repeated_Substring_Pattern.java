/* 459. Repeated Substring Pattern
Given a non-empty string check if it can be constructed by taking a substring of it and 
appending multiple copies of the substring together. You may assume the given string consists 
of lowercase English letters only and its length will not exceed 10000.

 

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

*/
//这道题的本质就是从0开始到Length/2试， 不要被substring迷惑
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        if(l < 1) {
            return true;
        }
        
        for(int i = l / 2; i >= 1; i--) {
            if(l % i == 0) {
                int repeatTime = l / i;
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < repeatTime; j++) {
                    sb.append(s.substring(0, i));
                }
            
                if(sb.toString().equals(s)) {
                    return true;
                } 
            }
        }
        
        return false;
        
    }
}