class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int t = 0;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty() && fresh > 0) {
            int sz = q.size();

            for (int i = 0; i < sz; i++){
                int cell[] = q.poll();

                int r = cell[0];
                int c = cell[1];

                for (int d[] : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }

            t++;
        }

        return fresh == 0 ? t : -1;
    }
}