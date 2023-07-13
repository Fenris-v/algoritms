package sprint3.finaltask.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * id: 89026368
 */
/*
Эта задача оказалась для меня самой сложной на данный момент и я не уверен, что решение правильным. Материала
приложенного в условии мне не хватило для решения задачи, руководствовался следующим источником, чтобы хоть как-то
понять алгоритм:
https://youtu.be/EOu9xSe-Ua0

-- ПРИНЦИП РАБОТЫ --
На первом шаге выбирается опорный элемент, который смещается в крайнюю правую позицию. Затем идет сравнение каждого
элемента с опорным. Сравнение производится в двух направлениях, т.е. left-right. Если опорный элемент сравнивается с
left и left < pivot, то указатель left инкрементируется. Если же left > pivot, то программа переходит к сравнению
опорного с right. Если right > pivot, то указатель декрементируется, иначе left и right меняются значениями. Так
происходит до пока left < right. После этого опорный элемент устанавливается в первый элемент с начала массива,
который больше опорного (т.е. на который указывают оба указателя left-right). Далее метод вызывает рекурсию, где
массив как бы разделяется на left-pivot и pivot-right. Здесь допускаю, что существует моя ошибка при вызове рекурсии.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Временная сложность алгоритма O(n * log n). Каждый элемент массива (n) потенциально сравнивается log n раз с опорным.
log n получается от того, что каждый раз массив как бы делится на 2 части, а не полностью повторяется.

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
В данном алгоритме вводится несколько переменных, которые являются константным значением для формулы и потому ими
можно пренебречь. Сама программа же использует только память на хранение массива с входными данными, который
существует ещё до запуска алгоритма. Поэтому сам алгоритм использует O(1) памяти.
 */
public class EffectiveQuickSort {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            Person[] people = getPersons(reader);
            effectiveQuickSort(people, 0, people.length - 1);
            for (Person person : people) {
                writer.write(person + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Person[] getPersons(BufferedReader reader) throws IOException {
        int length = Integer.parseInt(reader.readLine());
        Person[] people = new Person[length];
        StringTokenizer stringTokenizer;
        for (int i = 0; i < length; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            people[i] =
                    new Person(stringTokenizer.nextToken(),
                               Integer.parseInt(stringTokenizer.nextToken()),
                               Integer.parseInt(stringTokenizer.nextToken()));
        }

        return people;
    }

    private static void effectiveQuickSort(Person[] people, int left, int right) {
        if (right - left < 1) {
            return;
        }

        int pivot = (right - left) / 2 + left;
        int l = left;
        int r = right;
        Person temp = people[r];
        people[r] = people[pivot];
        people[pivot] = temp;
        pivot = r--;
        while (r > l) {
            if (people[l].compareTo(people[pivot]) < 0) {
                l++;
            } else if (people[r].compareTo(people[pivot]) > 0) {
                r--;
            } else {
                temp = people[l];
                people[l] = people[r];
                people[r] = temp;
                l++;
                r--;
            }
        }

        if (people[l].compareTo(people[pivot]) > 0) {
            temp = people[l];
            people[l] = people[pivot];
            people[pivot] = temp;
            pivot = l;
        }

        if (pivot - 1 > left) {
            effectiveQuickSort(people, left, pivot);
        }

        if (right - pivot > 1) {
            effectiveQuickSort(people, pivot, right);
        }
    }
}

class Person implements Comparable<Person> {
    private final String name;
    private final int done;
    private final int fine;

    public Person(String name, int done, int fine) {
        this.name = name;
        this.done = done;
        this.fine = fine;
    }

    public String getName() {
        return name;
    }

    public int getDone() {
        return done;
    }

    public int getFine() {
        return fine;
    }

    @Override
    public int compareTo(Person person) {
        if (done != person.getDone()) {
            return done < person.getDone() ? 1 : -1;
        }

        if (fine != person.getFine()) {
            return fine > person.getFine() ? 1 : -1;
        }

        return name.compareTo(person.getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
