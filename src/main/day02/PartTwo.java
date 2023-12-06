package main.day02;

import main.Utility;

import java.util.List;
import java.util.Map;

public class PartTwo {

    public static void main(String[] args) {
        String puzzleInput = Utility.getPuzzleInput("resources/day02/input.txt");

        Map<Integer, List<Map<String, Integer>>> gamesInformation = main.day02.Common.getGamesInformation(puzzleInput);

        int powerSum = calculatePowersSum(gamesInformation);

        System.out.printf("The sum of the powers is: %s%n", powerSum);
    }

    private static int calculatePowersSum(Map<Integer, List<Map<String, Integer>>> gamesInformation) {
        int powersSum = 0;

        for (Map.Entry<Integer, List<Map<String, Integer>>> gameInformation : gamesInformation.entrySet()) {
            int redMaxPower = 0;
            int greenMaxPower = 0;
            int blueMaxPower = 0;

            for (Map<String, Integer> gameExtractions : gameInformation.getValue()) {
                for (Map.Entry<String, Integer> gameExtraction : gameExtractions.entrySet()) {
                    if (gameExtraction.getKey().equals("red") && gameExtraction.getValue() > redMaxPower)
                        redMaxPower = gameExtraction.getValue();
                    else if (gameExtraction.getKey().equals("green") && gameExtraction.getValue() > greenMaxPower)
                        greenMaxPower = gameExtraction.getValue();
                    else if (gameExtraction.getKey().equals("blue") && gameExtraction.getValue() > blueMaxPower)
                        blueMaxPower = gameExtraction.getValue();
                }
            }

            powersSum += (redMaxPower * greenMaxPower * blueMaxPower);
        }

        return powersSum;
    }

}
