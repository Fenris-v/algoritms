package sprint5.task9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Ребятам стало интересно, сколько может быть различных деревьев поиска, содержащих в своих узлах все уникальные числа
// от 1 до n. Помогите им найти ответ на этот вопрос.
//
// Формат ввода
// В единственной строке задано число n. Оно не превосходит 15.
//
// Формат вывода
// Нужно вывести число, равное количеству различных деревьев поиска, в узлах которых могут быть размещены числа
// от 1 до n включительно.
public class DifferentSearchTrees {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int nodeCount = Integer.parseInt(reader.readLine());
            int treeCount = countTrees(nodeCount);
            writer.write(String.valueOf(treeCount));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int countTrees(int nodeCount) {
        if (nodeCount == 0) {
            return 0;
        }

        int count = 1;
        for (int i = 1; i <= nodeCount; i++) {
            count = (count * (2 * (2 * i - 1))) / (i + 1);
        }

        return count;
    }
}
