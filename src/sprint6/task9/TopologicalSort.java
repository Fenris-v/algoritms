package sprint6.task9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// Дан ациклический ориентированный граф (так называемый DAG, directed acyclic graph). Найдите его топологическую
// сортировку, то есть выведите его вершины в таком порядке, что все рёбра графа идут слева направо. У графа может быть
// несколько подходящих перестановок вершин. Вам надо найти любую топологическую сортировку.
//
// Формат ввода
// В первой строке даны два числа – количество вершин n (1 ≤ n ≤ 105) и количество рёбер m (0 ≤ m ≤ 105). В каждой из
// следующих m строк описаны рёбра по одному на строке. Каждое ребро представлено парой вершин (from, to), 1≤ from,
// to ≤ n, соответственно номерами вершин начала и конца.
//
// Формат вывода
// Выведите номера вершин в требуемом порядке.
public class TopologicalSort {
    private static List<List<Integer>> graph;
    private static List<Integer> order;
    private static Color[] colors;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int vertexCount = Integer.parseInt(stringTokenizer.nextToken());
            int ribCount = Integer.parseInt(stringTokenizer.nextToken());
            graph = buildGraph(vertexCount, ribCount, reader);
            colors = new Color[vertexCount + 1];
            Arrays.fill(colors, Color.WHITE);
            mainSort(vertexCount);
            Collections.reverse(order);
            writer.write(order.stream().map(String::valueOf).collect(Collectors.joining(" ")));
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
        }

        return graph;
    }

    private static void mainSort(int vertexCount) {
        order = new Stack<>();
        for (int i = 1; i <= vertexCount; i++) {
            if (colors[i] == Color.WHITE) {
                topSort(i);
            }
        }
    }

    private static void topSort(int vertex) {
        colors[vertex] = Color.GRAY;
        if (graph.get(vertex) != null) {
            for (int w : graph.get(vertex)) {
                if (colors[w] == Color.WHITE) {
                    topSort(w);
                }
            }
        }

        colors[vertex] = Color.BLACK;
        order.add(vertex);
    }
}

enum Color {
    WHITE,
    GRAY,
    BLACK
}
