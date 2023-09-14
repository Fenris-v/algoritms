package sprint6.task8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Вам дан ориентированный граф. Известно, что все его вершины достижимы из вершины s=1. Найдите время входа и выхода
// при обходе в глубину, производя первый запуск из вершины s. Считайте, что время входа в стартовую вершину равно 0.
// Соседей каждой вершины обходите в порядке увеличения номеров.
//
// Формат ввода
// В первой строке дано число вершин n (1 ≤ n ≤ 2⋅ 105) и рёбер (0 ≤ m ≤ 2 ⋅ 105). В каждой из следующих m строк
// записаны рёбра графа в виде пар (from, to), 1 ≤ from ≤ n — начало ребра, 1 ≤ to ≤ n — его конец. Гарантируется,
// что в графе нет петель и кратных рёбер.
//
// Формат вывода
// Выведите n строк, в каждой из которых записана пара чисел tini, touti — время входа и выхода для вершины i.
public class TimeToGetOut {
    private static List<PriorityQueue<Integer>> graph;
    private static List<Pair> times;
    private static Color[] colors;
    private static int time;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int vertexCount = Integer.parseInt(stringTokenizer.nextToken());
            int ribCount = Integer.parseInt(stringTokenizer.nextToken());
            graph = buildGraph(vertexCount, ribCount, reader);
            colors = new Color[graph.size()];
            Arrays.fill(colors, Color.WHITE);

            times = new ArrayList<>(Collections.nCopies(graph.size(), null));
            time = 0;
            countTimes(1);
            for (int i = 1; i < graph.size(); i++) {
                writer.write(times.get(i) + "\n");
            }
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
        }

        return graph;
    }

    private static void countTimes(int vertex) {
        times.set(vertex, new Pair(time));
        time++;
        colors[vertex] = Color.GRAY;
        PriorityQueue<Integer> heap = graph.get(vertex);
        while (heap != null && !heap.isEmpty()) {
            Integer w = heap.poll();
            if (colors[w] == Color.WHITE) {
                countTimes(w);
            }
        }

        times.get(vertex).setOut(time);
        time++;
        colors[vertex] = Color.BLACK;
    }
}

class Pair {
    private final int in;
    private int out;

    public Pair(int in) {
        this.in = in;
    }

    public void setOut(int out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return in + " " + out;
    }
}

enum Color {
    WHITE,
    GRAY,
    BLACK
}
