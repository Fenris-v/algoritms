package sprint1.task12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ExtraLetter {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String source = reader.readLine();
            String changed = reader.readLine();
            char result = findDiff(source, changed);
            writer.write(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static char findDiff(String source, String changed) {
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < source.length(); i++) {
            chars.add(source.charAt(i));
        }

        Character c;
        for (int i = 0; i < changed.length(); i++) {
            c = changed.charAt(i);
            if (chars.contains(c)) {
                chars.remove(c);
            } else {
                return changed.charAt(i);
            }
        }

        return changed.charAt(changed.length() - 1);
    }
}
