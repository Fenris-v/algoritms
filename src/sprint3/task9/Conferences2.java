package sprint3.task9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Conferences2 {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int[] students = getStudents(reader);
            int k = Integer.parseInt(reader.readLine());
            int[] popularityUniversity = getPopularityUniversity(k, students);
            writer.write(Arrays.stream(popularityUniversity)
                               .mapToObj(String::valueOf)
                               .collect(Collectors.joining(" ")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getStudents(BufferedReader reader) throws IOException {
        int length = Integer.parseInt(reader.readLine());
        int[] students = new int[length];
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < length; i++) {
            students[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return students;
    }

    private static int[] getPopularityUniversity(int k, int[] students) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int student : students) {
            map.put(student, map.getOrDefault(student, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> universities = new ArrayList<>(map.entrySet());
        CustomComparator comparator = new CustomComparator();
        universities.sort(comparator);

        int[] popularityUniversities = new int[k];
        for (int i = 0; i < k; i++) {
            popularityUniversities[i] = universities.get(i).getKey();
        }

        return popularityUniversities;
    }
}

class CustomComparator implements Comparator<Map.Entry<Integer, Integer>> {
    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        if (o1.getValue().equals(o2.getValue())) {
            return o1.getKey() - o2.getKey();
        }

        return o2.getValue() - o1.getValue();
    }
}
