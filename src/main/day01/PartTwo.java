package main.day01;

import main.Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartTwo {

    public static void main(String[] args) {
        String puzzleInput = Utility.getPuzzleInput("resources/day01/input.txt");

        int sum = calculateCalibrationValueSum(puzzleInput);

        System.out.printf("The calibration value sum is: %s%n", sum);
    }

    private static int calculateCalibrationValueSum(String puzzleInput) {
        int sum = 0;

        for (String line : puzzleInput.split("\n")) {
            line = restoreNumberFormat(line);
            sum = Common.getSum(sum, line);
        }

        return sum;
    }

    private static String restoreNumberFormat(String line) {
        Pattern pattern = Pattern.compile("(?=(zero|one|two|three|four|five|six|seven|eight|nine))");
        Matcher matcher = pattern.matcher(line);

        StringBuilder result = new StringBuilder();
        int lastMatchEnd = 0;

        while (matcher.find()) {
            String match = matcher.group(1);
            result.append(line, lastMatchEnd, matcher.start());
            result.append(wordToNumber(match));
            lastMatchEnd = matcher.start() + 1;
        }

        result.append(line.substring(lastMatchEnd));

        return result.toString();
    }

    private static String wordToNumber(String word) {
        return switch (word) {
            case "zero" -> "0";
            case "one" -> "1";
            case "two" -> "2";
            case "three" -> "3";
            case "four" -> "4";
            case "five" -> "5";
            case "six" -> "6";
            case "seven" -> "7";
            case "eight" -> "8";
            case "nine" -> "9";
            default -> word;
        };
    }
}
