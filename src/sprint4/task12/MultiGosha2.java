package sprint4.task12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class MultiGosha2 {
    private static final long BASIS = 1000;
    private static final long MODULE = 123987123;
    private static Map<Long, List<Integer>> hashes;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int length = Integer.parseInt(stringTokenizer.nextToken());
            int count = Integer.parseInt(stringTokenizer.nextToken());
            byte[] bytes = reader.readLine().getBytes();
            calculatePrefixHashes(bytes, length);
            List<Integer> results = getResults(length, count, bytes);
            writer.write(results.stream().map(String::valueOf).collect(Collectors.joining(" ")) + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void calculatePrefixHashes(byte[] bytes, int length) {
        long hash;
        hashes = new HashMap<>();
        for (int i = 0; i < bytes.length - length; i++) {
            hash = (long) bytes[i] * BASIS % MODULE;
            for (int j = i; j < i + length - 1; j++) {
                hash = (hash + bytes[j]) * BASIS % MODULE;
            }

            hash = (hash + bytes[i + length - 1]) % MODULE;
            hashes.putIfAbsent(hash, new ArrayList<>());
            hashes.get(hash).add(i);
        }
    }

    private static List<Integer> getResults(int length, int count, byte[] bytes) {
        List<Integer> indexes = new ArrayList<>();
        //        List<Integer> checkAgain;
        for (Map.Entry<Long, List<Integer>> entry : hashes.entrySet()) {
            if (entry.getValue().size() < count) {
                continue;
            }

            //            checkAgain = new ArrayList<>();
            //            for (int i = entry.getValue().get(0); i < bytes.length; i ++) {
            //                for (int j = 1; j<)
            //            }

            indexes.add(entry.getValue().get(0));
        }

        return indexes;
    }
}
