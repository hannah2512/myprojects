import java.util.Scanner;

public class BellmanFord {
    public static final int MAX_VALUE = Integer.MAX_VALUE;

    public static void bellmanFord(int vertices, int[][] graph, int source) {
        int[] distance = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            distance[i] = MAX_VALUE;
        }
        distance[source] = 0;

        for (int i = 1; i < vertices - 1; i++) {
            for (int u = 0; u < vertices; u++) {
                for (int v = 0; v < vertices; v++) {
                    if (graph[u][v] != MAX_VALUE && distance[u] != MAX_VALUE &&
                        distance[u] + graph[u][v] < distance[v]) {
                        distance[v] = distance[u] + graph[u][v];
                    }
                }
            }
        }

        for (int i = 0; i < vertices; i++) {
            System.out.println("Distance from node " + source + " to node " + i + " is: " + distance[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        int[][] graph = new int[vertices][vertices];

        System.out.println("Enter the adjacency matrix (use " + MAX_VALUE + " for infinity): ");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter the source vertex: ");
        int source = sc.nextInt();

        bellmanFord(vertices, graph, source);
    }
}
