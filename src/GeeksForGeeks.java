/**
 * Implementation of the Dijkstra´s algorithm (Shortest Path Problem) found in Geeks For Geeks website.
 */
public class GeeksForGeeks {

    private static final int V = 9;

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        GeeksForGeeks shortestPath = new GeeksForGeeks();
        int[] result = shortestPath.calculate(graph, 0);
        shortestPath.printSolution(result);
    }

    /**
     * Gets the closest vertex to the starting vertex from the unvisited vertex set.
     *
     * @param distanceFromSource Array containing the minimum obtained distance from the source vertex to any other vertex on the
     *                           graph.
     * @param visited            Array used to track if a vertex has been visited by the algorithm or not.
     * @return The closest vertex index.
     */
    int getClosestVertex(int[] distanceFromSource, boolean[] visited) {
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

    /**
     * @param graph The graph which we will use on the algorithm, stored as an array of arrays. Every array
     *              represents a single vertex and contains the distances to every other connected vertex.
     * @param start The initial vertex of the graph.
     * @return Array containing the calculated shortest distance from the initial vertex to any other vertex on
     * the graph.
     */

    int[] calculate(int[][] graph, int start) {
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

    void printSolution(int distanceFromSource[]) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + distanceFromSource[i]);
        }
    }
}
