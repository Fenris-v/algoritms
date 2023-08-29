package sprint6.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// Алла пошла на стажировку в студию графического дизайна, где ей дали такое задание: для очень большого числа
// ориентированных графов преобразовать их список рёбер в список смежности. Чтобы побыстрее решить эту задачу, она
// решила автоматизировать процесс.
// Помогите Алле написать программу, которая по списку рёбер графа будет строить его список смежности.
//
// Формат ввода
// В первой строке дано число вершин n (1 ≤ n ≤ 100) и число ребер m (1 ≤ m ≤ n(n-1)). В следующих m строках заданы
// ребра в виде пар вершин (u,v), если ребро ведет от u к v.
//
// Формат вывода
// Выведите информацию о рёбрах, исходящих из каждой вершины.
// В строке i надо написать число рёбер, исходящих из вершины i, а затем перечислить вершины, в которые ведут эти
// рёбра — в порядке возрастания их номеров.
public class GraphBuilder {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int vertexCount = Integer.parseInt(stringTokenizer.nextToken());
            int ribCount = Integer.parseInt(stringTokenizer.nextToken());
            List<PriorityQueue<Integer>> graph = new ArrayList<>(Collections.nCopies(vertexCount, null));
            int index;
            for (int i = 0; i < ribCount; i++) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                index = Integer.parseInt(stringTokenizer.nextToken()) - 1;
                if (graph.get(index) == null) {
                    graph.set(index, new PriorityQueue<>());
                }

                graph.get(index).add(Integer.parseInt(stringTokenizer.nextToken()));
            }

            for (int i = 0; i < graph.size(); i++) {
                if (graph.get(i) == null) {
                    writer.write("0\n");
                } else {
                    writer.write(graph.get(i).size() + " " +
                                         graph.get(i).stream().map(String::valueOf).collect(Collectors.joining(" ")) +
                                         "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
