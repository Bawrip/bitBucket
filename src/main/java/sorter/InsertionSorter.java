package sorter;

import utils.ComparatorUtils;

import java.util.Arrays;

public class InsertionSorter<T extends Comparable<? super T>> {
    ComparatorUtils<T> sortOrder;

    public void sort(T[] array) {

        ComparatorUtils<T> descending = (a, b) -> a.compareTo(b);
        ComparatorUtils<T> ascending = (a, b) -> b.compareTo(a);

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && ascending.compare(array[j-1], array[j]) < 0 ; j--) {
                T t = array[j-1];
                array[j-1] = array[j];
                array[j] = t;
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
