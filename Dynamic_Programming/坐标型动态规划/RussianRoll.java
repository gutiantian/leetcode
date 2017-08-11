/* Russian Doll Envelopes
You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)
Example
Given envelopes = [[5,4],[6,4],[6,7],[2,3]], 
the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
O(n^2) 这道题很像 longest increasing subsequence,参见
*/
public class Solution {
    /**
     * @param envelopes a number of envelopes with widths and heights
     * @return the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        // Write your code here
        if(envelopes == null || envelopes.length == 0 
            || envelopes[0] == null || envelopes[0].length != 2) {
                return 0;
            }
            
        Arrays.sort(envelopes, new Comparator<int[]>() { //注意
            public int compare(int[] a, int b[]) { //从小到大
                if(a[0] == b[0]) {
                    return a[1] - b[1];
                }else {
                    return a[0] - b[0];
                }
            }
        });
        
        
        int[] f = new int[envelopes.length];
        int res = 1;
        f[0] = 1;
        
        for(int i = 1; i < envelopes.length; i++) {
            f[i] = 1;
            int aW = envelopes[i][0];
            int aH = envelopes[i][1];
            
            for(int j = 0; j < i; j++) {
                int bW = envelopes[j][0];
                int bH = envelopes[j][1];
                if(bigger(aW, aH, bW, bH)) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            
            res = Math.max(res, f[i]);
        }
        
        return res;
    
    }
    
    private boolean bigger(int aW, int aH, int bW, int bH) {
        return aW > bW && aH > bH;
    }
}