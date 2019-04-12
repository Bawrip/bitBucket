package sorter;

import utils.ComparatorUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSorter<T extends Comparable<? super T>> {
    ComparatorUtils<T> sortOrder;

    public void sort(ArrayList<T> array) {

        ComparatorUtils<T> descending = (a, b) -> a.compareTo(b);
        ComparatorUtils<T> ascending = (a, b) -> b.compareTo(a);

        for (int i = 1; i < array.size(); i++) {
            for (int j = i; j > 0 && ascending.compare(array.get(j-1), array.get(j)) < 0 ; j--) {
                T t = array.get(j-1);
                array.set(j-1, array.get(j));
                array.set(j, t);

            }
        }

        System.out.println(array);
    }
}
