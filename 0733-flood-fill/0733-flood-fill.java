class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int org = image[sr][sc];

        if (org != color) {
            dfs(image, sr, sc, org, color);
        }

        return image;
    }

    private void dfs(int[][] image, int r, int c, int org, int color) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
        if (image[r][c] != org) return;

        image[r][c] = color;

        dfs(image, r+1, c, org, color);
        dfs(image, r-1, c, org, color);
        dfs(image, r, c+1, org, color);
        dfs(image, r, c-1, org, color);
    }
}