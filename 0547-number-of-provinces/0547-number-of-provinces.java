class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<v;i++) list.add(new ArrayList<>());
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(isConnected[i][j] == 1 && i != j){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }

        boolean visited[] = new boolean[v];
        int cnt = 0;

        for(int i=0;i<v;i++){
            if(!visited[i]){
                cnt++;
                dfs(i, list, visited);
            }
        }

        return cnt;
    }

    private void dfs(int node, List<List<Integer>> list, boolean visited[]){
        visited[node] = true;

        for(int n : list.get(node)){
            if(!visited[n]){
                dfs(n, list, visited);
            }
        }
    }
}