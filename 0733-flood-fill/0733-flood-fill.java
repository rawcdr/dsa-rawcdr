class Solution {
    int dr[] = {-1, 1, 0, 0};
    int dc[] = {0, 0, -1, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int org = image[sr][sc];
        if(org == color) return image;;
        dfs(image, sr, sc, org, color);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int org, int color){
        image[row][col] = color;

        int m = image.length;
        int n = image[0] .length;

        for(int i=0;i<4;i++){
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == org){
                dfs(image, nr, nc, org, color);
            }
        }
    }
}