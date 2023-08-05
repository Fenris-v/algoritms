package sprint4.task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// В компании, где работает Тимофей, заботятся о досуге сотрудников и устраивают различные кружки по интересам. Когда
// кто-то записывается на занятие, в лог вносится название кружка.
// По записям в логе составьте список всех кружков, в которые ходит хотя бы один человек.
//
// Формат ввода
// В первой строке даётся натуральное число n, не превосходящее 10 000 –— количество записей в логе.
// В следующих n строках —– названия кружков.
//
// Формат вывода
// Выведите уникальные названия кружков по одному на строке, в порядке появления во входных данных.
public class Sections {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            List<String> list = saveSections(reader);
            for (String s : list) {
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> saveSections(BufferedReader reader) throws IOException {
        int length = Integer.parseInt(reader.readLine());
        List<String> list = new ArrayList<>();
        String str;
        for (int i = 0; i < length; i++) {
            str = reader.readLine();
            if (!list.contains(str)) {
                list.add(str);
            }
        }

        return list;
    }
}
