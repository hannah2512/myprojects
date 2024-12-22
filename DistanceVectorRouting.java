import java.util.Arrays;

public class DistanceVectorRouting {
    public static void calculateRoutingTable(int[][] graph, int vertices) {
        int[] distance = new int[vertices];
        int[] nextHop = new int[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(nextHop, -1);

        distance[0] = 0; // Starting at node 0

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (graph[i][j] != Integer.MAX_VALUE && distance[i] + graph[i][j] < distance[j]) {
                    distance[j] = distance[i] + graph[i][j];
                    nextHop[j] = i;
                }
            }
        }

        for (int i = 0; i < vertices; i++) {
            System.out.println("Node " + i + ": Distance = " + distance[i] + ", Next Hop = " + nextHop[i]);
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        int[][] graph = {
            {0, 2, Integer.MAX_VALUE, 1, Integer.MAX_VALUE},
            {2, 0, 3, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 3, 0, 4, 5},
            {1, Integer.MAX_VALUE, 4, 0, 6},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 6, 0}
        };

        calculateRoutingTable(graph, vertices);
    }
}
