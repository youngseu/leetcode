package Graph;

import Base.UndirectedGraphNode;

import java.util.HashMap;

//133 problem
//Clone Graph
//Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
        if (node == null) return null;
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        } else {
            UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
            map.put(node.label, clone);
            for (int i = 0; i < node.neighbors.size(); i++) {
                clone.neighbors.add(dfs(node.neighbors.get(i), map));
            }
            return clone;
        }
    }
}
