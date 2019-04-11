package reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public void read(String path) throws FileNotFoundException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());

        try (Scanner scanner = new Scanner(file)) {
            for (int i = 0; scanner.hasNext(); i++) {
                String str = scanner.next();

                System.out.println(i + " " + str);
            }
        }
    }
}
