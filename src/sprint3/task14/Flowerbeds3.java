package sprint3.task14;

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

public class Flowerbeds3 {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            List<int[]> values = getValues(reader);
            List<int[]> flowerbeds = getFlowerbeds(values);
            flowerbeds.forEach(flowerbed -> print(writer, flowerbed));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<int[]> getValues(BufferedReader reader) throws IOException {
        int start;
        int length = Integer.parseInt(reader.readLine());
        List<int[]> values = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        values.add(new int[]{
                Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())
        });

        for (int i = 1; i < length; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            start = Integer.parseInt(stringTokenizer.nextToken());
            int index = getIndexForInsert(values, start, 0, i);
            values.add(index, new int[]{start, Integer.parseInt(stringTokenizer.nextToken())});
        }

        return values;
    }

    private static int getIndexForInsert(List<int[]> values, int value, int left, int right) {
        int mid = (right - left) / 2 + left;
        if (values.get(mid)[0] == value) {
            return mid;
        } else if (values.get(mid)[0] > value) {
            if (values.get(mid)[0] < value) {
                return mid;
            } else if (mid == 0) {
                return 0;
            }

            return getIndexForInsert(values, value, left, mid);
        } else if (values.get(mid)[0] < value) {
            if (values.size() == mid + 1 || values.get(mid + 1)[0] > value) {
                return mid + 1;
            }

            return getIndexForInsert(values, value, mid, right);
        }

        return right;
    }

    private static List<int[]> getFlowerbeds(List<int[]> values) {
        List<int[]> flowerbeds = new ArrayList<>();
        flowerbeds.add(values.get(0));

        int last = 0;
        for (int i = 1; i < values.size(); i++) {
            if (flowerbeds.get(last)[1] < values.get(i)[0]) {
                flowerbeds.add(values.get(i));
                last++;
            } else {
                flowerbeds.get(last)[1] = Math.max(values.get(i)[1], flowerbeds.get(last)[1]);
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
