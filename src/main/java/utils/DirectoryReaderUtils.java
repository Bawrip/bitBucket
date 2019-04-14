package utils;

import exception.ApplicationException;

import java.io.File;

public class DirectoryReaderUtils {
    public String[] getListOfFiles(String path) throws ApplicationException {
        try {
            File directoryOrFile = new File(path);

            if (directoryOrFile.isDirectory()) {
                String[] files = directoryOrFile.list();
                return files;
            } else {
                throw new ApplicationException("Данный путь не ведет в директорию.");
            }
        } catch (Exception exc) {
            throw new ApplicationException("Директория не найдена либо не содержит файлов");
        }
    }
}
