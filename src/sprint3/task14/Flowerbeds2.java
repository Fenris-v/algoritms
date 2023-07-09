package sprint3.task14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Flowerbeds2 {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int[][] values = getValues(reader);
            List<int[]> flowerbeds = getFlowerbeds(values);
            flowerbeds.forEach(flowerbed -> print(writer, flowerbed));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] getValues(BufferedReader reader) throws IOException {
        int length = Integer.parseInt(reader.readLine());
        int[][] values = new int[length][2];
        StringTokenizer stringTokenizer;
        for (int i = 0; i < length; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 2; j++) {
                values[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        return Arrays.stream(values).sorted(Comparator.comparingInt(o -> o[0])).toArray(int[][]::new);
    }

    private static List<int[]> getFlowerbeds(int[][] values) {
        List<int[]> flowerbeds = new ArrayList<>();
        flowerbeds.add(values[0]);

        int last = 0;
        for (int i = 1; i < values.length; i++) {
            if (flowerbeds.get(last)[1] < values[i][0]) {
                flowerbeds.add(values[i]);
                last++;
            } else {
                flowerbeds.get(last)[1] = Math.max(values[i][1], flowerbeds.get(last)[1]);
            }
        }

        return flowerbeds;
    }

    private static void print(BufferedWriter writer, int[] flowerbed) {
        try {
            writer.write(Arrays.stream(flowerbed).mapToObj(String::valueOf).collect(Collectors.joining(" ")) + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
