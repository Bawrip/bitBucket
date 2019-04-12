package reader;


import exception.ApplicationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class FileReader<T extends Comparable<? super T>> {

    public void read(String path) throws ApplicationException {

        try {
            File directoryOrFile = new File(path);

            if (directoryOrFile.isDirectory()) {
                String[] files = directoryOrFile.list();

                for (String file : files) {
                    readFile(path + "\\" + file);
                }
            }
        } catch (Exception exc) {
            throw new ApplicationException("Директория не найдена либо не содержит файлов");
        }

    }

    private void readFile(String filePath) throws FileNotFoundException {
        String[] array = new String[100];

        File file = new File(filePath);

        if (file.isDirectory()) {
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            for (int i = 0; scanner.hasNext(); i++) {
                array[i] = scanner.next();
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
