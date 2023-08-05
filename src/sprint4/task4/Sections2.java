package sprint4.task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;
import java.util.Set;

public class Sections2 {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            Set<String> set = saveSections(reader);
            for (String s : set) {
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Set<String> saveSections(BufferedReader reader) throws IOException {
        int length = Integer.parseInt(reader.readLine());
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(reader.readLine());
        }

        return set;
    }
}
