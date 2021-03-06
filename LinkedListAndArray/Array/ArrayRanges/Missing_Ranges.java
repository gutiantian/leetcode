/* Missing Ranges
Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example 1
Given nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99
return ["2", "4->49", "51->74", "76->99"].

Example 2
Given nums = [0, 1, 3, 50, 75], lower = -1 and upper = 99
return ["-1", "2", "4->49", "51->74", "76->99"].

Example 3
Given nums = [0, 1, 3, 50, 75], lower = -10 and upper = 100
return ["-10 -> -1", "2", "4->49", "51->74", "76->100"].
记住， upper and lower must includes the given nums!!!
*/

public class Solution {
    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        List<String> ans = new ArrayList<String>();
        if(nums == null || nums.length == 0) {
            addRange(ans, lower, upper);
            return ans;
        }
        if(lower < nums[0]) {
            addRange(ans, lower, nums[0] - 1);
        }
        
        if(nums.length >= 2) {
            int i = 0, j = 1;
            while(j < nums.length) {
                addRange(ans, nums[i] + 1, nums[j] - 1);
                i++;
                j++;
            }
        }
        
        if(nums[nums.length - 1] < upper) {
            addRange(ans, nums[nums.length - 1] + 1, upper);
        }
        
        return ans;
    }
    
    private void addRange(List<String> ans, int lower, int upper) {
        if(lower > upper) {
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        
        if(lower == upper) {
            sb.append(lower);
        }else {
            sb.append(lower);
            sb.append("->");
            sb.append(upper);
        }
        
        ans.add(sb.toString());
        
    }
}