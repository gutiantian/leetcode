/* Spiral Matrix I
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example
Given the following matrix:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) {
            return res;
        }
        
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse Right
            for (int j = left; j <= right; j ++) {
                res.add(matrix[top][j]);
            }
            top++;
            
            // Traverse Down
            for (int j = top; j <= bottom; j ++) {
                res.add(matrix[j][right]);
            }
            right--;
            
            if (top <= bottom) {
                // Traverse Left
                for (int j = right; j >= left; j --) {
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }else {
                break;
            }
                
            if (left <= right) {
                // Traver Up
                for (int j = bottom; j >= top; j --) {
                    res.add(matrix[j][left]);
                }
                left ++;
            }else {
                break;
            }
            
        }
        return res;
    }
}




/*Spiral Matrix II
Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.

Example
Given n = 3,

You should return the following matrix:

[
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
]
*/

public class Solution {
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        // Write your code here
        int[][] res = new int[n][n];
        
        int num = 1;
        
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        
        while(top <= bottom && left <= right) {
            for(int j = left; j <= right; j++) {
                res[top][j] = num++;
            }
            top++;
            
            for(int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            right--;
            
            if(top <= bottom) {
                for(int j = right; j >= left; j--) {
                    res[bottom][j] = num++;
                }
                bottom--;
            }else {
                break;
            }
            
            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    res[i][left] = num++;
                }
                left++;
            }else{
                break;
            }
        }
        return res;
    }
}

















