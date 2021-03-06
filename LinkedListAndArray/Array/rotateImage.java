/* Rotate Image
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).

Example
Given a matrix

[
    [1,2],
    [3,4]
]
rotate it by 90 degrees (clockwise), return

[
    [3,1],
    [4,2]
]
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void rotate(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int length = matrix.length;
         // Square Transpose !!!!!!!!!!!!!!
         for(int i = 0; i < length; i++) {
             for(int j = i; j < length; j++) {
                 int tmp = matrix[i][j];
                 matrix[i][j] = matrix[j][i];
                 matrix[j][i] = tmp;
             }
         }
         
         //Rectangle flip left right
         for(int i = 0; i < length; i++) {
             for(int j = 0; j < length / 2; j++) {
                 int tmp = matrix[i][j];
                 matrix[i][j] = matrix[i][length - 1 - j];
                 matrix[i][length - 1 - j] = tmp;
             }
         }
    }
}
/*
The idea was firstly transpose the matrix and then flip it symmetrically. For instance,

1  2  3             
4  5  6
7  8  9


after transpose, it will be swap(matrix[i][j], matrix[j][i])

1  4  7
2  5  8
3  6  9


Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])

7  4  1
8  5  2
9  6  3

*/