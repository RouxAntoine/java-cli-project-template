package org.example;

import org.example.cmd.HelloCommand;
import org.example.cmd.ListFilesCommand;
import org.example.cmd.PropertiesFileVersionProvider;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
    name = "app",
    mixinStandardHelpOptions = true,
    versionProvider = PropertiesFileVersionProvider.class,
    subcommands = {
        HelloCommand.class, ListFilesCommand.class
    }
)
public class Main {

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}
