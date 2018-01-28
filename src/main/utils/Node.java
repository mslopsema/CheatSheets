package utils;

import java.util.HashMap;

public class Node {
    
    public HashMap<Integer, Integer> links; // NodeId / LinkLength (weight)
    public Integer distance; // From Origin
    public Integer ID;
    
    public Node(int ID) {
        links = new HashMap<Integer, Integer>();
        this.ID = ID;
        distance = 0;
    }
}
