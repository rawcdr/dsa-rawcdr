// visit every boundary
//     if 0
//         run dfs
//         mark s(in dfs)
// after dfs
// traverse board
//     O -> X
//     S -> 0

class Solution {
    int dr[] = {-1, 1, 0, 0};
    int dc[] = {0, 0, -1, 1};

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int j=0;j<n;j++){
            if(board[0][j] == 'O') dfs(0, j, board);
            if(board[m-1][j] == 'O') dfs(m-1, j, board);
        }

        for(int i=0;i<m;i++){
            if(board[i][0] == 'O') dfs(i, 0, board);
            if(board[i][n-1] == 'O') dfs(i, n-1, board);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'S') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int r, int c, char[][] board){
        int m = board.length;
        int n = board[0].length;

        board[r][c] = 'S';

        for(int k=0;k<4;k++){
            int nr = r + dr[k];
            int nc = c + dc[k];

            if(nr >= 0 && nc >= 0 && nr < m && nc < n && board[nr][nc] == 'O') dfs(nr, nc, board);
        }
    }
}