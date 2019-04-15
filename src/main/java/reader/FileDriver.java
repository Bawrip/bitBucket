package reader;


import exception.ApplicationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileDriver {
    public ArrayList<String> getDataFromFile(String filePath) throws ApplicationException {
        ArrayList<String> array = new ArrayList<>();

        File file = new File(filePath);

        if (file.isDirectory()) {
            throw new ApplicationException("Data cannot be extracted from the file, as this is a directory.");
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                array.add(scanner.next());
            }
            return array;
        } catch (FileNotFoundException exc) {
            throw new ApplicationException("File " + filePath + " not found.");
        }
    }

    public void writeDataToFile(ArrayList arrayList, String path, String fileName, String outPrefix) throws ApplicationException {
        try {
            File file = new File(path + "\\" + outPrefix + fileName);

            FileWriter writer = new FileWriter(file);

            for (int i = 0; i < arrayList.size(); i++) {
                writer.write(arrayList.get(i).toString());
                if (i + 1 < arrayList.size()) {
                    writer.write("\n");
                }
            }

            writer.flush();
            writer.close();
        } catch (Exception exc) {
            throw new ApplicationException("Exception occurred while writing to file.");
        }
    }
}
