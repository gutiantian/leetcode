/* Longest Substring Without Repeating Characters 

Given a string, find the length of the longest substring without repeating characters.

Example
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.

Challenge 
O(n) time
*/

//基础解法
public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        int i = 0, j = 0;
        
        int[] hash = new int[256];
        int maxLen = 0;
        for(i = 0; i < s.length(); i++) {
            //只有长度为256时才可以这样: hash[s.charAt(j)]， 要不然都会有offset: hash[s.charAt(j) - 'a']
            while(j < s.length() && hash[s.charAt(j)] == 0) {
                hash[s.charAt(j)] = 1;
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            }
            hash[s.charAt(i)] = 0;
        }
        
        return maxLen;
    }
}


//进阶解法
public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    
        /* 窗口类指针移动模板
        int j = 0;

        for(int i = 0; i < nums.length; i++) {

            while(j < nums.length) {
                if(满足条件) {
                    j++;
                    更行j状态
                }else{
                    break;
                }
            }

            更新i状态
        }
        */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        int j = 0, ans = 0;
        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++) {
            while(j < s.length()) {
                if(!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    j++;
                }else {
                    break;
                }
            }
            
            ans = Math.max(ans, j - i);
            set.remove(s.charAt(i));
        }
        
        return ans;
    }
}