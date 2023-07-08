package sprint3.task11;

import java.util.Arrays;

// Гоше дали задание написать красивую сортировку слиянием. Поэтому Гоше обязательно надо реализовать отдельно
// функцию merge и функцию merge_sort.
// Функция merge принимает два отсортированных массива, сливает их в один отсортированный массив и возвращает его.
// Если требуемая сигнатура имеет вид merge(array, left, mid, right), то первый массив задаётся полуинтервалом
// [left, mid) массива array, а второй – полуинтервалом [mid, right) массива array.
// Функция merge_sort принимает некоторый подмассив, который нужно отсортировать. Подмассив задаётся полуинтервалом —
// его началом и концом. Функция должна отсортировать передаваемый в неё подмассив, она ничего не возвращает.
// Функция merge_sort разбивает полуинтервал на две половинки и рекурсивно вызывает сортировку отдельно для каждой.
// Затем два отсортированных массива сливаются в один с помощью merge.
// Заметьте, что в функции передаются именно полуинтервалы [begin, end), то есть правый конец не включается. Например,
// если вызвать merge_sort(arr, 0, 4), где arr = [4, 5, 3, 0, 1, 2], то будут отсортированы только первые четыре
// элемента, изменённый массив будет выглядеть как arr = [0, 3, 4, 5, 1, 2].
// Реализуйте эти две функции.
// Мы рекомендуем воспользоваться заготовками кода для данной задачи, расположенными по ссылке.
//
// Формат ввода
// Передаваемый в функции массив состоит из целых чисел, не превосходящих по модулю 10^9. Длина сортируемого диапазона
// не превосходит 10^5.
public class Solution {
    public static void main(String[] args) {
        int[] a = {1, 4, 9, 2, 10, 11};
        int[] b = merge(a, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);
        int[] c = {1, 4, 2, 10, 1, 2};
        merge_sort(c, 0, 6);
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        assert Arrays.equals(c, expected2);
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if (right - left <= 1) {
            return;
        }

        int mid = (right - left) / 2 + (right - left) % 2 + left;
        merge_sort(arr, left, mid);
        merge_sort(arr, mid, right);

        int[] sortedPart = merge(arr, left, mid, right);
        System.arraycopy(sortedPart, 0, arr, left, right - left);
    }

    public static int[] merge(int[] arr, int left, int mid, int right) {
        int[] first = Arrays.copyOfRange(arr, left, mid);
        int[] second = Arrays.copyOfRange(arr, mid, right);
        int[] result = new int[first.length + second.length];

        left = 0;
        right = 0;
        int k = 0;
        while (left < first.length && right < second.length) {
            result[k++] = first[left] <= second[right] ? first[left++] : second[right++];
        }

        while (left < first.length) {
            result[k++] = first[left++];
        }

        while (right < second.length) {
            result[k++] = second[right++];
        }

        return result;
    }
}
