package sprint4.task6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// Вася решил избавиться от проблем с произношением и стать певцом. Он обратился за помощью к логопеду. Тот посоветовал
// Васе выполнять упражнение, которое называется анаграммная группировка. В качестве подготовительного этапа нужно
// выбрать из множества строк анаграммы.
// Анаграммы — это строки, которые получаются друг из друга перестановкой символов. Например, строки «SILENT» и «LISTEN»
// являются анаграммами.
// Помогите Васе найти анаграммы.
//
// Формат ввода
// В первой строке записано число n — количество строк.
// Далее в строку через пробел записаны n строк.
// n не превосходит 6000. Длина каждой строки не более 100 символов.
//
// Формат вывода
// Нужно вывести в отсортированном порядке индексы строк, которые являются анаграммами.
// Каждая группа индексов должна быть выведена в отдельной строке. Индексы внутри одной группы должны быть отсортированы
// по возрастанию. Группы между собой должны быть отсортированы по возрастанию первого индекса.
// Обратите внимание, что группа анаграмм может состоять и из одной строки. Например, если в исходном наборе нет
// анаграмм, то надо вывести n групп, каждая из которых состоит из одного индекса.
public class AnagramGrouping {
    static byte[][] bytes;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            Set<List<Integer>> groups = getGroups(reader);
            writer.write(buildResponse(groups));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Set<List<Integer>> getGroups(BufferedReader reader) throws IOException {
        int wordCount = Integer.parseInt(reader.readLine());
        bytes = new byte[wordCount][];
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        Map<Integer, PseudoHashEntries> anagramMap = new HashMap<>();
        int pseudoHash;
        for (int i = 0; i < wordCount; i++) {
            bytes[i] = stringTokenizer.nextToken().getBytes();
            pseudoHash = pseudoHash(bytes[i]);
            if (!anagramMap.containsKey(pseudoHash)) {
                anagramMap.put(pseudoHash, new PseudoHashEntries(i));
            } else {
                anagramMap.get(pseudoHash).addValue(bytes[i], i);
            }
        }

        return getGroups(anagramMap);
    }

    private static int pseudoHash(byte[] strBytes) {
        int sum = 0;
        for (byte b : strBytes) {
            sum += b;
        }

        return sum;
    }

    private static Set<List<Integer>> getGroups(Map<Integer, PseudoHashEntries> anagramMap) {
        Set<Map.Entry<Integer, PseudoHashEntries>> entries = anagramMap.entrySet();
        Comparator<List<Integer>> listComparator = Comparator.comparingInt((List<Integer> o) -> o.get(0));
        Set<List<Integer>> indexSet = new TreeSet<>(listComparator);
        for (Map.Entry<Integer, PseudoHashEntries> entry : entries) {
            indexSet.addAll(entry.getValue().getEntries());
        }
        return indexSet;
    }

    private static String buildResponse(Set<List<Integer>> indexSet) {
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Integer> indexes : indexSet) {
            for (Integer index : indexes) {
                stringBuilder.append(index).append(" ");
            }

            stringBuilder.setLength(stringBuilder.length() - 1);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}

class PseudoHashEntries {
    private final List<List<Integer>> entries = new ArrayList<>();

    public PseudoHashEntries(int i) {
        entries.add(new ArrayList<>());
        entries.get(0).add(i);
    }

    public void addValue(byte[] strByte, int index) {
        int indexSameHash;
        for (List<Integer> entry : entries) {
            indexSameHash = entry.get(0);
            if (entry.size() == 1) {
                Arrays.sort(AnagramGrouping.bytes[indexSameHash]);
            }

            Arrays.sort(strByte);
            if (Arrays.equals(AnagramGrouping.bytes[indexSameHash], AnagramGrouping.bytes[index])) {
                entry.add(index);
                return;
            }
        }

        entries.add(new ArrayList<>());
        entries.get(entries.size() - 1).add(index);
    }

    public List<List<Integer>> getEntries() {
        return entries;
    }
}
