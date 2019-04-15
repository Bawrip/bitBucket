package utils;

import exception.ApplicationException;

import java.io.File;

public class DirectoryReaderUtils {
    public String[] getListOfFiles(String path) throws ApplicationException {
        try {
            File directoryOrFile = new File(path);

            if (directoryOrFile.isDirectory()) {
                return directoryOrFile.list();
            } else {
                throw new ApplicationException("The specified path does not point to a directory.");
            }
        } catch (Exception exc) {
            throw new ApplicationException("Incorrect start parameters, should be:\n" +
                    "\"directory path\" --out-prefix=\"any prefix\" --sort-mode=\"a or d\" --content-type=\"s or i\"");
        }
    }
}
