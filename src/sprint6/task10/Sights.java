package sprint6.task10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Sights {
    private static int[][] distances;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int vertexCount = Integer.parseInt(stringTokenizer.nextToken());
            int ribCount = Integer.parseInt(stringTokenizer.nextToken());

            List<List<Edge>> graph = new ArrayList<>(vertexCount);
            for (int i = 0; i < vertexCount; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < ribCount; i++) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                int u = Integer.parseInt(stringTokenizer.nextToken()) - 1;
                int v = Integer.parseInt(stringTokenizer.nextToken()) - 1;
                int weight = Integer.parseInt(stringTokenizer.nextToken());

                graph.get(u).add(new Edge(v, weight));
                graph.get(v).add(new Edge(u, weight));
            }

            distances = new int[vertexCount][vertexCount];
            for (int i = 0; i < vertexCount; i++) {
                Arrays.fill(distances[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < vertexCount; i++) {
                dijkstra(graph, i);
            }

            for (int i = 0; i < vertexCount; i++) {
                for (int j = 0; j < distances[i].length; j++) {
                    if (distances[i][j] == Integer.MAX_VALUE) {
                        distances[i][j] = -1;
                    }
                }

                writer.write(
                        Arrays.stream(distances[i]).mapToObj(String::valueOf).collect(Collectors.joining(" ")) + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dijkstra(List<List<Edge>> graph, int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        distances[startVertex][startVertex] = 0;

        int u;
        while (!queue.isEmpty()) {
            u = queue.poll();
            for (Edge edge : graph.get(u)) {
                if (distances[startVertex][edge.to] > distances[startVertex][u] + edge.weight) {
                    distances[startVertex][edge.to] = distances[startVertex][u] + edge.weight;
                    queue.add(edge.to);
                }
            }
        }
    }
}

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
