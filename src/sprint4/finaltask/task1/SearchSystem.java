package sprint4.finaltask.task1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * id: 89376089
 */
/*
-- ПРИНЦИП РАБОТЫ --
В текущей реализации документы (строки, в которых осуществляется поиск) не хранятся. Когда программа получает
документ, она индексирует его, подсчитывая количество каждого из слов. Индексирование происходит путём разбиения
документа на слова по пробелу, далее в хеш-таблицу складывается пара ключ-значение, где ключом является само
слово (строка), а значением является другая хеш-таблица. Во вложенной хеш-таблице хранится пара ключ-значение, где
ключом является индекс(порядковый номер, начиная с 0) документа, а значением - количество повторений этого слова в
документе.

Далее осуществляется поиск уже по хеш-таблице поисковых индексов. Программа получает запрос и разбивает его по словам.
Далее идет поиск по каждому слову запроса в хеш таблице с поисковыми индексами. Чтобы исключить дублирование слов в
поисковом запросе, применяется сет. Он "запоминает" слова, по которым уже производился поиск и при повторении слова
итерация пропускается.

В процессе поиска составляется коллекция результатов. Результат - это объект хранящий id документа (индекс + 1) и
количество повторений в документе слов из запроса. После завершения поиска результаты сортируются и берётся 5 первых
результатов.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Индексирование документа имеет линейную сложность и напрямую зависит от количества слов в документе, т.е. имеет
сложность O(n). Соответственно тут же идет зависимость от количества документов, где также линейная зависимость O(n).
В таком случае получается, что реальная сложность индексирования будет O(n1 + n2 + n3 + ...),
где n1, n2, ... - количество слов в документах.

Далее же идет поиск и поиск работает за O(m), где m - это количество поисковых запросов. Собирается некоторый список
результатов, после чего по ним подсчитываются наиболее релевантные страницы.

По итогу в худшем случае алгоритм имеет сложность O(n + m * n), т.к. первый раз идет индексация всех документов
за линейную сложность и затем идет поиск, с учётом того, что каждое слово запроса может быть в каждом из документов.

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Здесь в целом всё аналогично временной сложность, т.к. в худшем случае все слова будут уникальными и для хранения
индексов потребуется O(n1 + n2 + ...), где n1, n2, ... - количество слов в документах.

В поиске также сохраняется сет слов запроса, поэтому в худшем также потребуется O(n) памяти для хранения сета.

По итогу получается та же формула, что и у временной сложности O(n1 + n2 + ... + nx + k).
 */
public class SearchSystem {
    private static final int RESULT_COUNT = 5;

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            Map<String, Map<Integer, Integer>> indexes = indexDocuments(reader, Integer.parseInt(reader.readLine()));

            int queryCount = Integer.parseInt(reader.readLine());
            for (int i = 0; i < queryCount; i++) {
                int[] results = search(indexes, reader.readLine());
                writer.write(Arrays.stream(results).mapToObj(String::valueOf).collect(Collectors.joining(" ")) + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, Map<Integer, Integer>> indexDocuments(BufferedReader reader, int documentCount)
            throws IOException {
        Map<String, Map<Integer, Integer>> indexes = new HashMap<>();
        String word;
        StringTokenizer stringTokenizer;
        for (int i = 0; i < documentCount; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            while (stringTokenizer.hasMoreTokens()) {
                word = stringTokenizer.nextToken();
                if (!indexes.containsKey(word)) {
                    indexes.put(word, new HashMap<>());
                }

                if (indexes.get(word).containsKey(i)) {
                    indexes.get(word).put(i, indexes.get(word).get(i) + 1);
                } else {
                    indexes.get(word).put(i, 1);
                }
            }
        }

        return indexes;
    }

    private static int[] search(Map<String, Map<Integer, Integer>> indexes, String str) {
        String word;
        int documentIndex;
        Set<String> querySet = new HashSet<>();
        Map<Integer, Result> results = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            word = stringTokenizer.nextToken();
            if (querySet.contains(word)) {
                continue;
            }

            querySet.add(word);
            if (!indexes.containsKey(word)) {
                continue;
            }

            for (Map.Entry<Integer, Integer> wordIndexes : indexes.get(word).entrySet()) {
                if (!results.containsKey(wordIndexes.getKey())) {
                    results.put(wordIndexes.getKey(), new Result(wordIndexes.getKey() + 1));
                }

                documentIndex = wordIndexes.getKey();
                results.get(documentIndex).setCount(results.get(documentIndex).getCount() + wordIndexes.getValue());
            }
        }

        PriorityQueue<Result> heap = getTopResults(results);
        return new ArrayList<>(heap).stream().sorted(Collections.reverseOrder()).mapToInt(Result::getId).toArray();
    }

    private static PriorityQueue<Result> getTopResults(Map<Integer, Result> results) {
        PriorityQueue<Result> heap = new PriorityQueue<>();
        for (Result result : results.values()) {
            if (heap.size() < RESULT_COUNT) {
                heap.add(result);
            } else if (heap.peek().compareTo(result) < 0) {
                heap.remove();
                heap.add(result);
            }
        }

        return heap;
    }
}

class Result implements Comparable<Result> {
    private final int id;
    private int count = 0;

    public Result(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(Result o) {
        if (count == o.count) {
            return o.id - id;
        }

        return count - o.count;
    }
}
