package main.day01;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utility {

    static int getSum(int sum, String line) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String character : line.split(""))
            if (character.matches("\\d"))
                stringBuilder.append(character);

        String firstNumber = String.valueOf(stringBuilder.charAt(0));
        String lastNumber = String.valueOf(stringBuilder.charAt(stringBuilder.length() - 1));
        String calibrationValue = firstNumber.concat(lastNumber);
        sum += Integer.parseInt(calibrationValue);

        return sum;
    }

    static String getPuzzleInput() {
        try {
            Path resourcePath = Paths.get(ClassLoader.getSystemResource("resources/day01/input.txt").toURI());
            return Files.readString(resourcePath);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
