package sorter;

import exception.ApplicationException;
import utils.ComparatorUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSorter<T extends Comparable<? super T>> {
    private ComparatorUtils<T> sortOrder;

    public InsertionSorter(SortOrder order) {
        switch (order) {
            case ASCENDING:
                sortOrder = (a, b) -> b.compareTo(a);
                break;
            case DESCENDING:
                sortOrder = (a, b) -> a.compareTo(b);
                break;
            default:
                sortOrder = (a, b) -> b.compareTo(a);
        }
    }

    public ArrayList<T> sort(ArrayList<T> array) {
        for (int i = 1; i < array.size(); i++) {
            for (int j = i; j > 0 && sortOrder.compare(array.get(j-1), array.get(j)) < 0 ; j--) {
                T t = array.get(j-1);
                array.set(j-1, array.get(j));
                array.set(j, t);

            }
        }

        return array;
    }
}
