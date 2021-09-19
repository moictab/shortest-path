package custom;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Custom {

    private final Set<Node> visitedNodes = new HashSet<>();
    private final Set<Node> unvisitedNodes = new HashSet<>();

    public void getShortestPathFromSource(Node sourceNode) {
        sourceNode.setDistanceFromSource(0);
        unvisitedNodes.add(sourceNode);

        while (!unvisitedNodes.isEmpty()) {
            Node currentNode = this.getShortestPathFromUnvisited();
            unvisitedNodes.remove(currentNode);

            for (Map.Entry<Node, Integer> entry : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = entry.getKey();
                int adjacentDistance = entry.getValue();

                if (!visitedNodes.contains(adjacentNode)) {
                    calculateMinDistance(adjacentNode, adjacentDistance, currentNode);
                    unvisitedNodes.add(adjacentNode);
                }
            }

            visitedNodes.add(currentNode);
        }
    }

    private Node getShortestPathFromUnvisited() {
        int closestDistance = Integer.MAX_VALUE;
        Node closestNode = null;

        for (Node node : unvisitedNodes) {
            if (node.getDistanceFromSource() < closestDistance) {
                closestDistance = node.getDistanceFromSource();
                closestNode = node;
            }
        }

        return closestNode;
    }

    private void calculateMinDistance(Node adjacentNode, int adjacentDistance, Node currentNode) {
        if (currentNode.getDistanceFromSource() + adjacentDistance < adjacentNode.getDistanceFromSource()) {
            adjacentNode.setDistanceFromSource(currentNode.getDistanceFromSource() + adjacentDistance);
            LinkedList<Node> shortestPath = new LinkedList<>(currentNode.getShortestPath());
            shortestPath.add(currentNode);
            adjacentNode.setShortestPath(shortestPath);
        }
    }

}
