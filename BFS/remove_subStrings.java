/* Remove Substrings
Given a string s and a set of n substrings. 
You are supposed to remove every instance of those n substrings from s so that s is of 
the minimum length and output this minimum length.

Example
Given s = ccdaabcdbb, substrs = ["ab", "cd"]
Return 2

Explanation: 
ccdaabcdbb -> ccdacdbb -> cabb -> cb (length = 2)
*/

public class Solution {
    /**
     * @param s a string
     * @param dict a set of n substrings
     * @return the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        // Write your code here
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        
        int length = s.length();
        queue.offer(s);
        visited.add(s);
        
        while(queue.size() != 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String word = queue.poll();
                length = Math.min(word.length(), length);
                
                for(String minus : dict) {
                    int index = word.indexOf(minus);
                    while(index != -1) {
                        String new_word = after_remove(word, index, minus);
                        if(!visited.contains(new_word)) {
                            queue.offer(new_word);
                            visited.add(new_word);
                        }
                        index = word.indexOf(minus, index + 1);//注意indexOf()用法， 另外， 在本题中， 必须对于所有index 进行处理
                    }
                }
            }
        }
        
        return length;
    }
    
    private String after_remove(String word, int index, String minus) {
        String new_word = word.substring(0, index) + word.substring(index + minus.length(), word.length());//注意substring用法
        return new_word;
    }
}
