package baeldung;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    public Set<Node> nodes = new HashSet<>();

    public void addNode(Node node) {
        this.nodes.add(node);
    }

}
