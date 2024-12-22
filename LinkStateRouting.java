import java.util.Arrays;

public class LinkStateRouting {
    public static void calculateRoutingTable(int[][] graph, int source, int vertices) {
        int[] distance = new int[vertices];
        boolean[] visited = new boolean[vertices];
        int[] nextHop = new int[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(nextHop, -1);
        distance[source] = 0;

        for (int i = 0; i < vertices; i++) {
            int u = -1;
            for (int j = 0; j < vertices; j++) {
                if (!visited[j] && (u == -1 || distance[j] < distance[u])) {
                    u = j;
                }
            }

            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != Integer.MAX_VALUE && !visited[v] &&
                    distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                    nextHop[v] = u;
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
            {0, 10, Integer.MAX_VALUE, Integer.MAX_VALUE, 20},
            {10, 0, 50, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 50, 0, 10, 30},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 10, 0, 60},
            {20, Integer.MAX_VALUE, 30, 60, 0}
        };

        calculateRoutingTable(graph, 0, vertices);
    }
}
