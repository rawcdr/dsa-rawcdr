class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int min = 0;

        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;

        while(!q.isEmpty()){
            int sz = q.size();

            for(int i=0;i<sz;i++){
                int[] curr = q.poll();

                int row = curr[0];
                int col = curr[1];

                for(int k=0;k<4;k++){
                    int nr = row + dr[k];
                    int nc = col + dc[k];

                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;

                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            if(!q.isEmpty()) min++;
        }

        return fresh == 0 ? min : -1;
    }
}