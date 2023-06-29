package sprint2.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Алла получила задание, связанное с мониторингом работы различных серверов. Требуется понять, сколько времени
// обрабатываются определённые запросы на конкретных серверах. Эту информацию нужно хранить в матрице, где номер столбца
// соответствуют идентификатору запроса, а номер строки — идентификатору сервера. Алла перепутала строки и столбцы
// местами. С каждым бывает. Помогите ей исправить баг.
//
// Есть матрица размера m × n. Нужно написать функцию, которая её транспонирует.
// Транспонированная матрица получается из исходной заменой строк на столбцы.
//
// Формат ввода
// В первой строке задано число n — количество строк матрицы.
// Во второй строке задано m — число столбцов, m и n не превосходят 1000. В следующих n строках задана матрица. Числа
// в ней не превосходят по модулю 1000.
//
// Формат вывода
// Напечатайте транспонированную матрицу в том же формате, который задан во входных данных. Каждая строка матрицы
// выводится на отдельной строке, элементы разделяются пробелами.
public class Monitoring {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String[][] matrix = getMatrix(reader);
            if (matrix == null) {
                writer.write("");
                return;
            }

            String[][] resultMatrix = modifyMatrix(matrix);
            printMatrix(writer, resultMatrix);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[][] getMatrix(BufferedReader reader) throws IOException {
        int rows = Integer.parseInt(reader.readLine());
        int columns = Integer.parseInt(reader.readLine());
        if (rows == 0 || columns == 0) {
            return null;
        }

        String[][] matrix = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = stringTokenizer.nextToken();
            }
        }

        return matrix;
    }

    private static String[][] modifyMatrix(String[][] matrix) {
        String[][] resultMatrix = new String[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                resultMatrix[j][i] = matrix[i][j];
            }
        }

        return resultMatrix;
    }

    private static void printMatrix(BufferedWriter writer, String[][] matrix) throws IOException {
        for (String[] strings : matrix) {
            writer.write(String.join(" ", strings) + "\n");
        }
    }
}
