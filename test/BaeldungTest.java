import baeldung.Baeldung;
import baeldung.Graph;
import baeldung.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaeldungTest {

    @Test
    public void baeldungImplementationIsCorrect() {

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

        Baeldung baeldung = new Baeldung();
        baeldung.calculateShortestPathFromSource(nodeA);

        List<Node> shortestPathForNodeB = Collections.singletonList(nodeA);
        List<Node> shortestPathForNodeC = Collections.singletonList(nodeA);
        List<Node> shortestPathForNodeD = Arrays.asList(nodeA, nodeB);
        List<Node> shortestPathForNodeE = Arrays.asList(nodeA, nodeB, nodeD);
        List<Node> shortestPathForNodeF = Arrays.asList(nodeA, nodeB, nodeD);

        for (Node node : graph.nodes) {
            switch (node.name) {
                case "B":
                    assertEquals(shortestPathForNodeB, node
                            .shortestPath);
                    break;
                case "C":
                    assertEquals(shortestPathForNodeC, node
                            .shortestPath);
                    break;
                case "D":
                    assertEquals(shortestPathForNodeD, node
                            .shortestPath);
                    break;
                case "E":
                    assertEquals(shortestPathForNodeE, node
                            .shortestPath);
                    break;
                case "F":
                    assertEquals(shortestPathForNodeF, node
                            .shortestPath);
                    break;
            }
        }
    }

}