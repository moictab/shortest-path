package geeksforgeeks;

/**
 * Implementation of the Dijkstra´s algorithm (Shortest Path Problem) found in Geeks For Geeks website.
 */
public class GeeksForGeeks {

    private static final int V = 9;

    /**
     * @param graph The graph which we will use on the algorithm, stored as an array of arrays. Every array
     *              represents a single vertex and contains the distances to every other connected vertex.
     * @param start The initial vertex of the graph.
     * @return Array containing the calculated shortest distance from the initial vertex to any other vertex on
     * the graph.
     */
    public int[] calculate(int[][] graph, int start) {
        int[] distanceFromSource = new int[V];
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            distanceFromSource[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        distanceFromSource[start] = 0;

        for (int i = 0; i < V - 1; i++) {
            int closestVertex = getClosestVertex(distanceFromSource, visited);
            visited[closestVertex] = true;

            for (int j = 0; j < V; j++) {
                if (!visited[j]
                        && graph[closestVertex][j] != 0
                        && distanceFromSource[closestVertex] != Integer.MAX_VALUE
                        && distanceFromSource[closestVertex] + graph[closestVertex][j] < distanceFromSource[j])
                    distanceFromSource[j] = distanceFromSource[closestVertex] + graph[closestVertex][j];
            }
        }

        return distanceFromSource;
    }

    /**
     * Gets the closest vertex to the starting vertex from the unvisited vertex set.
     *
     * @param distanceFromSource Array containing the minimum obtained distance from the source vertex to any other vertex on the
     *                           graph.
     * @param visited            Array used to track if a vertex has been visited by the algorithm or not.
     * @return The closest vertex index.
     */
    private int getClosestVertex(int[] distanceFromSource, boolean[] visited) {
        int minValue = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < V; i++) {
            if (!visited[i] && distanceFromSource[i] <= minValue) {
                minValue = distanceFromSource[i];
                index = i;
            }
        }

        return index;
    }
}
