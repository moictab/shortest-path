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

    @Test
    public void customComplexImplementationIsCorrect() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");

        nodeA.addDestination(nodeB, 4);
        nodeA.addDestination(nodeC, 8);

        nodeB.addDestination(nodeD, 5);

        nodeC.addDestination(nodeB, 2);
        nodeC.addDestination(nodeE, 6);

        nodeD.addDestination(nodeE, 9);
        nodeD.addDestination(nodeF, 11);

        nodeE.addDestination(nodeF, 9);
        nodeE.addDestination(nodeH, 4);

        nodeF.addDestination(nodeG, 2);

        nodeG.addDestination(nodeI, 7);

        nodeH.addDestination(nodeG, 3);
        nodeH.addDestination(nodeI, 8);

        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);
        graph.addNode(nodeH);
        graph.addNode(nodeI);

        Custom custom = new Custom();
        custom.getShortestPathFromSource(nodeA);

        List<Node> shortestPathForNodeB = Collections.singletonList(nodeA);
        List<Node> shortestPathForNodeC = Collections.singletonList(nodeA);
        List<Node> shortestPathForNodeD = Arrays.asList(nodeA, nodeB);
        List<Node> shortestPathForNodeE = Arrays.asList(nodeA, nodeC);
        List<Node> shortestPathForNodeF = Arrays.asList(nodeA, nodeB, nodeD);
        List<Node> shortestPathForNodeG = Arrays.asList(nodeA, nodeC, nodeE, nodeH);
        List<Node> shortestPathForNodeH = Arrays.asList(nodeA, nodeC, nodeE);
        List<Node> shortestPathForNodeI = Arrays.asList(nodeA, nodeC, nodeE, nodeH);

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
                case "G":
                    assertEquals(shortestPathForNodeG, node.getShortestPath());
                    break;
                case "H":
                    assertEquals(shortestPathForNodeH, node.getShortestPath());
                    break;
                case "I":
                    assertEquals(shortestPathForNodeI, node.getShortestPath());
                    break;
            }
        }
    }
}