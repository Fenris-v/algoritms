package sprint4.task12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class MultiGosha {
    private static final long BASIS = 1000;
    private static final long MODULE = 123987123;
    private static long[] powers;
    private static long[] hashes;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int length = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            byte[] bytes = reader.readLine().getBytes();
            calculatePowers(bytes.length);
            calculatePrefixHashes(bytes);
            List<Integer> results = getResults(length, k, bytes);
            writer.write(results.stream().map(String::valueOf).collect(Collectors.joining(" ")) + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void calculatePowers(int length) {
        powers = new long[length + 1];
        powers[0] = 1;
        for (int i = 1; i <= length; i++) {
            powers[i] = (powers[i - 1] * BASIS) % MODULE;
        }
    }

    private static void calculatePrefixHashes(byte[] bytes) {
        hashes = new long[bytes.length + 1];
        for (int i = 0; i < bytes.length; i++) {
            hashes[i + 1] = (hashes[i] * BASIS + bytes[i]) % MODULE;
        }
    }

    private static List<Integer> getResults(int length, int count, byte[] bytes) {
        List<Integer> indexes = new ArrayList<>();
        Set<Integer> exceptIndexes = new HashSet<>();
        long desiredHash;
        int index;
        int repetition;
        for (int i = 0; i < bytes.length - length; i++) {
            if (exceptIndexes.contains(i)) {
                continue;
            }

            repetition = 1;
            desiredHash = getHash(i + length, i + 1);
            for (int j = i + 1; j < bytes.length - length; j++) {
                long hash = getHash(j + length, j + 1);
                if (bytes[i] != bytes[j]) {
                    continue;
                } else if (desiredHash != hash) {
                    continue;
                }

                index = j + 1;
                repetition++;
                for (int m = i + 1; m < i + length; m++) {
                    if (bytes[m] == bytes[index++]) {
                        continue;
                    }

                    repetition--;
                    break;
                }

                exceptIndexes.add(j);
            }

            if (repetition >= count) {
                indexes.add(i);
            }
        }

        return indexes;
    }

    private static long getHash(int right, int left) {
        return (hashes[right] - hashes[left - 1] * powers[right - left + 1] % MODULE + MODULE) % MODULE;
    }
}
