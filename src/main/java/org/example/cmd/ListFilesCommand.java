package org.example.cmd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "list")
public class ListFilesCommand implements Callable<Integer> {

    @Parameters(index = "0", description = "directory to search")
    private Path path;

    @Override
    public Integer call() {
        WildcardFileFilter filter = new WildcardFileFilter("*.java");

        try (Stream<Path> paths = Files.walk(path)) {
            paths.map(Path::toFile)
                .filter(filter::accept)
                .forEach(System.out::println);
            return 0;
        } catch (NoSuchFileException e) {
            System.err.println("specified directory does not exist");
        } catch (IOException e) {
            System.err.println("Ooops, an error happened " + e.getMessage());
        }
        return 1;
    }
}
