package sprint7.task12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LeprechaunGold {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int goldBarCount = Integer.parseInt(stringTokenizer.nextToken());
            int backpackVolume = Integer.parseInt(stringTokenizer.nextToken());
            int[] items = new int[goldBarCount];
            stringTokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < goldBarCount; i++) {
                items[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int maxGoldVolume = getMaxGoldVolume(items, backpackVolume);
            writer.write(String.valueOf(maxGoldVolume));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getMaxGoldVolume(int[] items, int backpackVolume) {
        int[][] dp = new int[items.length][backpackVolume + 1];
        for (int i = items[0]; i <= backpackVolume; i++) {
            dp[0][i] = items[0];
        }

        for (int i = 1; i < items.length; i++) {
            for (int j = 1; j <= backpackVolume; j++) {
                if (items[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }

                dp[i][j] = items[i] + dp[i - 1][j - items[i]];
                if (dp[i - 1][j] > dp[i][j]) {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[items.length - 1][backpackVolume];
    }
}
