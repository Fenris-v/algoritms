package sprint4.task10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SumOfFours3 {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int length = Integer.parseInt(reader.readLine());
            long number = Integer.parseInt(reader.readLine());
            long[] values = new long[length];
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < length; i++) {
                values[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            Set<Fours3> results = getSumOfFours(number, values);
            writer.write(results.size() + "\n");
            for (Fours3 result : results) {
                writer.write(
                        Arrays.stream(result.getValues()).mapToObj(String::valueOf).collect(Collectors.joining(" ")) +
                                "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Set<Fours3> getSumOfFours(long number, long[] values) {
        Map<Long, List<Pair>> pairs = new HashMap<>();
        Set<Fours3> results = new TreeSet<>();
        long target;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                target = number - values[j] - values[i];
                if (pairs.containsKey(target)) {
                    for (Pair pair : pairs.get(target)) {
                        if (i != pair.getI() && i != pair.getJ() && j != pair.getJ() && j != pair.getI()) {
                            results.add(new Fours3(values[j], values[i], values[pair.getI()], values[pair.getJ()]));
                        }
                    }
                }

                pairs.putIfAbsent(values[i] + values[j], new ArrayList<>());
                pairs.get(values[i] + values[j]).add(new Pair(i, j));
            }
        }

        return results;
    }
}

class Fours3 implements Comparable<Fours3> {
    private final long[] values;

    public Fours3(long i, long j, long k, long m) {
        values = new long[]{i, j, k, m};
        Arrays.sort(values);
    }

    public long[] getValues() {
        return values;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Fours3 && Arrays.equals(values, ((Fours3) obj).getValues());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public int compareTo(Fours3 o) {
        return Arrays.compare(values, o.getValues());
    }
}

class Pair {
    private final int i;
    private final int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
