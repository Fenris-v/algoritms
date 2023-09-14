package sprint6.finaltask.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * id: 90482962
 */
/*
-- ПРИНЦИП РАБОТЫ --
Программа проверяет оптимальность маршрутов на основании графа. По условию дан направленный граф, где вершины с меньшим
номером имеют все возможные рёбра к вершинам с большим номером.

На первом этапе считываются входные данные и строится граф. Для решения данной задачи граф имеет особенности строения,
таким образом для каждой вершины указываются все вершины, достижимые из текущей по ребрам одного типа. Для этого
у каждой вершины считываются все доступные рёбра и, в зависимости от типа ребра, добавляются в граф по определенному
правилу.

После построения графа производится проверка оптимальности. Для этого создаётся дополнительный массив для возможности
помечать вершины цветами. Затем запускается цикл, который проходит по каждой вершине графа. На каждой итерации цикла
создаётся стэк, в него будут складываться вершины, для которых ещё не произведена проверка оптимальности.

В стэк попадает вершина, равная индексу итерации цикла. Далее запускается вложенный цикл, который будет работать пока
не опустеет стэк. В этом цикле помечаются вершины цветом. Если вершина была серой, то она помечается чёрным цветом и
удаляется из стэка. Если вершина была белой, она помечается серым цветом, а затем запускается ещё один цикл, который
пройдёт по всем достижимым из текущей вершины вершинам и проверит их цвет. Вершины белого цвета добавляются в стэк,
а если встречается хотя бы одна вершина серого цвета, значит между этими вершинами существует маршрут другого типа.
В таком случае граф считается не оптимальным и работа метода прерывается.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Временная сложность построения графа квадратична и зависит от количества вершин. Выполняется O(n * (n - 1))
операций, т.к. для каждой вершины доступно количество рёбер равное значению (max_n - current_n - 1). По факту
запускается цикл с количеством итераций равным количеству вершин и на каждой итерации запускается ещё один цикл
с количеством итераций равным (n - i - 1). Сложность построения графа можно округлить до O(n^2).

Проверка графа на оптимальность проводится также за O(n * (n - 1)), т.к. цикл проходит по каждой вершине и на каждой
итерации обрабатывает все другие вершины. Также можно округлить до O(n^2).

Итоговая сложность алгоритма O(n^2).

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Для хранения графа используется коллекция коллекций и их размер квадратично зависит от количества вершин. Коллекция
верхнего уровня всегда равна размером количеству вершин (здесь опускается автоматическое увеличение коллекции
и её аллокация). Во вложенных коллекциях хранится список вершин, доступных из текущей вершины. Поэтому для хранения
графа требуется O(n^2) памяти.

Для проверки оптимальности графа вводится две дополнительных структуры - массив цветов и стэк. Обе эти структуры равны
количеству вершин в графе (массив в любом случае, стэк - в худшем), поэтому они займут дополнительно O(2n) памяти, что
можно округлить до O(n).

Итоговая сложность алгоритма будет O(n^2 + 2n), что можно округлить до O(n^2).
 */
public class Railway {
    private static final String YES = "YES";
    private static final String NO = "NO";

    private static List<List<Integer>> graph;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            buildGraph(reader);
            boolean isOptimal = checkOptimal();
            writer.write(isOptimal ? YES : NO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void buildGraph(BufferedReader reader) throws IOException {
        int vertexCount = Integer.parseInt(reader.readLine());
        graph = new ArrayList<>(vertexCount);

        for (int i = 0; i < vertexCount; i++) {
            graph.add(new ArrayList<>());
        }

        String str;
        for (int i = 0; i < vertexCount - 1; i++) {
            str = reader.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'R') {
                    graph.get(i).add(i + j + 1);
                } else {
                    graph.get(i + j + 1).add(i);
                }
            }
        }
    }

    private static boolean checkOptimal() {
        Color[] visited = new Color[graph.size()];
        Arrays.fill(visited, Color.WHITE);

        int current;
        Deque<Integer> stack;
        for (int i = 0; i < graph.size(); i++) {
            if (visited[i] != Color.WHITE) {
                continue;
            }

            stack = new ArrayDeque<>();
            stack.push(i);

            while (!stack.isEmpty()) {
                current = stack.peek();
                if (visited[current] == Color.WHITE) {
                    visited[current] = Color.GRAY;

                    for (int vertex : graph.get(current)) {
                        if (visited[vertex] == Color.WHITE) {
                            stack.push(vertex);
                        } else if (visited[vertex] == Color.GRAY) {
                            return false;
                        }
                    }
                } else {
                    visited[current] = Color.BLACK;
                    stack.pop();
                }
            }
        }

        return true;
    }
}

enum Color {
    WHITE,
    GRAY,
    BLACK
}
