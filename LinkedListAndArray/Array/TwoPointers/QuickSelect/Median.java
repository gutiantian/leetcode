/* Median
Given a unsorted array with integers, find the median of it.

A median is the middle number of the array after it is sorted.

If there are even numbers in the array, return the N/2-th number after sorted.

Example
Given [4, 5, 1, 2, 3], return 3.

Given [7, 9, 4, 5], return 5.

Challenge 
O(n) time.
*/

//Quick Select : Complexity O(n)!!! 包含重复情况
//经典模板！！！！！
//记住， Median是 (len / 2) + 1 Smallest number, 不是largest number
//这里也可以用PriorityQueue 做， (O(n). S(k)), Top K smallest numbers

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        int len = nums.length;
        int k = (len + 1) / 2;
        return quickSelectTopKSmallest(nums, 0, len - 1, k);
    }
    
    private int quickSelectTopKSmallest(int[] nums, int start, int end, int k) {
        if(start == end) {
            return nums[start];
        }
        
        int i = start, j = end;
        int pivot = nums[start + (end - start) / 2];
        
        while(i <= j) {
            while(i <= j && nums[i] < pivot) {
                i++;
            }
            
            while(i <= j && nums[j] > pivot) {
                j--;
            }
            
            if(i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        
        
        if(start + k - 1 <= j) {
            return quickSelectTopKSmallest(nums, start, j, k);
        }
        
        if(start + k - 1 >= i) {
            return quickSelectTopKSmallest(nums, i, end, k - (i - start));
        }
        
        return nums[j + 1];
    }
    
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}