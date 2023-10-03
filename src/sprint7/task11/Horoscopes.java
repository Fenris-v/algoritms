package sprint7.task11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Horoscopes {
    private static List<Integer> firstIndexes;
    private static List<Integer> secondIndexes;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int[] first = parseString(Integer.parseInt(reader.readLine()), reader.readLine());
            int[] second = parseString(Integer.parseInt(reader.readLine()), reader.readLine());

            int[][] dp = buildDp(first, second);
            writer.write(dp[first.length][second.length] + "\n");
            findIndexes(first, second, dp);
            if (!firstIndexes.isEmpty()) {
                writer.write(firstIndexes.stream().map(String::valueOf).collect(Collectors.joining(" ")) + "\n");
                writer.write(secondIndexes.stream().map(String::valueOf).collect(Collectors.joining(" ")) + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] parseString(int length, String str) {
        int[] result = new int[length];
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        for (int i = 0; i < length; i++) {
            result[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return result;
    }

    private static int[][] buildDp(int[] first, int[] second) {
        int[][] dp = new int[first.length + 1][second.length + 1];
        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {
                if (first[i - 1] != second[j - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    continue;
                }

                dp[i][j] = dp[i - 1][j - 1] + 1;
            }
        }

        return dp;
    }

    private static void findIndexes(int[] first, int[] second, int[][] dp) {
        firstIndexes = new ArrayList<>();
        secondIndexes = new ArrayList<>();
        int i = dp.length - 1;
        int j = dp[0].length - 1;
        while (i > 0 && j > 0) {
            if (first[i - 1] == second[j - 1]) {
                if (dp[i][j] == dp[i - 1][j]) {
                    firstIndexes.add(i);
                    secondIndexes.add(j);
                } else {
                    firstIndexes.add(i);
                    secondIndexes.add(j);
                }

                i--;
                j--;
            } else {
                if (dp[i][j] == dp[i - 1][j]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        Collections.reverse(firstIndexes);
        Collections.reverse(secondIndexes);
    }
}
