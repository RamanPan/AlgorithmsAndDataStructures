package sort;

import structures.ArrayListByRoman;

import java.util.Comparator;

public class InsertionSortByRoman<T> {

    public void sort(ArrayListByRoman<T> array, Comparator<T> comparator) {
        sort(array, 0, array.size() - 1, comparator);
    }

    public void sort(ArrayListByRoman<T> array, int fromIndex, int toIndex, Comparator<T> comparator) {
        int n = toIndex - fromIndex + 1;
        for (var i = 1; i < n; ++i) {
            T key = array.get(fromIndex + i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(array.get(fromIndex + j), key) > 0) {
                array.set(fromIndex + j + 1, array.get(fromIndex + j));
                --j;
            }
            array.set(fromIndex + j + 1, key);
        }
    }
}

