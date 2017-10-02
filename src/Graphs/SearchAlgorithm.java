package Graphs;

import java.util.HashMap;
import java.util.HashSet;

import utils.Node;

public class SearchAlgorithm {
    
    protected HashMap<Integer, Node> nodeMap;
    protected HashSet<Integer> visited;
    
    protected class qItem {
        int id;
        Integer distance;
        
        qItem(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }
    
    // New Constructor
    SearchAlgorithm(int nodes) {
        nodeMap = new HashMap<Integer, Node>();
        for (int i = 1; i <= nodes; i++)
            nodeMap.put(i, new Node(i));
    }
    
    // Copy Constructor
    SearchAlgorithm(SearchAlgorithm sa) {
        this.nodeMap = sa.nodeMap;
    }
    
    public int search(int a, int b){return -1;}
    
    public void addLink(int nodeA, int nodeB) {
        addLink(nodeA, nodeB, 1);
    }
    
    public void addLink(int nodeA, int nodeB, int weight) {
        nodeMap.get(nodeA).links.put(nodeB, weight);
        nodeMap.get(nodeB).links.put(nodeA, weight);
    }
}
