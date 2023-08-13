package sprint4.task3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PrefixHash2 {
    private static int basis;
    private static int module;
    private static long[] powers;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            basis = Integer.parseInt(reader.readLine());
            module = Integer.parseInt(reader.readLine());
            byte[] bytes = reader.readLine().getBytes();
            powers = getPowers(basis, module, bytes.length);

            long[] prefixHashes = getPrefixHashes(bytes);

            int commandCount = Integer.parseInt(reader.readLine());
            StringTokenizer stringTokenizer;
            long hash;
            int right;
            int left;
            for (int i = 0; i < commandCount; i++) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                left = Integer.parseInt(stringTokenizer.nextToken());
                right = Integer.parseInt(stringTokenizer.nextToken());
                hash = getHash(prefixHashes, right, left);
                writer.write(hash + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long[] getPowers(int basis, int module, int length) {
        long[] powers = new long[length + 1];
        powers[0] = 1;
        for (int i = 1; i <= length; i++) {
            powers[i] = (powers[i - 1] * basis) % module;
        }

        return powers;
    }

    private static long[] getPrefixHashes(byte[] bytes) {
        long[] hashes = new long[bytes.length + 1];
        for (int i = 0; i < bytes.length; i++) {
            hashes[i + 1] = (hashes[i] * basis + bytes[i]) % module;
        }

        return hashes;
    }

    private static long getHash(long[] prefixHashes, int right, int left) {
        return (prefixHashes[right] - prefixHashes[left - 1] * powers[right - left + 1] % module + module) % module;
    }
}
