package main;

import org.apache.commons.cli.*;
import reader.FileReader;
import sorter.InsertionSorter;
import sorter.SortOrder;
import utils.Converter;
import utils.DirectoryReaderUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Options options = createOptions();
        HelpFormatter formatter = new HelpFormatter();
        formatter.setWidth(120);

        CommandLineParser commandLineParser = new DefaultParser();

        try {
            CommandLine commandLine = commandLineParser.parse(options, args);
            if (commandLine.getOptions().length < 1) {
                formatter.printHelp("sort-it", options, true);
                return;
            }
            if (commandLine.hasOption("out-prefix")) {
                //System.out.println("arg = " + commandLine.getOptionValue("out-prefix"));
            }
        } catch (ParseException ex) {
            formatter.printHelp("sort-it", options, true);
            return;
        }

        try {
            DirectoryReaderUtils directoryReader = new DirectoryReaderUtils();
            FileReader reader = new FileReader();
            String directoryPath = "C:\\Users\\xrvp15127\\IdeaProjects\\bitBucket\\src\\main\\resources\\unsortedFiles";

            String[] files = directoryReader.getListOfFiles(directoryPath);
            InsertionSorter<Integer> sorter = new InsertionSorter<>(SortOrder.ASCENDING);
            Converter converter = new Converter();

            for (String fileName : files) {
                ArrayList<String> data = reader.getDataFromFile(directoryPath + "\\" + fileName);

                sorter.sort(converter.convertFromStringToInteger(data));
            }
        } catch (Exception exc) {
            System.err.println("Happens some shit " + exc);
            exc.printStackTrace();
        }
    }

    private static Options createOptions() {
        Options options = new Options();

        OptionGroup optionGroup = new OptionGroup();
        optionGroup.addOption(Option.builder("o")
                .longOpt("out-prefix")
                .argName("outPrefix")
                .hasArg()
                .desc("Prefix of the output file.")
                .build());

        optionGroup.addOption(Option.builder("c")
                .longOpt("content-type")
                .argName("contentType")
                .hasArg()
                .desc("File content type. May have the following values:" +
                        " s - String," +
                        " i - Integer.")
                .build());

        optionGroup.addOption(Option.builder("s")
                .longOpt("sort-mode")
                .argName("sortMode")
                .hasArg()
                .desc("Sort mode. May have the following values:" +
                        " a - ascending," +
                        " d - descending.")
                .build());

        options.addOptionGroup(optionGroup);
        return options;
    }
}
