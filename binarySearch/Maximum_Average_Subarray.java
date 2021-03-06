

/* Maximum Average Subarray
Given an array with positive and negative numbers, 
find the maximum average subarray which length should be greater or equal to given length k.

It's guaranteed that the size of the array is greater or equal to k.

Example
Given nums = [1, 12, -5, -6, 50, 3], k = 3
Return 15.667 // (-6 + 50 + 3) / 3 = 15.667
*/

public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        double error = 1e-12; //看题意！！！
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min) {
                min = nums[i];
            }
            
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        
        while(min + error < max)  { //1e-6 是double 的 1， 对比int 的 start + 1 < end
            double mid = (min + max) / 2.0;
            if(check(nums, mid, k)) {
                min = mid;
            }else {
                max = mid;
            }
        }
        
        return min; //这种double 的estimate 只返回min (left)
    }
    
    
    
    private boolean check(int[] nums, double mid, int k) {
        double[] sums = new double[nums.length + 1];
        sums[0] = 0;
        for(int i = 1; i < sums.length; i++) { //subarray sum : sums[n + 1], sums[0] = 0
            sums[i] += sums[i - 1] + nums[i - 1] - mid;
        }
        double min_pre = sums[0];
        for(int i = k; i < sums.length; i++) {
            if(sums[i] - min_pre >= 0) {
                return true;
            }
            
            min_pre = Math.min(min_pre, sums[i - k + 1]);
        }
        
        return false;
    }
}
