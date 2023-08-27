package sprint5.finaltask.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

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
            heap.add(new User(stringTokenizer.nextToken(),
                              Integer.parseInt(stringTokenizer.nextToken()),
                              Integer.parseInt(stringTokenizer.nextToken())));
        }

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

    public void add(T obj) {
        heap[++size] = obj;
        siftUp(size);
    }

    private void siftUp(int idx) {
        if (idx == 1) {
            return;
        }

        int parentIndex = idx / 2;
        if (heap[parentIndex].compareTo(heap[idx]) <= 0) {
            return;
        }

        T value = (T) heap[idx];
        heap[idx] = heap[parentIndex];
        heap[parentIndex] = value;
        siftUp(parentIndex);
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

    private void siftDown(int idx) {
        int left = idx * 2;
        int right = left + 1;
        if (left > size) {
            return;
        }

        int nextIndex = right <= size && heap[right].compareTo(heap[left]) < 1 ? right : left;
        if (heap[idx].compareTo(heap[nextIndex]) < 1) {
            return;
        }

        T value = (T) heap[idx];
        heap[idx] = heap[nextIndex];
        heap[nextIndex] = value;
        siftDown(nextIndex);
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
        } else if (fine != user.fine) {
            return fine - user.fine;
        }

        return login.compareTo(user.login);
    }
}
