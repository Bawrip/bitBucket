package sorter;

import java.util.ArrayList;

public interface Sorter<T extends Comparable<? super T>> {
    ArrayList<T> sort(ArrayList<T> array);
}
