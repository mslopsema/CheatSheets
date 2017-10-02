package Graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Breadth First Search (Level order traversal).
 * @author Mike
 *
 */
public class SearchBreadthFirst extends SearchAlgorithm {

    LinkedList<qItem> list;
    
    SearchBreadthFirst(int nodes) {super(nodes);}
    SearchBreadthFirst(SearchAlgorithm sa) {super(sa);}
    
    @Override
    public int search(int startNode, int endNode) {
        visited = new HashSet<Integer>();
        list = new LinkedList<qItem>();
        return bfs(startNode, endNode, 0);
    }
    
    private int bfs(int startNode, int endNode, int level) {
        if (startNode == endNode) return level;
        visited.add(startNode);
        
        Iterator<Integer> it = nodeMap.get(startNode).links.keySet().iterator();
        while (it.hasNext()) {
            int id = it.next();
            if (visited.contains(id)) continue;
            int dist = nodeMap.get(startNode).links.get(id);
            list.addLast(new qItem(id, level + dist));
        }
        
        if (list.isEmpty()) return -1;
        while (visited.contains(list.peekFirst())) list.removeFirst();
        qItem qi = list.removeFirst();
        return bfs(qi.id, endNode, qi.distance);
    }
}
