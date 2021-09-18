package baeldung;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {
    public String name;
    public List<Node> shortestPath = new LinkedList<>();
    public int distance = Integer.MAX_VALUE;
    public Map<Node, Integer> adjacentNodes = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }
}


