/* Longest Common Prefix

Given k strings, find the longest common prefix (LCP).
Example
For strings "ABCD", "ABEF" and "ACEF", the LCP is "A"
For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"
*/

/*
重要知识点 ： public String substring(int beginIndex, int endIndex)
Returns a new string that is a substring of this string. 
The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. 
Thus the length of the substring is endIndex - beginIndex.
Examples:
"hamburger".substring(4, 8) returns "urge"
"smiles".substring(1, 5) returns "mile"
*/

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if(strs == null || strs.length < 1) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            while(j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
            // 一定注意顺序， while(j < strs[i].length() && strs[i].charAt(j) == prefix.charAt(j) && j < prefix.length())
            // 就不对
                j++;
            }
            if(j == 0) {
                return "";
            }
            prefix = strs[i].substring(0, j);
        }
        
        return prefix;
    }
}