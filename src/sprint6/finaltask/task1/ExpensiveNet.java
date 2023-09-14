package sprint6.finaltask.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * id: 90544522
 */
/*
-- ПРИНЦИП РАБОТЫ --
Программа находит цену остова графа с наибольшей стоимостью.

На первом этапе читаются входные данные и сохраняют граф в виде коллекции коллекций рёбер. Такое решение принято, т.к.
неизвестно какой будет плотность графа. Т.к. граф неориентированный, каждое ребро добавляется как 2 разных ребра,
т.е. по итогу получается структура, где на верхнем уровне коллекции индекс отображает порядковый номер вершины,
вложенная коллекция хранит несортированный и ни к чему не привязанный список рёбер этой вершины, а объект ребра хранит
индекс вершины в которую оно направлено и вес.

После построения графа производится поиск максимальной стоимости остова графа. Для реализации создаётся несколько
вспомогательных структур. Одна из них - это HashSet. Она хранит список вершин, которые ещё не добавлены в остов.
Другая структура - это куча, которая хранит список рёбер доступных для использования в текущий момент выполнения.

Алгоритм подсчёта берёт в качестве стартовой вершины вершину с индексом 1. Далее он исключает эту вершину из списка
"не добавленных вершин" и добавляет все исходящие из неё рёбра в кучу. Затем в цикле while идёт попытка пройтись
по всем вершинам. Для этого всегда из кучи извлекается ребро с наибольшей стоимостью, проверяется наличие вершины,
к которой ведёт ребро, в списке ещё не добавленных и, если вершины нет в списке, она добавляется, а вес суммирует
к итоговой сумме.

По завершению работы цикла проверяется, остались ли не добавленные вершины и, если они есть, то делается вывод, что
граф несвязный и задачу с этим графом решить невозможно.

Данная программа является реализацией пирамидальной сортировки. Сначала создаётся объект приоритетной невозрастающей
кучи. После построения кучи, на каждом шаге забирается корневой элемент и куча гарантирует, что этот элемент является
наиболее приоритетным.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Временная сложность построения графа линейно зависит от количества рёбер, т.к. выполняется столько операций, сколько
рёбер необходимо добавить, т.е. O(E).

Временная сложность алгоритма поиска остова будет O(E * log V). Каждое ребро должно быть обработано и добавлено в кучу,
а поиск оптимального ребра производится за O(log V).

Т.е. итоговая сложность алгоритма O(2E + E * log V), что можно упростить до O(E * log V).

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Для хранения графа используются коллекции, как описано выше и каждое ребро имеет копию в обратном направлении,
поэтому для хранения графа потребуется памяти O(V + 2E), где V - количество вершин, а E - количество рёбер.
Эту сложность можно упростить до O(V + E).

Пространственная сложность подсчета максимально стоимости остова потребует расхода дополнительной памяти.
Помимо хранения графа, дополнительно хранится сет не добавленных вершин, что требует дополнительно O(V) памяти.
Также создаётся куча, которая в худшем случае займёт размер равный количеству рёбер, т.е. O(E),
т.к. рёбра "продублированы".

Итоговая пространственная сложность алгоритма будет O(2V + 3E), что можно сократить до O(V + E).
 */
public class ExpensiveNet {
    private static final String MESSAGE = "Oops! I did it again";
    private static List<Edge>[] graph;
    private static boolean[] added;
    private static int remainingVertex;
    private static PriorityQueue<Edge> edges;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int vertexCount = Integer.parseInt(stringTokenizer.nextToken());
            int edgeCount = Integer.parseInt(stringTokenizer.nextToken());
            graph = buildGraph(vertexCount, edgeCount, reader);

            int maxWeightPath = getMaxWeightPath(vertexCount);

            writer.write(maxWeightPath == -1 ? MESSAGE : String.valueOf(maxWeightPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Edge>[] buildGraph(int vertexCount, int edgeCount, BufferedReader reader) throws IOException {
        List<Edge>[] graph = new ArrayList[vertexCount + 1];
        int u;
        int v;
        int weight;
        StringTokenizer stringTokenizer;
        for (int i = 0; i < edgeCount; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            u = Integer.parseInt(stringTokenizer.nextToken());
            v = Integer.parseInt(stringTokenizer.nextToken());
            weight = Integer.parseInt(stringTokenizer.nextToken());

            if (graph[u] == null) {
                graph[u] = new ArrayList<>();
            }

            graph[u].add(new Edge(v, weight));
            if (graph[v] == null) {
                graph[v] = new ArrayList<>();
            }

            graph[v].add(new Edge(u, weight));
        }

        return graph;
    }

    private static int getMaxWeightPath(int vertexCount) {
        added = new boolean[vertexCount + 1];
        remainingVertex = vertexCount;
        edges = new PriorityQueue<>();

        int sum = 0;
        addVertex(1);

        Edge edge;
        while (!edges.isEmpty()) {
            edge = edges.poll();
            if (added[edge.to]) {
                continue;
            }

            sum += edge.weight;
            addVertex(edge.to);
        }

        return remainingVertex == 0 ? sum : -1;
    }

    private static void addVertex(int vertex) {
        added[vertex] = true;
        remainingVertex--;
        if (graph[vertex] == null) {
            return;
        }

        for (Edge edge : graph[vertex]) {
            if (!added[edge.to]) {
                edges.add(edge);
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return edge.weight - weight;
    }
}
