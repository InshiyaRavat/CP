class Solution {
    public int backtrack(int i, int j, int uniquePaths, int[][] obstacleGrid){
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if(i >= rows || j>=cols || obstacleGrid[i][j] == 1){
            return 0;
        }

        if (i == rows-1 && j == cols-1){
            return 1;
        }

        int right = backtrack(i,j+1,uniquePaths,obstacleGrid);
        int down = backtrack(i+1,j,uniquePaths, obstacleGrid);
        return right + down;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return backtrack(0,0,0, obstacleGrid); 
    }
}
