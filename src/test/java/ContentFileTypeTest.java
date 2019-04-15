import exception.ApplicationException;
import org.junit.Assert;
import org.junit.Test;
import sorter.ContentFileType;

public class ContentFileTypeTest {
    @Test
    public void string_code_test() {
        try {
            ContentFileType type = ContentFileType.getTypeByCode("s");

            Assert.assertEquals(ContentFileType.STRING_TYPE, type);
        } catch (Exception exc) {
            System.out.println("string_code_test " + exc);
        }
    }

    @Test
    public void integer_code_test() {
        try {
            ContentFileType type = ContentFileType.getTypeByCode("i");

            Assert.assertEquals(ContentFileType.INTEGER_TYPE, type);
        } catch (Exception exc) {
            System.out.println("integer_code_test " + exc);
        }
    }

    @Test(expected = ApplicationException.class)
    public void null_code_test() throws ApplicationException {
        ContentFileType.getTypeByCode(null);
    }

    @Test(expected = ApplicationException.class)
    public void incorrect_code_test() throws ApplicationException {
        ContentFileType.getTypeByCode("r");
    }
}
