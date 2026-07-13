class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create graph -> add - > init visited and pathvisited
        List<List<Integer>> graph = new ArrayList<>(); 

        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());

        for(int[] edge : prerequisites){
            int a = edge[0];
            int b = edge[1];

            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathvisited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(dfs(i, graph, visited, pathvisited)) return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] pathvisited){
        visited[node] = true;
        pathvisited[node] = true;

        for(int next : graph.get(node)){
            if(!visited[next]){
                if(dfs(next, graph, visited, pathvisited)) return true;
            }else if(pathvisited[next]){
                return true;
            }
        }

        pathvisited[node] = false;
        return false;
    }
}