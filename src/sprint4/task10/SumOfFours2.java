package sprint4.task10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SumOfFours2 {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int length = Integer.parseInt(reader.readLine());
            int number = Integer.parseInt(reader.readLine());
            int[] values = new int[length];
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < length; i++) {
                values[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            Set<Fours2> results = getSumOfFours(number, values);
            writer.write(results.size() + "\n");
            for (Fours2 result : results) {
                writer.write(
                        Arrays.stream(result.getValues()).mapToObj(String::valueOf).collect(Collectors.joining(" ")) +
                                "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Set<Fours2> getSumOfFours(int number, int[] values) {
        Set<Integer> history = new HashSet<>();
        Set<Fours2> results = new TreeSet<>();
        int n = values.length;
        int target;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    target = number - values[k] - values[j] - values[i];
                    if (history.contains(target)) {
                        results.add(new Fours2(target, values[i], values[j], values[k]));
                    }
                }
            }

            history.add(values[i]);
        }

        return results;
    }
}

class Fours2 implements Comparable<Fours2> {
    private final int[] values;

    public Fours2(int i, int j, int k, int m) {
        values = new int[]{i, j, k, m};
        Arrays.sort(values);
    }

    public int[] getValues() {
        return values;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Fours2 && Arrays.equals(values, ((Fours2) obj).getValues());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public int compareTo(Fours2 o) {
        return Arrays.compare(values, o.getValues());
    }
}
