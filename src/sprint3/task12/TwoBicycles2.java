package sprint3.task12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TwoBicycles2 {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int arraySize = Integer.parseInt(reader.readLine());
            int[] values = getValues(reader.readLine(), arraySize);
            int price = Integer.parseInt(reader.readLine());
            int day = getDayByBinarySearch(price, values, 0, values.length);
            int day2 = day == -1 ? -1 : getDayByBinarySearch(price * 2, values, day - 1, values.length);

            writer.write(day + " " + day2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getDayByBinarySearch(int price, int[] values, int left, int right) {
        if (left >= right) {
            return -1;
        }

        int middle = (right + left) / 2;
        if (values[middle] >= price && middle > 0 && values[middle - 1] < price || middle == 0) {
            return middle + 1;
        }

        if (price <= values[middle]) {
            return getDayByBinarySearch(price, values, left, middle);
        }

        return getDayByBinarySearch(price, values, middle + 1, right);
    }

    private static int[] getValues(String str, int arraySize) {
        int[] values = new int[arraySize];
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        for (int i = 0; i < arraySize; i++) {
            values[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return values;
    }
}
