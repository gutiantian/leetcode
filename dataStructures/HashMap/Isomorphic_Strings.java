/* Isomorphic Strings
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving 
the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> AtoB = new HashMap<>();
        HashMap<Character, Character> BtoA = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);  

            if(AtoB.containsKey(c1)) {
                if(AtoB.get(c1) != c2) {
                    return false;
                }
            }else {
                AtoB.put(c1, c2);
            }
                
            if(BtoA.containsKey(c2)) {
                if(BtoA.get(c2) != c1) {
                    return false;
                }                    
            }else {
                BtoA.put(c2, c1);
            }
                               
        }
        
        return true;
    }
}