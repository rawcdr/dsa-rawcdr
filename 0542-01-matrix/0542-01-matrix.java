class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if(mat[i][j] == 0){

                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while(!q.isEmpty()){

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for(int k = 0; k < 4; k++){

                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nr < m &&
                   nc >= 0 && nc < n &&
                   !visited[nr][nc]){

                    ans[nr][nc] = ans[r][c] + 1;

                    visited[nr][nc] = true;

                    q.offer(new int[]{nr,nc});
                }
            }
        }

        return ans;
    }
}