package sorter;

import utils.ComparatorUtils;

import java.util.ArrayList;

public class InsertionSorter<T extends Comparable<? super T>> implements Sorter<T>{
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

    @Override
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
