package sprint3.task15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DiffOfTrashIndexes {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int[] sizes = getSizes(reader);
            int k = Integer.parseInt(reader.readLine());
            int diff = getDiff(sizes, k);
            writer.write(String.valueOf(diff));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] getSizes(BufferedReader reader) throws IOException {
        int length = Integer.parseInt(reader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        int[] sizes = new int[length];
        for (int i = 0; i < length; i++) {
            sizes[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return sizes;
    }

    private static int getDiff(int[] sizes, int k) {
        Arrays.sort(sizes);
        int i = k / sizes.length;

        return sizes[i + sizes.length % k] - sizes[i];
    }
}
