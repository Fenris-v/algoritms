package sprint5.finaltask.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * id: 89927043
 */
/*
-- ПРИНЦИП РАБОТЫ --
Данная программа является реализацией пирамидальной сортировки. Сначала создаётся объект приоритетной невозрастающей
кучи. После построения кучи, на каждом шаге забирается корневой элемент и куча гарантирует, что этот элемент является
наиболее приоритетным.

Немного подробнее про работу самой кучи.
При вставке в кучу, элемент добавляется последним. Проще всего будет это рассмотреть на примере бинарного дерева,
где узел добавляется на самую левую ветку так, чтобы сохранить сбалансированность дерева. Если на примере массива,
то записывается в первую свободную область. После добавления элемента производится просеивание вверх, чтобы поставить
добавленный узел на соответствующее место.

При изъятии узла из дерева, в данной реализации, всегда происходит из корневого узла. После изъятия происходит
просеивание вниз для того, чтобы найти новый корневой узел. Для этого в качестве корня подставляется самый правый узел
с учетом того, чтобы сохранилась сбалансированность (т.е. последний заполненный элемент массива). Далее узел, который
был перемещен сравнивается с потомками и опускается вниз, пока не найдет своё место.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Операция построения кучи выполняется за линию, т.к. линейно каждый элемент добавляется в массив кучи, а затем
происходит восстановление свойств кучи. Для восстановления кучи выполняется просеивание вниз начиная с последнего
элемента, у которого есть потомки, поднимаясь на каждом шаге вверх. Итоговая сложность построения кучи будет O(n).

Сама сортировка займёт также O(n * log n), т.к. нужно пройтись по каждому элементу дерева и произвести просеивание
после каждого изъятия.

Итоговая сложность алгоритма будет O(1.5n + n * log n), что можно упростить до O(n * log n).

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Для хранения дерева потребуется O(n + 1) памяти, т.е. объём занимаемой памяти линейно зависит от размера кучи и первая
ячейка массива не используется. Для каждого значения будет создан свой объект, что также линейно займёт память O(n).
Для сортировки создается новый массив, который будет возвращён в качестве результата, что займёт O(n).
Итогово получается, что программа займёт O(3n + 1) памяти, что можно упростить до O(n).
 */
public class Heapsort {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            Heap<User> heap = buildHeap(reader);
            User[] users = heapsort(heap);
            for (User user : users) {
                writer.write(user + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Heap<User> buildHeap(BufferedReader reader) throws IOException {
        int userCount = Integer.parseInt(reader.readLine());
        Heap<User> heap = new Heap<>(userCount);
        StringTokenizer stringTokenizer;
        for (int i = 0; i < userCount; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            heap.addWithoutSift(new User(stringTokenizer.nextToken(),
                                         Integer.parseInt(stringTokenizer.nextToken()),
                                         Integer.parseInt(stringTokenizer.nextToken())));
        }

        heap.restoreHeap();
        return heap;
    }

    private static User[] heapsort(Heap<User> heap) {
        User[] users = new User[heap.getSize()];
        for (int i = 0; i < users.length; i++) {
            users[i] = heap.shift();
        }

        return users;
    }
}

class Heap<T extends Comparable<T>> {
    private final Comparable[] heap;
    private Integer size = 0;

    public Heap(int length) {
        this.heap = new Comparable[length + 1];
    }

    public Integer getSize() {
        return size;
    }

    public void addWithoutSift(T obj) {
        heap[++size] = obj;
    }

    public void restoreHeap() {
        for (int i = size / 2; i > 0; i--) {
            siftDown(i);
        }
    }

    public T shift() {
        if (size == 0) {
            return null;
        }

        T obj = (T) heap[1];
        heap[1] = heap[size];
        heap[size--] = null;
        siftDown(1);

        return obj;
    }

    private void siftDown(int index) {
        int left;
        int right;
        int nextIndex;
        while (true) {
            left = index * 2;
            right = left + 1;
            if (left > size) {
                return;
            }

            nextIndex = right <= size && heap[right].compareTo(heap[left]) < 1 ? right : left;
            if (heap[index].compareTo(heap[nextIndex]) < 1) {
                return;
            }

            T value = (T) heap[index];
            heap[index] = heap[nextIndex];
            heap[nextIndex] = value;
            index = nextIndex;
        }
    }
}

class User implements Comparable<User> {
    private final String login;
    private final int completed;
    private final int fine;

    public User(String login, int completed, int fine) {
        this.login = login;
        this.completed = completed;
        this.fine = fine;
    }

    @Override
    public String toString() {
        return login;
    }

    @Override
    public int compareTo(User user) {
        if (completed != user.completed) {
            return user.completed - completed;
        }

        if (fine != user.fine) {
            return fine - user.fine;
        }

        return login.compareTo(user.login);
    }
}
