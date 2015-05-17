import java.util.ArrayList;

/**
 *
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) {
            return false;
        }

        // builds the graph out of the adjacency matrix
        final Digraph coursers = new Digraph(numCourses);

        for(int i = 0; i < prerequisites.length; i++) {

            coursers.addEdge(prerequisites[i][0], prerequisites[i][1]);
        }

        final Cycle cycle = new Cycle(coursers);
        return !cycle.hasCycle();
    }

    private static class Digraph {

        private final int V;
        private final ArrayList<Integer>[] adj;

        @SuppressWarnings("unchecked")
        public Digraph(int V) {
            this.V = V;
            this.adj = (ArrayList<Integer>[]) new ArrayList[V];
            for(int ind = 0; ind < V; ind++) {
                adj[ind] = new ArrayList<Integer>();
            }
        }

        public int V() {
            return V;
        }

        public void addEdge(int v, int w) {

            adj[v].add(w);
        }

        public Iterable<Integer> adj(int v) {
            return adj[v];
        }
    }

    private static class Cycle {

        private final Digraph graph;
        private final boolean[] marked;
        private final boolean[] stack;
        private boolean hasCycle;

        public Cycle(Digraph graph) {
            this.graph = graph;

            marked = new boolean[graph.V()];
            stack = new boolean[graph.V()];
            for(int v = 0; v < graph.V(); v++) {
                if(!marked[v]) {
                    dfs(v);
                }
            }
        }

        private void dfs(int v) {
            marked[v] = true;
            stack[v] = true;

            for(int w : graph.adj(v)) {
                if(hasCycle) {
                    return;
                } else if(stack[w]) {
                    hasCycle = true;
                } else if(!marked[w]) {
                    dfs(w);
                }
            }
            stack[v] = false;
        }

        public boolean hasCycle() {
            return hasCycle;
        }
    }
}
