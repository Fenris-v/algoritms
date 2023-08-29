package sprint6.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// Алла успешно справилась с предыдущим заданием, и теперь ей дали новое. На этот раз список рёбер ориентированного
// графа надо переводить в матрицу смежности. Конечно же, Алла попросила вас помочь написать программу для этого.
//
// Формат ввода
// В первой строке дано число вершин n (1 ≤ n ≤ 100) и число рёбер m (1 ≤ m ≤ n(n - 1)). В следующих m строках заданы
// ребра в виде пар вершин (u, v), если ребро ведет от u к v.
//
// Формат вывода
// Выведите матрицу смежности n на n. На пересечении i-й строки и j-го столбца стоит единица, если есть ребро,
// ведущее из i в j.
public class GraphInMatrixConverter {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int matrixSize = Integer.parseInt(tokenizer.nextToken());
            int ribCount = Integer.parseInt(tokenizer.nextToken());
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int i = 0; i < ribCount; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                matrix[Integer.parseInt(tokenizer.nextToken()) - 1][Integer.parseInt(tokenizer.nextToken()) - 1] = 1;
            }

            for (int[] row : matrix) {
                writer.write(Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")) + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
