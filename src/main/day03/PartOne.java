package main.day03;

import main.Utility;

import java.util.ArrayList;
import java.util.List;

public class PartOne {

    private static String cell1;
    private static String cell2;
    private static String cell3;
    private static String cell4;
    private static String cell5;
    private static String cell6;
    private static String cell7;
    private static String cell8;
    private static String cell9;

    public static void main(String[] args) {
        String puzzleInput = Utility.getPuzzleInput("resources/day03-input.txt");

        List<List<String>> charactersGrid = new ArrayList<>();
        for (String row : puzzleInput.split("\r\n")) charactersGrid.add(List.of(row.split("")));

        int sum = 0;
        for (int i = 0; i < charactersGrid.size(); i++) {
            for (int j = 0; j < charactersGrid.get(i).size(); j++) {
                populateCells(charactersGrid, i, j);
                sum = checkCells(charactersGrid, sum, i, j);
            }
        }

        System.out.printf("The sum of the part numbers in the engine schematic is: %d", sum);
    }

    private static int checkCells(List<List<String>> charactersGrid, int sum, int i, int j) {
        if (cell5.matches("[^\\p{L}\\p{N}\\s.]")) {
            if (cell1 != null)
                sum += checkCell(charactersGrid.get(i - 1), cell1, j - 1, charactersGrid.get(i - 1).size());
            if (cell2 != null && cell1 != null && cell1.matches("\\."))
                sum += checkCell(charactersGrid.get(i - 1), cell2, j, charactersGrid.get(i - 1).size());
            if (cell3 != null && cell2 != null && cell2.matches("\\."))
                sum += checkCell(charactersGrid.get(i - 1), cell3, j + 1, charactersGrid.get(i - 1).size());

            if (cell4 != null)
                sum += checkCell(charactersGrid.get(i), cell4, j - 1, charactersGrid.get(i).size());
            if (cell6 != null)
                sum += checkCell(charactersGrid.get(i), cell6, j + 1, charactersGrid.get(i).size());

            if (cell7 != null)
                sum += checkCell(charactersGrid.get(i + 1), cell7, j - 1, charactersGrid.get(i + 1).size());
            if (cell8 != null && cell7 != null && cell7.matches("\\."))
                sum += checkCell(charactersGrid.get(i + 1), cell8, j, charactersGrid.get(i + 1).size());
            if (cell9 != null  && cell8 != null && cell8.matches("\\."))
                sum += checkCell(charactersGrid.get(i + 1), cell9, j + 1, charactersGrid.get(i + 1).size());
        }
        return sum;
    }

    private static void populateCells(List<List<String>> charactersGrid, int i, int j) {
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

    private static int checkCell(List<String> cells, String cell, int cursor, int size) {
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

}
