import exception.ApplicationException;
import org.junit.Assert;
import org.junit.Test;
import utils.DirectoryReaderUtils;

import java.util.Arrays;

public class DirectoryReaderUtilsTest {
    @Test(expected = ApplicationException.class)
    public void negative_test() throws ApplicationException {
        DirectoryReaderUtils directoryReaderUtils = new DirectoryReaderUtils();

        directoryReaderUtils.getListOfFiles("dfsgywsdf");
    }
}
