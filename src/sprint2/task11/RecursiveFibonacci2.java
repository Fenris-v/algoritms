package sprint2.task11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RecursiveFibonacci2 {
    private static int[] result;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int count = Integer.parseInt(reader.readLine());
            result = new int[count + 1];
            int fibonacci = getFibonacci(count);
            writer.write(String.valueOf(fibonacci));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getFibonacci(int count) {
        if (count < 2) {
            result[count] = 1;
            return 1;
        }

        int prev = result[count - 1] == 0 ? getFibonacci(count - 1) : result[count - 1];
        int prev2 = result[count - 2] == 0 ? getFibonacci(count - 2) : result[count - 2];

        return prev + prev2;
    }
}
