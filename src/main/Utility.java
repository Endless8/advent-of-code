package main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utility {

    public static String getPuzzleInput(String path) {
        try {
            Path resourcePath = Paths.get(ClassLoader.getSystemResource(path).toURI());
            return Files.readString(resourcePath);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
