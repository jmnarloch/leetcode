import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jakubnarloch on 05.04.15.
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        // input: the graph to clone
        // output: the cloned graph
        // edge cases: node is null
        // assumptions: can use extra memory O(V + E)

        if(node == null) {
            return null;
        }

        final Map<Integer, UndirectedGraphNode> visited = new HashMap<Integer, UndirectedGraphNode>();
        return cloneGraph(node, visited);
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> visited) {

        if(visited.containsKey(node.label)) {
            return visited.get(node.label);
        }

        final UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        visited.put(clone.label, clone);
        for(UndirectedGraphNode adj : node.neighbors) {
            clone.neighbors.add(cloneGraph(adj, visited));
        }
        return clone;
    }

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
