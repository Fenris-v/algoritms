package sprint5.task13;

// Напишите функцию, совершающую просеивание вверх в куче на максимум. Гарантируется, что порядок элементов в куче
// может быть нарушен только элементом, от которого запускается просеивание.
// Функция принимает в качестве аргументов массив, в котором хранятся элементы кучи, и индекс элемента, от которого
// надо сделать просеивание вверх. Функция должна вернуть индекс, на котором элемент оказался после просеивания.
// Также необходимо изменить порядок элементов в переданном в функцию массиве.
// Индексация в массиве, содержащем кучу, начинается с единицы. Таким образом, сыновья вершины на позиции v
// это 2v и 2v + 1. Обратите внимание, что нулевой элемент в передаваемом массиве фиктивный, вершина кучи
// соответствует 1-му элементу.
public class Solution {
    public static int siftUp(int[] heap, int idx) {
        if (idx == 1) {
            return 1;
        }

        int parentIndex = idx / 2;
        if (heap[parentIndex] >= heap[idx]) {
            return idx;
        }

        int value = heap[idx];
        heap[idx] = heap[parentIndex];
        heap[parentIndex] = value;

        return siftUp(heap, parentIndex);
    }
}
