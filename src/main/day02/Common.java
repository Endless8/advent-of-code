package main.day02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Common {

    static Map<Integer, List<Map<String, Integer>>> getGamesInformation(String puzzleInput) {
        Map<Integer, List<Map<String, Integer>>> gamesInformation = new HashMap<>();

        for (String game : puzzleInput.split("\r\n")) {
            String[] gameInformation = game.split(": ");
            String gameId = gameInformation[0].replace("Game ", "");
            String extractions = gameInformation[1];
            List<Map<String, Integer>> extractionsList = new ArrayList<>();
            for (String extraction : extractions.split("; ")) {
                Map<String, Integer> extractionMap = new HashMap<>();
                for (String extractionByColor : extraction.split(", ")) {
                    String[] countColorSplit = extractionByColor.split(" ");
                    String colour = countColorSplit[1];
                    int count = Integer.parseInt(countColorSplit[0]);
                    extractionMap.put(colour, count);
                }
                extractionsList.add(extractionMap);
            }
            gamesInformation.put(Integer.parseInt(gameId), extractionsList);
        }

        return gamesInformation;
    }

}
