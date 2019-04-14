package reader;


import exception.ApplicationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileReader {
    public ArrayList<String> getDataFromFile(String filePath) throws ApplicationException {
        ArrayList<String> array = new ArrayList<>();

        File file = new File(filePath);

        if (file.isDirectory()) {
            throw new ApplicationException("Из файла нельзя извлечь данные, так как это директория");
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                array.add(scanner.next());
            }
            return array;
        } catch (FileNotFoundException exc) {
            throw new ApplicationException("Файл " + filePath + " не найден.");
        }
    }
}
