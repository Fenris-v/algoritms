package sprint7.task6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class StairJumping {
    private static final int MOD = 1000000007;
    private static long[] cache;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int stepCount = Integer.parseInt(stringTokenizer.nextToken());
            int maxJump = Integer.parseInt(stringTokenizer.nextToken());
            cache = new long[stepCount + 1];

            long combinationsCount = countAvailableCombinations(stepCount, maxJump);
            writer.write(String.valueOf(combinationsCount));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long countAvailableCombinations(int stepCount, int maxJump) {
        if (stepCount < 1) {
            return 0;
        } else if (stepCount == 1) {
            return 1;
        }

        if (cache[stepCount] != 0) {
            return cache[stepCount] % MOD;
        }

        for (int i = 1; i <= maxJump; i++) {
            cache[stepCount] += countAvailableCombinations(stepCount - i, maxJump) % MOD;
        }

        return cache[stepCount] % MOD;
    }
}
