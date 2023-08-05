package sprint4.task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class Sections3 {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            Map<String, Boolean> map = saveSections(reader);
            for (String s : map.keySet()) {
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, Boolean> saveSections(BufferedReader reader) throws IOException {
        int length = Integer.parseInt(reader.readLine());
        Map<String, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(reader.readLine(), Boolean.TRUE);
        }

        return map;
    }
}
