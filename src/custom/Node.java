package custom;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Node {

    private LinkedList<Node> shortestPath = new LinkedList<>();
    private String name;
    private Map<Node, Integer> adjacentNodes = new HashMap<>();
    private int distanceFromSource = Integer.MAX_VALUE;

    public Node(String name) {
        this.name = name;
    }

    public void addDestination(Node node, int distance) {
        this.adjacentNodes.put(node, distance);
    }

    public LinkedList<Node> getShortestPath() {
        return this.shortestPath;
    }

    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public int getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(int distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", adjacentNodes=" + adjacentNodes +
                ", distanceFromSource=" + distanceFromSource +
                '}';
    }
}
