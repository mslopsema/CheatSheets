package Graphs;

import java.util.HashSet;
import java.util.Iterator;

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