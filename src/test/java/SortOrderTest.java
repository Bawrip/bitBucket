import exception.ApplicationException;
import org.junit.Assert;
import org.junit.Test;
import sorter.SortOrder;

public class SortOrderTest {
    @Test
    public void ascending_code_test() {
        try {
            SortOrder sortOrder = SortOrder.getSortOrderByCode("a");

            Assert.assertEquals(SortOrder.ASCENDING, sortOrder);
        } catch (Exception exc) {
            System.out.println("ascending_test " + exc);
        }
    }

    @Test
    public void descending_code_test() {
        try {
            SortOrder sortOrder = SortOrder.getSortOrderByCode("d");

            Assert.assertEquals(SortOrder.DESCENDING, sortOrder);
        } catch (Exception exc) {
            System.out.println("descending_test " + exc);
        }
    }

    @Test(expected = ApplicationException.class)
    public void null_code_test() throws ApplicationException {
        SortOrder.getSortOrderByCode(null);
    }

    @Test(expected = ApplicationException.class)
    public void incorrect_code_test() throws ApplicationException {
        SortOrder.getSortOrderByCode("r");
    }
}
