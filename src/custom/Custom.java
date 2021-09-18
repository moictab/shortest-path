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

        while (unvisitedNodes.size() > 0) {
            Node currentNode = getClosestNodeFromUnvisitedNodes();
            unvisitedNodes.remove(currentNode);

            for (Map.Entry<Node, Integer> pair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = pair.getKey();
                int adjacentDistance = pair.getValue();

                if (!visitedNodes.contains(adjacentNode)) {
                    calculateMinDistance(adjacentNode, adjacentDistance, currentNode);
                    unvisitedNodes.add(adjacentNode);
                }
            }

            visitedNodes.add(currentNode);
        }
    }

    private Node getClosestNodeFromUnvisitedNodes() {
        Node closestNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        for (Node node : unvisitedNodes) {
            if (node.getDistanceFromSource() < lowestDistance) {
                lowestDistance = node.getDistanceFromSource();
                closestNode = node;
            }
        }

        return closestNode;
    }

    private void calculateMinDistance(Node adjacentNode, int adjacentDistance, Node currentNode) {
        int currentDistance = currentNode.getDistanceFromSource();
        if (currentDistance + adjacentDistance < adjacentNode.getDistanceFromSource()) {
            adjacentNode.setDistanceFromSource(currentDistance + adjacentDistance);
            LinkedList<Node> shortestPath = new LinkedList<>(currentNode.getShortestPath());
            shortestPath.add(currentNode);
            adjacentNode.setShortestPath(shortestPath);
        }

    }

}
