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
        int[] map = new int[addresses.length];
        int zeroIndex = -addresses.length;
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i] == 0) {
                map[i] = 0;
                zeroIndex = i;
            } else {
                map[i] = i - zeroIndex;
            }
        }

        zeroIndex = addresses.length * 2;
        for (int i = addresses.length - 1; i >= 0; i--) {
            if (addresses[i] == 0) {
                zeroIndex = i;
            } else {
                map[i] = Math.min(zeroIndex - i, map[i]);
            }
        }

        return map;
    }
}
