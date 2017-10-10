package Graphs;

import java.util.HashMap;
import java.util.Set;

public class Trie {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("test", 50);
        t.insert("testing", 100);
        System.out.println("t : " + t.sum("t"));
        System.out.println("test : " + t.sum("test"));
        System.out.println("tested : " + t.sum("tested"));
        System.out.println("testi : " + t.sum("testi"));
        System.out.println("testint : " + t.sum("testint"));
        System.out.println("testing : " + t.sum("testing"));
        System.out.println("testingss : " + t.sum("testingss"));
        System.out.println("zero : " + t.sum("zero"));
    }
    
    private tNode root;
    
    Trie() {
        root = new tNode(0);
    }
    
    
    public void insert(String s, int val) {
        insert(root, s, val, 0);
    }
    
    private int insert(tNode root, String s, int val, int i) {
        if (i >= s.length()) {
            int old = root.val;
            root.val = val;
            root.sum += val - old;
            return val - old;
        }
        Character c = s.charAt(i);
        if (!root.contains(c)) root.put(c, new tNode(0));
        int sum = insert(root.get(c), s, val, i + 1);
        root.sum += sum;
        return sum;
    }
    
    public int sum(String s) {
        return sum(root, s, 0);
    }
    
    private int sum(tNode root, String s, int i) {
        if (root == null) return 0;
        if (i >= s.length()) return root.sum;
        return sum(root.get(s.charAt(i)), s, i + 1);
    }
    
    class tNode {
        HashMap<Character, tNode> links;
        int val;
        int sum;
        
        tNode(int val) {
            links = new HashMap<Character, tNode>();
            this.val = val;
        }
        
        // Accessors for convenience
        tNode get(Character c) {return links.get(c);}
        tNode put(Character c, tNode tn) {return links.put(c, tn);};
        boolean contains(Character c) {return links.containsKey(c);}
    }
}
