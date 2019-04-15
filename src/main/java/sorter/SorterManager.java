package sorter;

import utils.DirectoryReaderUtils;
import utils.SorterSettings;

import java.util.ArrayList;

public class SorterManager {
    private SorterSettings settings;

    public SorterManager(SorterSettings settings) {
        this.settings = settings;
    }

    public void processDirectory(String path) {
        DirectoryReaderUtils directoryReader = new DirectoryReaderUtils();
        ArrayList<SorterThread> sortedThreadList = new ArrayList<>();

        try {
            String[] files = directoryReader.getListOfFiles(path);
            for (String fileName : files) {
                sortedThreadList.add(new SorterThread(settings, path, fileName));
            }

            for (SorterThread tread: sortedThreadList) {
                tread.thread.join();
            }
        } catch (Exception exc) {
            System.err.println("An exception occurred: \n" + exc.getMessage());
        }
    }
}
