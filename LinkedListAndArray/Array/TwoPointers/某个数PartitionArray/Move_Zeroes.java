/* Move Ks  不理解， 待解决！！！！！！！！
Given an array nums, write a function to move all k's to the end of it while maintaining the relative order of the non-zero elements.

Notice

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
Example
Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
*/


/* 解题思路： 
经典模板： 把某个数移到Array的一端， in place, no extra space
较难理解，好好理解！！！
*/

public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums, int k) {
        // Write your code here
        int left = 0, right = 0; //解题关键： right 是下一个不是k的位置，left 是下一个是k的位置， 它俩互换
        
        while(right < nums.length) {
            if(nums[right] != k) {
                if(nums[left] == k) {
                    swap(nums, left, right);  
                }
                
                left++;
                right++;             
            }else {
                right++;
            }
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}