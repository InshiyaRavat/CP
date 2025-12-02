class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // If start or end is blocked → no paths
        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) return 0;

        Integer[][] memo = new Integer[rows][cols];
        return dfs(0, 0, grid, memo);
    }

    private int dfs(int i, int j, int[][] grid, Integer[][] memo) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (i >= rows || j >= cols || grid[i][j] == 1) return 0;

        // Reached destination
        if (i == rows - 1 && j == cols - 1) return 1;

        if (memo[i][j] != null) return memo[i][j];

        int right = dfs(i, j + 1, grid, memo);
        int down = dfs(i + 1, j, grid, memo);

        memo[i][j] = right + down;
        return memo[i][j];
    }
}
