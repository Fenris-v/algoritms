package sprint6.task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// Задан неориентированный граф. Обойдите поиском в ширину все вершины, достижимые из заданной вершины s, и выведите их
// в порядке обхода, если начинать обход из s.
//
// Формат ввода
// В первой строке дано количество вершин n (1 ≤ n ≤ 105) и рёбер m (0 ≤ m ≤ 105). Далее в m строках описаны рёбра
// графа. Каждое ребро описывается номерами двух вершин u и v (1 ≤ u, v ≤ n). В последней строке дан номер стартовой
// вершины s (1 ≤ s ≤ n).
// Гарантируется, что в графе нет петель и кратных рёбер.
//
// Формат вывода
// Выведите вершины в порядке обхода, считая что при запуске от каждой конкретной вершины её соседи будут
// рассматриваться в порядке возрастания (то есть если вершина 2 соединена с 1 и 3, то сначала обход пойдёт в 1,
// а уже потом в 3).
public class BFS {
    private static List<PriorityQueue<Integer>> graph;
    private static byte[] checked;
    private static List<Integer> path;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int vertexCount = Integer.parseInt(stringTokenizer.nextToken());
            int ribCount = Integer.parseInt(stringTokenizer.nextToken());

            graph = buildGraph(vertexCount, ribCount, reader);
            path = new ArrayList<>();
            checked = new byte[graph.size()];

            bfs(Integer.parseInt(reader.readLine()));

            writer.write(path.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<PriorityQueue<Integer>> buildGraph(int vertexCount, int ribCount, BufferedReader reader)
            throws IOException {
        StringTokenizer stringTokenizer;
        List<PriorityQueue<Integer>> graph = new ArrayList<>(Collections.nCopies(vertexCount + 1, null));
        int u;
        int v;
        for (int i = 0; i < ribCount; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            u = Integer.parseInt(stringTokenizer.nextToken());
            v = Integer.parseInt(stringTokenizer.nextToken());
            if (graph.get(u) == null) {
                graph.set(u, new PriorityQueue<>());
            }

            graph.get(u).add(v);
            if (graph.get(v) == null) {
                graph.set(v, new PriorityQueue<>());
            }

            graph.get(v).add(u);
        }

        return graph;
    }

    private static void bfs(int vertex) {
        Queue<Integer> planned = new LinkedList<>();
        planned.add(vertex);
        path.add(vertex);
        checked[vertex] = 1;
        int u;
        int v;
        PriorityQueue<Integer> heap;
        while (!planned.isEmpty()) {
            u = planned.poll();
            if (graph.get(u) == null) {
                continue;
            }

            heap = graph.get(u);
            while (!heap.isEmpty()) {
                v = heap.poll();
                if (checked[v] == 0) {
                    path.add(v);
                    checked[v] = 1;
                    planned.add(v);
                }
            }
        }
    }
}
