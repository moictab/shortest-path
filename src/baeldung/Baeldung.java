package baeldung;

import java.util.*;

public class Baeldung {

    public void calculateShortestPathFromSource(Node initialNode) {
        initialNode.distance = 0;

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(initialNode);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getClosestNode(unsettledNodes);
            unsettledNodes.remove(currentNode);

            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.adjacentNodes.entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                int edgeWeight = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }

            settledNodes.add(currentNode);
        }
    }

    private Node getClosestNode(Set<Node> unsettledNodes) {
        Node closestNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        for (Node node : unsettledNodes) {
            int nodeDistance = node.distance;
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                closestNode = node;
            }
        }

        return closestNode;
    }

    private void calculateMinDistance(Node evaluationNode, int edgeWeigh, Node sourceNode) {
        int sourceDistance = sourceNode.distance;
        if (sourceDistance + edgeWeigh < evaluationNode.distance) {
            evaluationNode.distance = sourceDistance + edgeWeigh;
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.shortestPath);
            shortestPath.add(sourceNode);
            evaluationNode.shortestPath = shortestPath;
        }
    }
}
