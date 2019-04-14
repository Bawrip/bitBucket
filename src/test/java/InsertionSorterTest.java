import org.junit.Assert;
import org.junit.Test;
import sorter.InsertionSorter;
import sorter.SortOrder;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSorterTest {
    @Test
    public void positive_integer_ascending_test() {
        InsertionSorter<Integer> sorter = new InsertionSorter<>(SortOrder.ASCENDING);
        Integer[] array = {2, 4, 1, 54, 33, 6, 1 };
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));

        ArrayList<Integer> sortedArrayList = sorter.sort(arrayList);

        Assert.assertEquals("[1, 1, 2, 4, 6, 33, 54]", sortedArrayList.toString());
    }

    @Test
    public void positive_integer_descending_test() {
        InsertionSorter<Integer> sorter = new InsertionSorter<>(SortOrder.DESCENDING);
        Integer[] array = {2, 4, 1, 54, 33, 6, 1 };
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));

        ArrayList<Integer> sortedArrayList = sorter.sort(arrayList);

        Assert.assertEquals("[54, 33, 6, 4, 2, 1, 1]", sortedArrayList.toString());
    }

    @Test
    public void positive_string_ascending_test() {
        InsertionSorter<String> sorter = new InsertionSorter<>(SortOrder.ASCENDING);
        String[] array = {"ssd", "sadg", "trdfve", "eryvg", "ewrtgf", "ewrub" };
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));

        ArrayList<String> sortedArrayList = sorter.sort(arrayList);

        Assert.assertEquals("[eryvg, ewrtgf, ewrub, sadg, ssd, trdfve]", sortedArrayList.toString());
    }

    @Test
    public void positive_string_descending_test() {
        InsertionSorter<String> sorter = new InsertionSorter<>(SortOrder.DESCENDING);
        String[] array = {"ssd", "sadg", "trdfve", "eryvg", "ewrtgf", "ewrub" };
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));

        ArrayList<String> sortedArrayList = sorter.sort(arrayList);

        Assert.assertEquals("[trdfve, ssd, sadg, ewrub, ewrtgf, eryvg]", sortedArrayList.toString());
    }
}
