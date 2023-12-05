package main.day01;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartOne {

    public static void main(String[] args) {
        String puzzleInput = Utility.getPuzzleInput();

        int sum = calculateCalibrationValueSum(puzzleInput);

        System.out.printf("The calibration value sum is: %s%n", sum);
    }

    private static int calculateCalibrationValueSum(String puzzleInput) {
        int sum = 0;

        for (String line : puzzleInput.split("\n"))
            sum = Utility.getSum(sum, line);

        return sum;
    }

}