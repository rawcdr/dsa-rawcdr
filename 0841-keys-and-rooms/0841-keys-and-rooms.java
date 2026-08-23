class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[rooms.size()];

        dfs(0, rooms, visited);

        for (int i = 0 ; i < n; i++) {
            if(!visited[i]) return false;
        }

        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[room]) return;

        visited[room] = true;

        for (int key : rooms.get(room)) {
            dfs(key, rooms, visited);
        }
    }
}