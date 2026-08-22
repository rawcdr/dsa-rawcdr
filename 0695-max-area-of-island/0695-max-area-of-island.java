class Solution {
    int max = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int ar = dfs(grid, i, j);
                    max = Math.max(max, ar);
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        if (grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        int ar = 1;

        ar += dfs(grid, i - 1, j);
        ar += dfs(grid, i, j - 1);
        ar += dfs(grid, i + 1, j);
        ar += dfs(grid, i, j + 1);

        return ar;
    }
}