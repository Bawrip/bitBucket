package main;

import org.apache.commons.cli.*;
import sorter.SorterManager;
import utils.SorterSettings;

public class Main {
    public static void main(String[] args) {
        String sortOrder = null;
        String contentType = null;
        String outPrefix = null;

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
                outPrefix =  commandLine.getOptionValue("out-prefix");
            }
            if (commandLine.hasOption("content-type")) {
                contentType =  commandLine.getOptionValue("content-type");
            }
            if (commandLine.hasOption("sort-mode")) {
                sortOrder =  commandLine.getOptionValue("sort-mode");
            }
        } catch (ParseException ex) {
            System.out.println("Incorrect parameters, should be:\n" +
                                "\"directory path\" --out-prefix=\"any prefix\" --sort-mode=\"a or d\" --content-type=\"s or i\"");
            return;
        }

        try {
            SorterSettings sorterSettings = new SorterSettings.SorterSettingBuilder()
                    .setBuilderOutPrefix(outPrefix)
                    .setBuilderSortOrder(sortOrder)
                    .setBuilderType(contentType)
                    .build();

            SorterManager sorterManager = new SorterManager(sorterSettings);
            sorterManager.processDirectory(args[0]);
        } catch (Exception exc) {
            System.err.println("An exception occurred: \n" + exc.getMessage());
        }
    }

    private static Options createOptions() {
        Options options = new Options();

        OptionGroup optionGroup = new OptionGroup();
        options.addOptionGroup(new OptionGroup()).addOption(Option.builder("o")
                .longOpt("out-prefix")
                .argName("outPrefix")
                .hasArg()
                .desc("Prefix of the output file.")
                .build());

        options.addOptionGroup(new OptionGroup()).addOption(Option.builder("c")
                .longOpt("content-type")
                .argName("contentType")
                .hasArg()
                .desc("File content type. May have the following values:" +
                        " s - String," +
                        " i - Integer.")
                .build());

        options.addOptionGroup(new OptionGroup()).addOption(Option.builder("s")
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
