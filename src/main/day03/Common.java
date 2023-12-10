package main.day03;

import main.Utility;

import java.util.ArrayList;
import java.util.List;

import static main.day03.PartOne.*;

public class Common {

    static String cell1;
    static String cell2;
    static String cell3;
    static String cell4;
    static String cell5;
    static String cell6;
    static String cell7;
    static String cell8;
    static String cell9;

    static void populateCells(List<List<String>> charactersGrid, int i, int j) {
        boolean isUpperBound = i > 0;
        boolean isLeftBound = j > 0;
        boolean isRightBound = j < charactersGrid.get(i).size() - 1;
        boolean isLowerBound = i < charactersGrid.size() - 1;
        cell1 = isUpperBound && isLeftBound ? charactersGrid.get(i - 1).get(j - 1) : null;
        cell2 = isUpperBound ? charactersGrid.get(i - 1).get(j) : null;
        cell3 = isUpperBound && isRightBound ? charactersGrid.get(i - 1).get(j + 1) : null;
        cell4 = isLeftBound ? charactersGrid.get(i).get(j - 1) : null;
        cell5 = charactersGrid.get(i).get(j);
        cell6 = isRightBound ? charactersGrid.get(i).get(j + 1) : null;
        cell7 = isLowerBound && isLeftBound ? charactersGrid.get(i + 1).get(j - 1) : null;
        cell8 = isLowerBound ? charactersGrid.get(i + 1).get(j) : null;
        cell9 = isLowerBound && isRightBound ? charactersGrid.get(i + 1).get(j + 1) : null;
    }

    static int checkCell(List<String> cells, String cell, int cursor, int size) {
        StringBuilder number = new StringBuilder();

        if (cell != null && cell.matches("\\d")) {
            number.append(cell);
            for (int i = cursor - 1; i >= 0 && cells.get(i).matches("\\d"); i--)
                number.insert(0, cells.get(i));
            for (int j = cursor + 1; j < size && cells.get(j).matches("\\d"); j++)
                number.append(cells.get(j));
        }

        String numberString = number.toString();
        return numberString.isEmpty() ? 0 : Integer.parseInt(numberString);
    }

    static void startCellChecking(int part) {
        String puzzleInput = Utility.getPuzzleInput("resources/day03-input.txt");

        List<List<String>> charactersGrid = new ArrayList<>();
        for (String row : puzzleInput.split("\r\n")) charactersGrid.add(List.of(row.split("")));

        int sum = 0;
        for (int i = 0; i < charactersGrid.size(); i++) {
            for (int j = 0; j < charactersGrid.get(i).size(); j++) {
                populateCells(charactersGrid, i, j);
                if (part == 1)
                    sum = PartOne.checkCells(charactersGrid, sum, i, j);
                else if (part == 2)
                    sum = PartTwo.checkCells(charactersGrid, sum, i, j);
            }
        }

        System.out.printf("The sum of the part numbers in the engine schematic is: %d", sum);
    }
}
