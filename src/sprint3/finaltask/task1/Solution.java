package sprint3.finaltask.task1;

/**
 * id: 88982214
 */
/*
-- ПРИНЦИП РАБОТЫ --
По сути, это просто бинарный поиск с учетом особенностей входных данных. Принцип такой же, что массив разделяется
пополам, вычисляется в какой части может находиться искомое значение и рекурсивно ищет в оставшейся половине нужный
элемент.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Временная сложность алгоритма O(log n), т.к. это бинарный поиск и в одной из лекций это уже было сказано. Но я
понимаю, что это из-за того, что на каждой итерации количество данных, в которых производится поиск, уменьшается в 2
раза.

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Для данного алгоритма не требуется дополнительная память, всё что он создает, это пара переменных, которые являются
константными значениями. Т.е. сам алгоритм потребляет O(1) памяти, если не учитывать сам массив с входными данными.
Говорилось о том, что нужно учитывать все затраты на работу программы и тогда это O(n) на сам массив, но в реальной
программе эта память будет занята ещё до работы алгоритма, поэтому думаю всё же нужно брать O(1).
 */
public class Solution {
    public static int brokenSearch(int[] arr, int k) {
        return binarySearch(arr, 0, arr.length, k);
    }

    private static int binarySearch(int[] arr, int left, int right, int desired) {
        int mid = (right - left) / 2 + left;
        if (arr[mid] == desired) {
            return mid;
        }

        if (right - left <= 1) {
            return -1;
        }

        if (arr[mid] > arr[0] && arr[mid] > desired && desired >= arr[0]) {
            return binarySearch(arr, left, mid, desired);
        } else if (arr[mid] < arr[0] && (desired >= arr[0] || desired < arr[mid])) {
            return binarySearch(arr, left, mid, desired);
        } else {
            return binarySearch(arr, mid + 1, right, desired);
        }
    }

    public static void test() {
        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
        assert 6 == brokenSearch(arr, 5);
    }
}
