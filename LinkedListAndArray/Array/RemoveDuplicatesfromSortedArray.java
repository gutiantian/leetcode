/*Given a sorted array, remove the duplicates in place such that each element appear only once 
and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
*/


public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int size = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == nums[size]) {
                continue;
            }else{
                size++;
                nums[size] = nums[i];
            }
        }
        return size + 1;
    }
}


/* Remove Duplicates from Sorted Array II
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        
        if(nums.length == 1) {
            return 1;
        }
        
        int size = 0, count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[size]) {
                if(count < 2) {
                    size++;
                    nums[size] = nums[i];
                    count++;
                }
            }else {
                size++;
                nums[size] = nums[i];
                count = 1;
            }
        }
        
        return size + 1;
    }
}