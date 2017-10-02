package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TestSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Graphs/TestFile.test"));
        String[] sIn = br.readLine().split(" ");
        final int NODES = Integer.parseInt(sIn[0]);
        final int LINKS = Integer.parseInt(sIn[1]);
        
        SearchAlgorithm algoBase = new SearchAlgorithm(NODES);
        for (int i = 0; i < LINKS; i++) {
            String[] sLinks = br.readLine().split(" ");
            algoBase.addLink(Integer.parseInt(sLinks[0]),
                             Integer.parseInt(sLinks[1]),
                             Integer.parseInt(sLinks[2]));
        }
        String[] sTest = br.readLine().split(" ");
        int startNode = Integer.parseInt(sTest[0]);
        int endNode   = Integer.parseInt(sTest[1]);
        br.close();
        
        List<SearchAlgorithm> algoList = new LinkedList<SearchAlgorithm>();
        algoList.add(new SearchBreadthFirst(algoBase));
        algoList.add(new SearchDepthFirst(algoBase));
        algoList.add(new SearchDijkstra(algoBase));
        for (SearchAlgorithm sa : algoList) {
            long startTime = System.currentTimeMillis();
            int distance = sa.search(startNode, endNode);
            long endTime = System.currentTimeMillis();
            System.out.println("[" + sa.getClass().getName() + "] " +
                    distance + " : " + (endTime - startTime) + "ms");
        }
    }
}
