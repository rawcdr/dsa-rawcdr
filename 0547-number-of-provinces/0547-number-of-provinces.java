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








// Optimized

/*
class Solution {
    public void dfs(int node,boolean[] visited,int[][] isConnected){
      visited[node]=true;
      for(int i=0;i<isConnected.length;i++){
        if(isConnected[node][i]==1 && ! visited[i])
          dfs(i,visited,isConnected);
      }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length,count=0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,visited,isConnected);
            }
        }
        return count;
    }
}
*/