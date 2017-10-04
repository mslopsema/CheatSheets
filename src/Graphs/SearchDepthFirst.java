package Graphs;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Depth First Searching Algorithm
 * @author Mike
 * Method
 * 1. Start from defined Node (root).
 * 2. Recursively search through each connected node.
 * X. The implementation can be modified for a range of duties
 *    with relatively small overhead compared to BFS.
 *    - Finding contains() solution
 *    - Finding total weight
 *    - In the case of there being a guarantee of no loops in the graph
 *      (such as the case of a tree), then DFS method is further
 *      simplified, as no additional memoization is required.
 * Complexity
 * 1. Time  : Each node and edge will be processed 1 time -> O(N + E).
 * 2. Space : The algorithm simply uses basic memoization to avoid
 *    infinite loops. The extra data structure is linear proportion
 *    to the number of nodes. Thus the memory usage is O(N + E).
 */
public class SearchDepthFirst extends SearchAlgorithm {
    
    SearchDepthFirst(int nodes) {super(nodes);}
    SearchDepthFirst(SearchAlgorithm sa) {super(sa);}
    
    @Override
    public int search(int startNode, int endNode) {
        visited = new HashSet<Integer>();
        int ret = dfs(startNode, endNode, 0);
        return (ret == Integer.MAX_VALUE) ? -1 : ret;
    }
    
    private int dfs(int startNode, int endNode, int level) {
        if (startNode == endNode) return level;
        visited.add(startNode);
        
        int min = Integer.MAX_VALUE;
        Iterator<Integer> it = nodeMap.get(startNode).links.keySet().iterator();
        while (it.hasNext()) {
            int id = it.next();
            if (visited.contains(id)) continue;
            int dist = nodeMap.get(startNode).links.get(id);
            min = Math.min(min, dfs(id, endNode, level + dist));
        }
        
        return min;
    }
}