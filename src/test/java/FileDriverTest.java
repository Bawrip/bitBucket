import exception.ApplicationException;
import org.junit.Assert;
import org.junit.Test;
import reader.FileDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class FileDriverTest {
    @Test(expected = ApplicationException.class)
    public void negative_test() throws ApplicationException {
        String path = "sdsfsgsdf";

        FileDriver fileDriver = new FileDriver();
        fileDriver.getDataFromFile(path);
    }

}
