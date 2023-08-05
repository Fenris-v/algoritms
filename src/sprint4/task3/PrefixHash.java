package sprint4.task3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PrefixHash {
    private static int basis;
    private static int module;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            basis = Integer.parseInt(reader.readLine());
            module = Integer.parseInt(reader.readLine());
            byte[] bytes = reader.readLine().getBytes();
            int commandCount = Integer.parseInt(reader.readLine());
            StringTokenizer stringTokenizer;
            long hash;
            for (int i = 0; i < commandCount; i++) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                hash = hash(bytes,
                            Integer.parseInt(stringTokenizer.nextToken()) - 1,
                            Integer.parseInt(stringTokenizer.nextToken()));
                writer.write(hash + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long hash(byte[] bytes, int from, int to) {
        int length = from - to;
        long hash = length > 1 ? (long) bytes[from++] * basis % module : 0;
        while (from < to - 1) {
            hash = (hash + bytes[from]) * basis % module;
            from++;
        }

        return (hash + bytes[to - 1]) % module;
    }
}
