package Graphs;

import java.util.HashMap;
import java.util.HashSet;

import utils.Node;

/**
 * Base Class for Graph Searching main.Algorithms
 * @author Mike
 */
public abstract class SearchAlgorithm {
    
    protected HashMap<Integer, Node> nodeMap;
    protected HashSet<Integer> visited;
    
    /**
     * New Constructor
     * It will build all of the nodes into the nodeMap.
     * @param nodes number of nodes in the graph
     */
    SearchAlgorithm(int nodes) {
        nodeMap = new HashMap<Integer, Node>();
        for (int i = 1; i <= nodes; i++)
            nodeMap.put(i, new Node(i));
    }
    
    /**
     * Copy Constructor
     * It will simply duplicate the nodeMap
     * @param sa Searching Algorithm to be copied
     */
    SearchAlgorithm(SearchAlgorithm sa) {
        this.nodeMap = sa.nodeMap;
    }
    
    /**
     * Searching Method - To be implemented by subclass
     * @param startNode The node ID of the starting node
     * @param endNode The node ID of the ending node
     * @return distance between startNode and endNode
     */
    abstract int search(int startNode, int endNode);
    
    /**
     * For adding a connecting link (edge) between two nodes.
     * The link will be bi-directional with distance/length (weight) 1.
     * @param nodeA
     * @param nodeB
     */
    public void addLink(int nodeA, int nodeB) {
        addLink(nodeA, nodeB, 1);
    }
    
    /**
     * For adding a connecting link (edge) between two nodes.
     * The link will be bi-directional.
     * @param nodeA
     * @param nodeB
     * @param weight (distance/length)
     */
    public void addLink(int nodeA, int nodeB, int weight) {
        nodeMap.get(nodeA).links.put(nodeB, weight);
        nodeMap.get(nodeB).links.put(nodeA, weight);
    }
}
