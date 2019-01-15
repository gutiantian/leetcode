/*  Island Perimeter: 
https://leetcode.com/problems/island-perimeter/

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, 
and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). 
One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
Determine the perimeter of the island.

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16
*/

//和道题可以用dfs, 但太慢， 一下方法一个或多个岛屿都可以
class Solution {
    public int[] dx = {0, 0, 1, -1};
    public int[] dy = {1, -1, 0, 0};
    
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    for(int dir = 0; dir < 4; dir++) {
                        int ni = i + dx[dir];
                        int nj = j + dy[dir];
                        if(valid(ni, nj, grid)) {
                            count++;
                        }
                    }
                }
            }
        }
        
        return count;
    }
    
    private boolean valid(int i, int j, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean inBound = i >= 0 && i < m && j >= 0 && j < n;
        boolean outBound = i < 0 || i >= m || j < 0 || j >= n;
        return inBound && grid[i][j] == 0 || outBound;
    }
}