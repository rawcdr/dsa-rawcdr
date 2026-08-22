class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        int[][] dirc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;

                    grid[i][j] = '0';
                    q.offer(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int cell[] = q.poll();

                        int r = cell[0];
                        int c = cell[1];

                        for (int d[] : dirc) {
                            int nr = r + d[0];
                            int nc = c + d[1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                q.offer(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}