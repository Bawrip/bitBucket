package main;

import org.apache.commons.cli.*;
import reader.FileReader;
import sorter.InsertionSorter;

public class Main {
    public static void main(String[] args) {
        InsertionSorter<Integer> sorter = new InsertionSorter();

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
                System.out.println("arg = " + commandLine.getOptionValue("out-prefix"));
            }
        } catch (ParseException ex) {
            formatter.printHelp("sort-it", options, true);
            return;
        }

        Integer[] array = {1, 4, 2, 6, 3, 5, 5, 9};

        sorter.sort(array);

        try {
            FileReader reader = new FileReader();

            reader.read("unsortedFiles/testFileOne.txt");
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

        options.addOptionGroup(optionGroup);
        return options;
    }
}
