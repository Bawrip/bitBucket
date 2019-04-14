import org.junit.Assert;
import org.junit.Test;
import reader.FileReader;

import java.util.ArrayList;

public class FileReaderTest {
    @Test
    public void positive_test() {
        String path = "";

        FileReader reader = new FileReader();
        try {
            ArrayList<String> arrayList = reader.getDataFromFile(path);
            Assert.assertEquals("", arrayList.toString());
        } catch (Exception exc) {
            System.err.println("Exception " + exc);
        }
    }

    @Test
    public void negative_test() {
        String path = "";

        FileReader reader = new FileReader();
        try {
            ArrayList<String> arrayList = reader.getDataFromFile(path);
            Assert.assertEquals("", arrayList.toString());
        } catch (Exception exc) {
            System.err.println("Exception " + exc);
        }
    }
}
