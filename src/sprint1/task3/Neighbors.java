package sprint1.task3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Neighbors {
    private static int rows;
    private static int columns;
    private static int[][] matrix;

    public static void main(String[] args) {
        findNeighbors();
    }

    private static void findNeighbors() {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            initValues(reader);

            int y = Integer.parseInt(reader.readLine());
            int x = Integer.parseInt(reader.readLine());

            printResult(writer, getNeighbors(y, x));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initValues(BufferedReader reader) throws IOException {
        rows = Integer.parseInt(reader.readLine());
        columns = Integer.parseInt(reader.readLine());

        matrix = new int[rows][columns];
        StringTokenizer stringTokenizer;
        for (int i = 0; i < rows; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static List<Integer> getNeighbors(int y, int x) {
        List<Integer> result = new ArrayList<>();
        if (x > 0) {
            result.add(matrix[y][x - 1]);
        }

        if (y > 0) {
            result.add(matrix[y - 1][x]);
        }

        if (x < columns - 1) {
            result.add(matrix[y][x + 1]);
        }

        if (y < rows - 1) {
            result.add(matrix[y + 1][x]);
        }

        result.sort(Comparator.comparingInt(i -> i));
        return result;
    }

    private static void printResult(BufferedWriter writer, List<Integer> result) throws IOException {
        String str = result.stream().map(String::valueOf).collect(Collectors.joining(" "));
        writer.write(str);
    }
}
