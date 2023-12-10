package main.day01;

import main.Utility;

public class PartOne {

    public static void main(String[] args) {
        String puzzleInput = Utility.getPuzzleInput("resources/day01-input.txt");

        int sum = calculateCalibrationValueSum(puzzleInput);

        System.out.printf("The calibration value sum is: %s%n", sum);
    }

    private static int calculateCalibrationValueSum(String puzzleInput) {
        int sum = 0;

        for (String line : puzzleInput.split("\n"))
            sum = Common.getSum(sum, line);

        return sum;
    }

}