/*
Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
Have you met this question in a real interview? Yes
Example
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        int left = 0, right = heights.length - 1, res = 0;
        if(heights.length <= 1) {
            return 0;
        }
        int leftHeight = heights[0], rightHeight = heights[heights.length - 1];
      
        while(left < right) {
            if(leftHeight < rightHeight) {
                left++;
                if(leftHeight > heights[left]) {
                    res += leftHeight - heights[left];
                }else{
                    leftHeight = heights[left];
                }
            }else{
                right--;
                if(rightHeight > heights[right]){
                    res += rightHeight - heights[right];
                }else{
                    rightHeight = heights[right];
                }
            }
        }
        return res;
    }
}

/*
Instruction:
Here is my idea: instead of calculating area by height*width, we can think it in a cumulative way. In other words, sum water amount of each bin(width=1).
Search from left to right and maintain a max height of left and right separately, which is like a one-side wall of partial container. Fix the higher one and flow water from the lower part. For example, if current height of left is lower, we fill water in the left bin. 
Until left meets right, we filled the whole container.
*/