package sprint7.task10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Travel {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int length = Integer.parseInt(reader.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int[] rating = new int[length];
            for (int i = 0; i < length; i++) {
                rating[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            List<Integer> sequence = findSequence(rating);
            writer.write(sequence.size() + "\n");
            writer.write(sequence.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Integer> findSequence(int[] rating) {
        List<Integer> sequence = new ArrayList<>();
        if (rating.length == 1) {
            sequence.add(1);
            return sequence;
        }

        int[] dp = new int[rating.length];
        Arrays.fill(dp, 1);
        int maxIndex = 0;
        for (int j = 1; j < rating.length; j++) {
            for (int i = 0; i < j; i++) {
                if (rating[j] > rating[i]) {
                    if (dp[j] <= dp[i]) {
                        dp[j] = dp[i] + 1;
                        if (dp[j] > dp[maxIndex]) {
                            maxIndex = j;
                        }
                    }
                }
            }
        }

        int prev = maxIndex;
        sequence.add(maxIndex + 1);
        for (int i = maxIndex - 1; i >= 0; i--) {
            if (dp[i] + 1 == dp[prev] && rating[i] < rating[prev]) {
                sequence.add(i + 1);
                prev = i;
            }

            if (dp[prev] == 1) {
                break;
            }
        }

        Collections.reverse(sequence);
        return sequence;
    }
}
