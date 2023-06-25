package sprint1.finaltask.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * id: 88506397
 */
public class NearestZero {
    private static int[] map;

    public static void main(String[] args) {
        calculateDistance();
    }

    private static void calculateDistance() {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int[] addresses = getInputData(reader);
            int[] map = buildMap(addresses);
            writer.write(Arrays.stream(map).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getInputData(BufferedReader reader) throws IOException {
        int length = Integer.parseInt(reader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

        int[] addresses = new int[length];
        for (int i = 0; i < length; i++) {
            addresses[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return addresses;
    }

    private static int[] buildMap(int[] addresses) {
        map = new int[addresses.length];
        int zeroIndex = getFirstZeroIndex(addresses);
        for (int i = 0; i < zeroIndex; i++) {
            map[i] = zeroIndex - i;
        }

        int prevZeroIndex = zeroIndex++;
        while (zeroIndex < addresses.length) {
            if (addresses[zeroIndex] == 0) {
                buildMapBetweenIndexes(prevZeroIndex, zeroIndex);
                prevZeroIndex = zeroIndex;
            }

            zeroIndex++;
        }

        for (int i = prevZeroIndex; i < addresses.length; i++) {
            map[i] = i - prevZeroIndex;
        }

        return map;
    }

    private static int getFirstZeroIndex(int[] addresses) {
        int index = 0;
        while (addresses[index] != 0) {
            index++;
        }

        return index;
    }

    private static void buildMapBetweenIndexes(int prevZeroIndex, int zeroIndex) {
        int distance = zeroIndex - prevZeroIndex;
        int halfDistance = distance / 2;
        for (int i = 1; i <= halfDistance; i++) {
            map[prevZeroIndex + i] = i;
            map[zeroIndex - i] = i;
        }
    }
}
