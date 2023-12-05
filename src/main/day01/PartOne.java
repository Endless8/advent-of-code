package main.day01;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        String puzzleInput = getPuzzleInput();

        int sum = calculateCalibrationValueSum(puzzleInput);

        System.out.printf("The calibration value sum is: %s%n", sum);
    }

    private static int calculateCalibrationValueSum(String puzzleInput) {
        int sum = 0;

        for (String line : puzzleInput.split("\n")) {
            StringBuilder stringBuilder = new StringBuilder();

            for (String character : line.split(""))
                if (character.matches("\\d"))
                    stringBuilder.append(character);

            String firstNumber = String.valueOf(stringBuilder.charAt(0));
            String lastNumber = String.valueOf(stringBuilder.charAt(stringBuilder.length() - 1));
            String calibrationValue = firstNumber.concat(lastNumber);
            sum += Integer.parseInt(calibrationValue);
        }

        return sum;
    }

    private static String getPuzzleInput() throws URISyntaxException, IOException {
        Path resourcePath = Paths.get(ClassLoader.getSystemResource("resources/day01/input.txt").toURI());
        String puzzleInput = new String(Files.readAllBytes(resourcePath), StandardCharsets.UTF_8);
        return puzzleInput;
    }
}