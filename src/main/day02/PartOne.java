package main.day02;

import main.Utility;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PartOne {

    public static void main(String[] args) {
        String puzzleInput = Utility.getPuzzleInput("resources/day02-input.txt");

        Map<Integer, List<Map<String, Integer>>> gamesInformation = main.day02.Common.getGamesInformation(puzzleInput);

        int idSum = calculateIdSum(gamesInformation);

        System.out.printf("The sum of the Game IDs is: %s%n", idSum);
    }

    private static int calculateIdSum(Map<Integer, List<Map<String, Integer>>> gamesInformation) {
        int idSum = 0;
        
        for (Entry<Integer, List<Map<String, Integer>>> gameInformation : gamesInformation.entrySet()) {
            int gameId = gameInformation.getKey();
            boolean isPossibleGame = true;

            for (Map<String, Integer> gameExtractions : gameInformation.getValue()) {
                for (Entry<String, Integer> gameExtraction : gameExtractions.entrySet()) {
                    isPossibleGame = isPossibleGame(gameExtraction);
                    if (!isPossibleGame) break;
                }
                if (!isPossibleGame) break;
            }

            if (isPossibleGame)
                idSum += gameId;
        }
        
        return idSum;
    }

    private static boolean isPossibleGame(Entry<String, Integer> gameExtraction) {
        return !(gameExtraction.getKey().equals("red") && gameExtraction.getValue() > 12)
                && !(gameExtraction.getKey().equals("green") && gameExtraction.getValue() > 13)
                && !(gameExtraction.getKey().equals("blue") && gameExtraction.getValue() > 14);
    }

}
