package org.example.cmd;

import picocli.CommandLine;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileVersionProvider implements CommandLine.IVersionProvider {
    private static final String PROPERTIES_FILE = "app.properties";
    private static final String VERSION_PROPERTY = "app.version";

    @Override
    public String[] getVersion() throws Exception {
        Properties properties = new Properties();

        try (InputStream is = getClass().getClassLoader().getResourceAsStream("/" + PROPERTIES_FILE)) {
            if (is == null) {
                return new String[] { "No %s file found in the classpath".formatted(PROPERTIES_FILE) };
            }

            properties.load(is);
            return new String[] { properties.getProperty(VERSION_PROPERTY) };
        }
    }
}
