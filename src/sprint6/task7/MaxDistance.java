package sprint6.task7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Под расстоянием между двумя вершинами в графе будем понимать длину кратчайшего пути между ними в рёбрах. Для данной
// вершины s определите максимальное расстояние от неё до другой вершины неориентированного графа.
//
// Формат ввода
// В первой строке дано количество вершин n (1 ≤ n ≤ 105) и рёбер m (0 ≤ m ≤ 105). Далее в m строках описаны рёбра
// графа. Каждое ребро описывается номерами двух вершин u и v (1 ≤ u, v ≤ n). В последней строке дан номер
// вершины s (1 ≤ s ≤ n). Гарантируется, что граф связный и что в нём нет петель и кратных рёбер.
//
// Формат вывода
// Выведите длину наибольшего пути от s до одной из вершин графа.
public class MaxDistance {
    private static List<List<Integer>> graph;
    private static byte[] checked;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int vertexCount = Integer.parseInt(stringTokenizer.nextToken());
            int ribCount = Integer.parseInt(stringTokenizer.nextToken());

            graph = buildGraph(vertexCount, ribCount, reader);
            checked = new byte[graph.size()];

            int maxDistance = bfs(Integer.parseInt(reader.readLine()));
            writer.write(String.valueOf(maxDistance));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<List<Integer>> buildGraph(int vertexCount, int ribCount, BufferedReader reader)
            throws IOException {
        StringTokenizer stringTokenizer;
        List<List<Integer>> graph = new ArrayList<>(Collections.nCopies(vertexCount + 1, null));
        int u;
        int v;
        for (int i = 0; i < ribCount; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            u = Integer.parseInt(stringTokenizer.nextToken());
            v = Integer.parseInt(stringTokenizer.nextToken());
            if (graph.get(u) == null) {
                graph.set(u, new ArrayList<>());
            }

            graph.get(u).add(v);
            if (graph.get(v) == null) {
                graph.set(v, new ArrayList<>());
            }

            graph.get(v).add(u);
        }

        return graph;
    }

    private static int bfs(int vertex) {
        int maxDistance = 0;
        Queue<Integer> planned = new LinkedList<>();
        planned.add(vertex);
        checked[vertex] = 1;
        int[] distance = new int[graph.size()];
        distance[vertex] = 0;
        while (!planned.isEmpty()) {
            int u = planned.poll();
            List<Integer> ribs = graph.get(u);
            if (ribs == null) {
                continue;
            }

            for (int v : ribs) {
                if (checked[v] == 0) {
                    maxDistance = Math.max(maxDistance, distance[u] + 1);
                    distance[v] = distance[u] + 1;
                    checked[v] = 1;
                    planned.add(v);
                }
            }
        }

        return maxDistance;
    }
}
