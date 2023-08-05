package sprint4.finaltask.task2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * id: 89343855
 */
/*
-- ПРИНЦИП РАБОТЫ --
Для реализации хеш-таблицы было создано 2 класса, собственно, HashTable и Entry.

Entry - класс, для создания объектов, который будет хранить ключ-значение, а также ссылку на следующий список, т.к.
для решения коллизий была выбрана реализация с двусвязным списком (хотя для экономии памяти можно и в односвязный
переделать, но по лимитам памяти на контесте всё отлично).

У HashTable есть свойство capacity, которое в моей реализации является константой, но в целом можно доработать
чуть-чуть класс и принимать его в конструктор, поэтому не стал называть его в аппер кейсе. Сами же "вхождения"
хранятся в массиве values с длинной capacity.

Также в классе HashTable есть метод hash(), который считает хеш для выбора бакета в массиве. Т.к. по условию ключи
могут быть только числами, хеш вычисляется как остаток от деления абсолютной величины ключа на количество
бакетов (capacity).

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Здесь сложность будет такая же, как в теории, т.к. это и есть та самая хеш-таблица из теории. Т.е. в худшем случае,
когда все вхождения попадут в один бакет, время выполнения операции будет O(n), но в лучшем случае - это будет O(1).

Если пренебречь коллизиями, то выбор из хеш-таблицы будет производиться за O(1). В таком случае сложность работы
всего алгоритма будет линейной, O(n), где n - количество команд от пользователя.

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Хеш таблица создает массив длинной capacity, который может быть заполнен только частично, тем не менее, он всё равно
займет определённый объём памяти. Также под каждую пару ключ-значение будет создан объект для хранения, что займёт
дополнительно O(k) памяти, где k - это количество элементов, которые добавляются в хеш-таблицу. По итогу общие затраты
памяти O(k + m), где m - это массив, который будет хранить ссылки на объекты, но т.к. массив является константной
величиной, этим можно пренебречь при расчетах, тогда получается O(k).
 */
public class HashTableSolution {
    private static final String NONE = "None";

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            Integer value;
            StringTokenizer tokenizer;
            HashTable hashTable = new HashTable();
            int commandCount = Integer.parseInt(reader.readLine());
            for (int i = 0; i < commandCount; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                switch (tokenizer.nextToken()) {
                    case "get":
                        value = hashTable.get(Integer.parseInt(tokenizer.nextToken()));
                        writer.write((value == null ? NONE : value) + "\n");
                        break;
                    case "put":
                        hashTable.put(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
                        break;
                    case "delete":
                        value = hashTable.delete(Integer.parseInt(tokenizer.nextToken()));
                        writer.write((value == null ? NONE : value) + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class HashTable {
    private final int capacity = 997;
    private final Entry[] values;

    public HashTable() {
        this.values = new Entry[capacity];
    }

    public Integer get(int key) {
        int index = hash(key);
        Entry entry = values[index];
        if (entry == null) {
            return null;
        }

        if (entry.getKey() == key) {
            return entry.getValue();
        }

        while (entry.hasNext()) {
            entry = entry.next();
            if (entry.getKey() == key) {
                return entry.getValue();
            }
        }

        return null;
    }

    public Integer delete(int key) {
        int index = hash(key);
        Entry entry = values[index];
        if (entry == null) {
            return null;
        }

        if (entry.getKey() == key) {
            if (entry.hasNext()) {
                values[index] = entry.next();
                values[index].setPrev(null);
            } else {
                values[index] = null;
            }

            return entry.getValue();
        }

        while (entry.hasNext()) {
            entry = entry.next();
            if (entry.getKey() != key) {
                continue;
            }

            entry.prev().setNext(entry.next());
            if (entry.hasNext()) {
                entry.next().setPrev(entry.prev());
            }

            return entry.getValue();
        }

        return null;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Entry entry = values[index];
        if (entry == null) {
            values[index] = new Entry(key, value);
            return;
        }

        if (entry.getKey() == key) {
            entry.setValue(value);
            return;
        }

        while (entry.hasNext()) {
            entry = entry.next();
            if (entry.getKey() == key) {
                entry.setValue(value);
                return;
            }
        }

        Entry newEntry = new Entry(key, value);
        newEntry.setPrev(entry);
        entry.setNext(newEntry);
    }

    private int hash(int key) {
        return Math.abs(key) % capacity;
    }
}

class Entry {
    private final int key;
    private int value;
    private Entry next = null;
    private Entry prev = null;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Entry next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public Entry next() {
        return next;
    }

    public void setPrev(Entry prev) {
        this.prev = prev;
    }

    public Entry prev() {
        return prev;
    }
}
