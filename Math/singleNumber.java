/*  Single Number I
Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

Example
Given [1,2,2,1,3,4,3], return 4

Challenge 
One-pass, constant extra space.
*/


/* 知识点：bitwise XOR ^
1.	if(A == B) {
		A ^ B = 0;
	}

2.	0 ^ A = A
*/


public class Solution {
    /**
      *@param A : an integer array
      *return : a integer 
      */
    public int singleNumber(int[] A) {
        // Write your code here
        int ans = 0;
        for(int i = 0; i < A.length; i++) {
            ans ^= A[i];
        }
        return ans;
    }
}