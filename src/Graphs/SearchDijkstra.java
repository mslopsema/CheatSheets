package Graphs;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SearchDijkstra extends SearchAlgorithm {

    Queue<qItem> q;
    
    SearchDijkstra(int nodes) {super(nodes);}
    SearchDijkstra(SearchAlgorithm sa) {super(sa);}
    
    public int search(int startNode, int endNode) {
        
        visited = new HashSet<Integer>();
        q = new PriorityQueue<qItem>(nodeMap.size(),
                new Comparator<qItem>() {
                    public int compare(qItem a, qItem b) {
                        return a.distance.compareTo(b.distance);
                    }
                });
        return bfs(startNode, endNode, 0);
    }
    
    private int bfs(int startNode, int endNode, int distance) {
        if (startNode == endNode) return distance;
        visited.add(startNode);
        
        Iterator<Integer> it = nodeMap.get(startNode).links.keySet().iterator();
        while (it.hasNext()) {
            int id = it.next();
            if (visited.contains(id)) continue;
            int dist = distance + nodeMap.get(startNode).links.get(id);
            qItem i = new qItem(id, dist);
            q.add(i);
        }
        
        if (q.isEmpty()) return -1;
        while (visited.contains(q.peek())) q.remove();
        qItem i = q.poll();
        return bfs(i.id, endNode, i.distance);
    }
}
