package utils;

import java.util.HashMap;

public class Node {
    
    public HashMap<Integer, Integer> links;
    public int id;
    
    public Node(int id) {
        links = new HashMap<Integer, Integer>();
        this.id = id;
    }
}
