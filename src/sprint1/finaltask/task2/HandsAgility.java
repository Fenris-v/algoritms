package sprint1.finaltask.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * id: 88583307
 */
public class HandsAgility {
    private static int maxSameTimePressedKeys;
    private static int[] sameValuesArray;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            sameValuesArray = new int[9];
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

                int value = Character.digit(row.charAt(j), 10);
                sameValuesArray[value - 1]++;
            }
        }
    }

    private static int countPossiblePoints() {
        int possiblePoints = 0;
        for (int t = 0; t < 9; t++) {
            if (sameValuesArray[t] == 0) {
                continue;
            }

            if (sameValuesArray[t] <= maxSameTimePressedKeys) {
                possiblePoints++;
            }
        }

        return possiblePoints;
    }
}
