class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] a : prerequisites) {
            graph.get(a[1]).add(a[0]);
        }

        int state[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int c, List<List<Integer>> graph, int[] state) {
        if (state[c] == 1) return false;
        if (state[c] == 2) return true;

        state[c] = 1;

        for (int next : graph.get(c)) {
            if (!dfs(next, graph, state)) return false;
        }

        state[c] = 2;

        return true;
    }
}