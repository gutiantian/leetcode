/* Longest Repeating Subsequence
Given a string, find length of the longest repeating subsequence 
such that the two subsequence don’t have same string character at same position, 
i.e., any ith character in the two subsequences shouldn’t have the same index in the original string.

Example
str = abc, return 0, There is no repeating subsequence
str = aab, return 1, The two subsequence are a(first) and a(second). 
Note that b cannot be considered as part of subsequence as it would be at same index in both.
str = aabb, return 2


Key: This problem is just the modification of Longest Common Subsequence problem. 
The idea is to find the LCS(str, str) where str is the input string with the restriction 
that when both the characters are same, they shouldn’t be on the same index in the two strings.
*/

public class Solution {
    /**
     * @param str a string
     * @return the length of the longest repeating subsequence
     */
    public int longestRepeatingSubsequence(String str) {
        // Write your code here
        int len = str.length();
        int[][] nums = new int[len + 1][len + 1];
        
        for(int i = 1; i < len + 1; i++) {
            for(int j = 1; j < len + 1; j++) {
                if(str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    nums[i][j] = nums[i - 1][j - 1] + 1;
                }else {
                    nums[i][j] = Math.max(nums[i - 1][j], nums[i][j - 1]);
                }
            }
        }
        
        return nums[len][len];
    }
}