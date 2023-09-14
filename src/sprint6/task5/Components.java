package sprint6.task5;

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
import java.util.stream.Collectors;

public class Components {
    private static List<PriorityQueue<Integer>> graph;
    private static int[] colors;
    private static int color;
    private static List<List<Integer>> components;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int vertexCount = Integer.parseInt(stringTokenizer.nextToken());
            int ribCount = Integer.parseInt(stringTokenizer.nextToken());
            graph = buildGraph(vertexCount, ribCount, reader);
            colors = new int[vertexCount + 1];
            Arrays.fill(colors, -1);
            paintVertex();
            setComponents();
            writer.write(components.size() + "\n");
            for (List<Integer> component : components) {
                writer.write(component.stream().map(String::valueOf).collect(Collectors.joining(" ")) + "\n");
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
            if (graph.get(v) == null) {
                graph.set(v, new PriorityQueue<>());
            }

            graph.get(v).add(u);
        }

        return graph;
    }

    private static void paintVertex() {
        color = 0;
        for (int i = 1; i < colors.length; i++) {
            if (colors[i] == -1) {
                color++;
                dfs(i);
            }
        }
    }

    private static void dfs(int vertex) {
        if (colors[vertex] != -1) {
            return;
        }

        colors[vertex] = color;
        if (graph.get(vertex) == null) {
            return;
        }

        for (Integer w : graph.get(vertex)) {
            dfs(w);
        }
    }

    private static void setComponents() {
        components = new ArrayList<>();
        for (int i = 1; i < colors.length; i++) {
            if (components.size() < colors[i]) {
                components.add(new ArrayList<>());
            }

            components.get(colors[i] - 1).add(i);
        }
    }
}
