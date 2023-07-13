package sprint2.finaltask.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Гоша реализовал структуру данных Дек, максимальный размер которого определяется заданным числом. Методы push_back
// (x), push_front(x), pop_back(), pop_front() работали корректно. Но, если в деке было много элементов, программа
// работала очень долго. Дело в том, что не все операции выполнялись за O(1). Помогите Гоше! Напишите эффективную
// реализацию.
// Внимание: при реализации используйте кольцевой буфер.
//
// Формат ввода
// В первой строке записано количество команд n — целое число, не превосходящее 100000. Во второй строке записано
// число m — максимальный размер дека. Он не превосходит 50000. В следующих n строках записана одна из команд:
// push_back(value) – добавить элемент в конец дека. Если в деке уже находится максимальное число элементов, вывести
// «error».
// - push_front(value) – добавить элемент в начало дека. Если в деке уже находится максимальное число элементов,
// вывести «error».
// - pop_front() – вывести первый элемент дека и удалить его. Если дек был пуст, то вывести «error».
// - pop_back() – вывести последний элемент дека и удалить его. Если дек был пуст, то вывести «error».
// - Value — целое число, по модулю не превосходящее 1000.
//
// Формат вывода
// Выведите результат выполнения каждой команды на отдельной строке. Для успешных запросов push_back(x) и push_front(x)
// ничего выводить не надо.
/*
-- ПРИНЦИП РАБОТЫ --
Дек я реализовал на основе массива с размером, который передается входными данными.
Все добавляемые в деку элементы, добавляются в буфер. Свойство дека head указывает индекс элемента, который находится
в начале дека, а свойство tail - индекс последнего элемента + 1. Также существует свойство size, которое облегчает
работу с проверкой заполненности дека.

При добавлении элемента в дек, прежде всего проверяется не заполнен ли он полностью, если он заполнен, выбрасывается
исключение. Если дек не заполнен, тогда в зависимости от метода выполняется добавление в начало или конец дека.
При добавлении в начало увеличивается размер дека, уменьшается индекс (свойство) head (если оно == 0, тогда
увеличивается до длины буфера - 1). Добавление в конец происходит аналогичным образом, только смещением индекса tail
на +1 или 0, если индекс был максимальным.

При изъятии элемента, значение всё равно остаётся в буфере, я просто сдвигаю соответствующий индекс, и это значение
буфера находится уже за пределами индексов, поэтому не используется, пока не будет перезаписано. В целом изъятие
элемента работает аналогично добавлению. Если размер буфера == 0, выбрасывается исключение. При изъятии элемента
точно также сдвигается индекс head, но теперь на +1 с такими же правилами "обнуления" индекса. Единственное что,
метод изъятия с начала дека создает промежуточную переменную перед изменением индекса и возвращает её в конце.

В методе изъятия конца промежуточная переменная не создается, т.к. индекс tail сначала уменьшается и после уменьшения,
он как раз указывает на нужный элемент.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Все операции с деком стоят O(1), т.к. за основу дека взят обычный массив и мне в любой момент и для любой операции
известны все требуемые индексы. Работа всей программы имеет линейную зависимость от количества команд, т.е. O(n).

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Основной объём памяти дека занимает массив, служащий буфером дека. Остальные свойства класса являются примитивами и
потребляют константный объём памяти, которым, если я всё правильно понимаю, можно пренебречь при расчете
пространственной сложности. По итогу потребление памяти будет O(n), т.е. равным памяти, занимаемой буфером при
инициализации.
 */
public class Solution {
    protected static final String ERROR = "error\n";

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int commandCount = Integer.parseInt(reader.readLine());
            DEQ deq = new DEQ(Integer.parseInt(reader.readLine()));
            StringTokenizer stringTokenizer;
            Integer value;
            for (int i = 0; i < commandCount; i++) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                switch (stringTokenizer.nextToken()) {
                    case "push_front":
                        if (!deq.pushFront(Integer.parseInt(stringTokenizer.nextToken()))) {
                            writer.write(ERROR);
                        }
                        break;
                    case "push_back":
                        if (!deq.pushBack(Integer.parseInt(stringTokenizer.nextToken()))) {
                            writer.write(ERROR);
                        }
                        break;
                    case "pop_front":
                        value = deq.popFront();
                        writer.write(value == null ? ERROR : value + "\n");
                        break;
                    case "pop_back":
                        value = deq.popBack();
                        writer.write(value == null ? ERROR : value + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class DEQ {
    private final int[] buffer;

    private int head;
    private int tail;
    private int size;

    public DEQ(int size) {
        buffer = new int[size];
    }

    public boolean pushFront(int value) {
        if (size == buffer.length) {
            return false;
        }

        size++;
        head = head == 0 ? buffer.length - 1 : head - 1;
        buffer[head] = value;
        return true;
    }

    public boolean pushBack(int value) {
        if (size == buffer.length) {
            return false;
        }

        size++;
        buffer[tail] = value;
        tail = tail == buffer.length - 1 ? 0 : tail + 1;
        return true;
    }

    public Integer popFront() {
        if (size == 0) {
            return null;
        }

        size--;
        int value = buffer[head];
        head = head == buffer.length - 1 ? 0 : head + 1;
        return value;
    }

    public Integer popBack() {
        if (size == 0) {
            return null;
        }


        size--;
        tail = tail == 0 ? buffer.length - 1 : tail - 1;
        return buffer[tail];
    }
}
