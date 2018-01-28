package Graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Breadth First Search (Level order traversal).
 * @author Mike
 * Method
 * 1. Start from defined Node (root).
 * 2. Add each connected node (child) to a list.
 * 3. Process the next item in the list.
 * Complexity
 * 1. Time  : The time complexity is linear with respect to number
 *    of nodes and links. Both nodes and links will be processed
 *    once. Thus runtime reduces to O(N + E) -> O(N).
 * 2. Space : The additional List is created for each node. Thus
 *    memory usage is O(N + E) -> O(N).
 */
public class SearchBreadthFirst extends SearchAlgorithm {

    LinkedList<Integer> list;
    
    SearchBreadthFirst(int nodes) {super(nodes);}
    SearchBreadthFirst(SearchAlgorithm sa) {super(sa);}
    
    @Override
    public int search(int startNode, int endNode) {
        visited = new HashSet<Integer>();
        list = new LinkedList<Integer>();
        return bfs(startNode, endNode);
    }
    
    private int bfs(int startNode, int endNode) {
        if (startNode == endNode) return nodeMap.get(startNode).distance;
        visited.add(startNode);
        
        Iterator<Integer> it = nodeMap.get(startNode).links.keySet().iterator();
        while (it.hasNext()) {
            int id = it.next();
            if (visited.contains(id)) continue;
            nodeMap.get(id).distance = nodeMap.get(startNode).distance + 
                                       nodeMap.get(startNode).links.get(id);
            list.addLast(id);
        }
        
        while (visited.contains(list.peekFirst())) list.removeFirst();
        if (list.isEmpty()) return -1;
        return bfs(list.removeFirst(), endNode);
    }
}
