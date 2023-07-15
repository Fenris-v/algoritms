package sprint3.task9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// На IT-конференции присутствовали студенты из разных вузов со всей страны. Для каждого студента известен ID
// университета, в котором он учится.
// Тимофей предложил Рите выяснить, из каких k вузов на конференцию пришло больше всего учащихся.
//
// Формат ввода
// В первой строке дано количество студентов в списке — n (1 ≤ n ≤ 15 000).
// Во второй строке через пробел записаны n целых чисел — ID вуза каждого студента. Каждое из чисел находится в
// диапазоне от 0 до 10 000.
// В третьей строке записано одно число k.
//
// Формат вывода
// Выведите через пробел k ID вузов с максимальным числом участников. Они должны быть отсортированы по убыванию
// популярности (по количеству гостей от конкретного вуза). Если более одного вуза имеет одно и то же количество
// учащихся, то выводить их ID нужно в порядке возрастания.
public class Conferences {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            List<University> universities = getUniversityIds(reader);
            int k = Integer.parseInt(reader.readLine());
            int[] popularityUniversity = getPopularityUniversity(k, universities);
            writer.write(Arrays.stream(popularityUniversity)
                               .mapToObj(String::valueOf)
                               .collect(Collectors.joining(" ")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<University> getUniversityIds(BufferedReader reader) throws IOException {
        int id;
        int index = -1;
        int length = Integer.parseInt(reader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        List<University> universities = new ArrayList<>();
        universities.add(new University(Integer.parseInt(stringTokenizer.nextToken())));
        for (int i = 1; i < length; i++) {
            id = Integer.parseInt(stringTokenizer.nextToken());
            for (int j = 0; j < universities.size(); j++) {
                if (id == universities.get(j).getId()) {
                    index = j;
                    break;
                }
            }

            if (index >= 0) {
                universities.get(index).incrementStudentsCount();
                index = -1;
            } else {
                universities.add(new University(id));
            }
        }

        return universities.stream().sorted().collect(Collectors.toList());
    }

    private static int[] getPopularityUniversity(int k, List<University> universities) {
        int[] ids = new int[k];
        for (int i = 0; i < k; i++) {
            ids[i] = universities.get(i).getId();
        }

        return ids;
    }
}

class University implements Comparable<University> {
    private final int id;
    private int studentsCount;

    public University(int id) {
        this.id = id;
        studentsCount = 1;
    }

    public int getId() {
        return id;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void incrementStudentsCount() {
        studentsCount++;
    }

    @Override
    public int compareTo(University university) {
        if (studentsCount == university.getStudentsCount()) {
            return id - university.getId();
        }

        return university.getStudentsCount() - studentsCount;
    }
}
