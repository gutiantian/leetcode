/* Container With Most Water
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Notice
You may not slant the container.
Example
Given [1,3,2], the max area of the container is 2.
*/


/*
Explainations:
Here is a simple proof for the solution.
Use v[low, high] indicates the volume of container with low and high. 
suppose height[low] < height[high], then we move low to low+1, that means we ingored v[low, high-1],v[low, high-2],etc, 
if this is safe, then the algorithm is right, and it's obvious that v[low, high-1],high[low, high-2]...... can't be larger than v[low, high] 
since its width can't be larger than high-low, and its height is limited by height[low].
*/
public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1, max = 0;
        while(left < right) {
            max = Math.max(area(left, right, heights), max);
            if(heights[left] < heights[right]) {
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
    
    private int area(int left, int right, int[] heights) {
        return Math.min(heights[left], heights[right]) * (right - left);
    }
}