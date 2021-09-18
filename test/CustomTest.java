import custom.Custom;
import custom.Graph;
import custom.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomTest {

    @Test
    public void customImplementationIsCorrect() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        Custom custom = new Custom();
        custom.getShortestPathFromSource(nodeA);

        List<Node> shortestPathForNodeB = Collections.singletonList(nodeA);
        List<Node> shortestPathForNodeC = Collections.singletonList(nodeA);
        List<Node> shortestPathForNodeD = Arrays.asList(nodeA, nodeB);
        List<Node> shortestPathForNodeE = Arrays.asList(nodeA, nodeB, nodeD);
        List<Node> shortestPathForNodeF = Arrays.asList(nodeA, nodeB, nodeD);

        for (Node node : graph.getNodes()) {
            switch (node.getName()) {
                case "B":
                    assertEquals(shortestPathForNodeB, node.getShortestPath());
                    break;
                case "C":
                    assertEquals(shortestPathForNodeC, node.getShortestPath());
                    break;
                case "D":
                    assertEquals(shortestPathForNodeD, node.getShortestPath());
                    break;
                case "E":
                    assertEquals(shortestPathForNodeE, node.getShortestPath());
                    break;
                case "F":
                    assertEquals(shortestPathForNodeF, node.getShortestPath());
                    break;
            }
        }

    }

}