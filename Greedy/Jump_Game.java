/* Jump Game
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Notice

This problem have two method which is Greedy and Dynamic Programming.

The time complexity of Greedy method is O(n).

The time complexity of Dynamic Programming method is O(n^2).

We manually set the small data set to allow you pass the test in both ways. This is just to let you learn how to use this problem in dynamic programming ways. 
If you finish it in dynamic programming ways,
you can try greedy method to make it accept again.


Example
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        //Greedy
        int farthest = 0;
        for(int i = 0; i < A.length; i++) {
            if(i <= farthest && farthest < i + A[i]) {
                farthest = i + A[i];
            }
        }
        
        return farthest >= A.length - 1;
    }
}

