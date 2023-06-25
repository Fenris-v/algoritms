package sprint1.finaltask.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * id: 88514514
 */
public class HandsAgility {
    private static int maxSameTimePressedKeys;
    private static Map<Integer, Integer> sameValuesCountMap;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            sameValuesCountMap = new HashMap<>();
            initValueData(reader);
            writer.write(String.valueOf(countPossiblePoints()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initValueData(BufferedReader reader) throws IOException {
        maxSameTimePressedKeys = Integer.parseInt(reader.readLine()) * 2;

        String row;
        for (int i = 0; i < 4; i++) {
            row = reader.readLine();
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '.') {
                    continue;
                }

                int value = Integer.parseInt(String.valueOf(row.charAt(j)));
                if (sameValuesCountMap.containsKey(value)) {
                    sameValuesCountMap.put(value, sameValuesCountMap.get(value) + 1);
                } else {
                    sameValuesCountMap.put(value, 1);
                }
            }
        }
    }

    private static int countPossiblePoints() {
        int possiblePoints = 0;
        for (int t = 1; t < 10; t++) {
            if (!sameValuesCountMap.containsKey(t)) {
                continue;
            }

            if (sameValuesCountMap.get(t) <= maxSameTimePressedKeys) {
                possiblePoints++;
            }
        }

        return possiblePoints;
    }
}
