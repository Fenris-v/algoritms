package sprint3.task13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GoldAverage {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int length1 = Integer.parseInt(reader.readLine());
            int length2 = Integer.parseInt(reader.readLine());
            int[] first = getValues(reader.readLine(), length1);
            int[] second = getValues(reader.readLine(), length2);
            double median = getMedian(first, second);
            if (median == (int) median) {
                writer.write((int) median + "\n");
            } else {
                writer.write(median + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getValues(String str, int length) {
        int[] arr = new int[length];
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return arr;
    }

    private static double getMedian(int[] arr1, int[] arr2) {
        return 0;
    }
}
