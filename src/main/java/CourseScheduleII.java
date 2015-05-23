import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // input: the number of coursers, the course adjacency matrix
        // output: the array with courses in order
        // edge cases: num is non positive, prerequisities are null or empty
        // assumptions: use extra memory

        final Digraph graph = new Digraph(numCourses);
        for(int i = 0; i < prerequisites.length; i++) {
                graph.addEdge(prerequisites[i][1], prerequisites[i][0]);
        }

        final TopologicalSort topologicalSort = new TopologicalSort(graph);
        if(topologicalSort.hasCycle()) {
            return new int[0];
        }
        return topologicalSort.order();
    }

    private class Digraph {
        private final int N;
        private final List<Integer>[] adj;

        @SuppressWarnings("unchecked")
        public Digraph(int n) {
            N = n;
            adj = (List<Integer>[])new List[N];
            for(int ind = 0; ind < N; ind++) {
                adj[ind] = new LinkedList<>();
            }
        }

        public int V() {
            return N;
        }

        public void addEdge(int v, int w) {
            adj[v].add(w);
        }

        public Iterable<Integer> adj(int v) {
            return adj[v];
        }
    }

    private class TopologicalSort {

        private final Deque<Integer> order;
        private boolean[] marked;
        private boolean[] stack;
        private boolean cycle;

        public TopologicalSort(Digraph graph) {

            order = new LinkedList<>();
            marked = new boolean[graph.V()];
            stack = new boolean[graph.V()];
            for(int v = 0; v < graph.V() && !hasCycle(); v++) {
                if(!marked[v]) {
                    dfs(graph, v);
                }
            }
        }

        private void dfs(Digraph graph, int v) {

            marked[v] = true;
            stack[v] = true;
            for(int w : graph.adj(v)) {
                if(hasCycle()) {
                    return;
                } else if(!marked[w]) {
                    dfs(graph, w);
                } else if(stack[w]) {
                    cycle = true;
                }
            }
            stack[v] = false;
            order.push(v);
        }

        public boolean hasCycle() {
            return cycle;
        }

        public int[] order() {
            int ind = 0;
            final int[] result = new int[order.size()];
            for(int val : order) {
                result[ind++] = val;
            }
            return result;
        }
    }

    public static void main(String[] args) {

        CourseScheduleII schedule = new CourseScheduleII();

        System.out.println(Arrays.toString(schedule.findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(schedule.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }
}
