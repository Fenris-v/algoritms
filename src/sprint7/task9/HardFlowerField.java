package sprint7.task9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HardFlowerField {
    private static final char R = 'R';
    private static final char U = 'U';

    private static byte[][] matrix;
    private static int[][] cache;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int rows = Integer.parseInt(stringTokenizer.nextToken());
            int columns = Integer.parseInt(stringTokenizer.nextToken());

            matrix = new byte[rows][columns];
            cache = new int[rows + 2][columns + 2];

            String str;
            for (int i = 0; i < rows; i++) {
                str = reader.readLine();
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = (byte) (str.charAt(j) == '1' ? 1 : 0);
                }
            }

            int maxFlowerOnWay = getMaxFlowerOnWay();
            List<Character> path = getPath();

            writer.write(maxFlowerOnWay + "\n");
            for (Character c : path) {
                writer.write(c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getMaxFlowerOnWay() {
        for (int i = matrix.length; i > 0; i--) {
            for (int j = 1; j <= matrix[0].length; j++) {
                cache[i][j] = Math.max(cache[i + 1][j], cache[i][j - 1]) + matrix[i - 1][j - 1];
            }
        }

        return cache[1][matrix[0].length];
    }

    private static List<Character> getPath() {
        List<Character> path = new ArrayList<>();
        int y = 1;
        int x = matrix[0].length;
        while (y < matrix.length || x > 1) {
            if (y > matrix.length - 1) {
                path.add(R);
                x--;
            } else if (x == 1) {
                path.add(U);
                y++;
            } else if (cache[y][x - 1] < cache[y + 1][x]) {
                path.add(R);
                x--;
            } else if (matrix[y - 1][x - 2] < matrix[y][x - 1]) {
                path.add(R);
                x--;
            } else {
                path.add(U);
                y++;
            }
        }

        return path;
    }
}
