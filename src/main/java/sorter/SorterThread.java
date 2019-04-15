package sorter;

import exception.ApplicationException;
import reader.FileDriver;
import utils.Converter;
import utils.SorterSettings;

import java.util.ArrayList;


public class SorterThread implements Runnable {
    Thread thread;
    private SorterSettings settings;
    private String directoryPath;
    private String fileName;

    SorterThread(SorterSettings settings, String directoryPath, String fileName) {
        this.settings = settings;
        this.directoryPath = directoryPath;
        this.fileName = fileName;

        thread = new Thread(this, fileName + "Thread");
        thread.start();
    }

    @Override
    public void run() {
        try {
            FileDriver fileDriver = new FileDriver();
            ArrayList<String> dataFromFile = fileDriver.getDataFromFile(directoryPath + "\\" + fileName);

            ArrayList processedDataFromFile = processDataFromFile(dataFromFile);
            fileDriver.writeDataToFile(processedDataFromFile, directoryPath, fileName, settings.getOutPrefix());
        } catch (Exception exc) {
            System.err.println(thread.getName() + " an exception occurred: \n" + exc.getMessage());
        }
    }

    private ArrayList processDataFromFile(ArrayList<String> dataFromFile) throws ApplicationException {
        switch (settings.getType()) {
            case STRING_TYPE:
                return processStringFileContent(dataFromFile);
            case INTEGER_TYPE:
                return processIntegerFileContent(dataFromFile);
            default:
                throw new ApplicationException("Unexpected content type " + settings.getType().getType());
        }
    }

    private ArrayList processStringFileContent(ArrayList<String> dataFromFile) {
        Sorter<String> sorter = new InsertionSorter<>(settings.getSortOrder());

        return sorter.sort(dataFromFile);
    }

    private ArrayList processIntegerFileContent(ArrayList<String> dataFromFile) throws ApplicationException {
        Sorter<Integer> sorter = new InsertionSorter<>(settings.getSortOrder());
        Converter converter = new Converter();

        return sorter.sort(converter.convertFromStringToInteger(dataFromFile));
    }
}
