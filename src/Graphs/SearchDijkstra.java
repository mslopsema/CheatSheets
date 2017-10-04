package Graphs;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Dijkstra Searching Algorithm
 * @author Mike
 * Method
 * 1. Start from defined Node (root).
 * 2. Add all connected nodes to a PriorityQueue which keeps
 *    order based on distance (weight of the edge) from the root.
 * 3. Proceed to process the next node in the queue
 * Complexity
 * 1. Time  : There is 2 variables (a. # of Nodes, b. # of Edges (Links))
 *    Each Edge must be processed a maximum of 2 times (for a bi-directional case),
 *    which equates to O(E). Each Node must be processed a maximum of 1 time;
 *    however, the must be sorted in the PriorityQueue, which will reduce the
 *    runtime to O(N * Log(N)). Thus the final runtime will be O(N * Log(N) + E).
 * 2. Space : The PriorityQueue effectively doubles the memory. Thus the
 *    space complexity reduces to O(N) -> Technically O(N + E) however, considering
 *    the question at hand, the total memory used will be a linear factor of
 *    the given data.
 */
public class SearchDijkstra extends SearchAlgorithm {

    Queue<Integer> q;
    
    SearchDijkstra(int nodes) {super(nodes);}
    SearchDijkstra(SearchAlgorithm sa) {super(sa);}
    
    public int search(int startNode, int endNode) {
        
        visited = new HashSet<Integer>();
        q = new PriorityQueue<Integer>(nodeMap.size(),
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return nodeMap.get(a).distance.compareTo(
                               nodeMap.get(b).distance);
                    }
                });
        
        return dijkstraSearch(startNode, endNode);
    }
    
    private int dijkstraSearch(int startNode, int endNode) {
        if (startNode == endNode) return nodeMap.get(startNode).distance;
        visited.add(startNode);
        
        Iterator<Integer> it = nodeMap.get(startNode).links.keySet().iterator();
        while (it.hasNext()) {
            int id = it.next();
            if (visited.contains(id)) continue;
            nodeMap.get(id).distance = nodeMap.get(startNode).distance + 
                                       nodeMap.get(startNode).links.get(id);
            q.add(id);
        }
        
        while (visited.contains(q.peek())) q.remove();
        if (q.isEmpty()) return -1;
        return dijkstraSearch(q.poll(), endNode);
    }
}
