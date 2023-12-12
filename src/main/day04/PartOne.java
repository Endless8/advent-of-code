package main.day04;

import main.Utility;

import java.util.List;

public class PartOne {

    public static void main(String[] args) {
        String puzzleInput = Utility.getPuzzleInput("resources/day04-input.txt");

        int scratchcardsPointsSum = calculatePointsSum(puzzleInput);

        System.out.printf("The sum of the scratchcards points is : %d\n", scratchcardsPointsSum);
    }

    private static int calculatePointsSum(String puzzleInput) {
        int scratchcardsPointsSum = 0;

        for (String line : puzzleInput.split("\\r\\n")) {
            String numbers = line.split("Card\\s+\\d+:\\s+")[1];
            String[] numbersArray = numbers.split("\\s+\\|\\s+");
            List<String> winningNumbers = List.of(numbersArray[0].split("\\s+"));
            List<String> numbersToMatch = List.of(numbersArray[1].split("\\s+"));

            int partialSum = evaluateCard(winningNumbers, numbersToMatch);

            scratchcardsPointsSum += partialSum;
        }

        return scratchcardsPointsSum;
    }

    private static int evaluateCard(List<String> winningNumbers, List<String> numbersToMatch) {
        int partialSum = 0;

        for (String numberToMatch : numbersToMatch) {
            if (winningNumbers.contains(numberToMatch)) {
                partialSum = partialSum == 0 ? partialSum + 1 : partialSum * 2;
            }
        }
        return partialSum;
    }

}
