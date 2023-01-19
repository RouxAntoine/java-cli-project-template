package org.example.cmd;

import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "hello")
public class HelloCommand implements Callable<Integer> {

    @Option(names = "--name", defaultValue = "World")
    private String name;

    @Override
    public Integer call() {
        System.out.printf("Hello %s!%n", name);
        return 0;
    }
}
