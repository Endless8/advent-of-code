package main.day03;

import java.util.List;

import static main.day03.Common.*;

public class PartTwo {

    private static int partialSum;
    private static int numbersToSum;

    public static void main(String[] args) {
        startCellChecking(2);
    }

    static int checkCells(List<List<String>> charactersGrid, int sum, int i, int j) {
        if (cell5.matches("\\*")) {
            numbersToSum = 0;
            partialSum = 0;

            if (cell1 != null) {
                int cellNumber = checkCell(charactersGrid.get(i - 1), cell1, j - 1, charactersGrid.get(i - 1).size());
                checkPartialSum(cellNumber);
            }

            if (cell2 != null && cell1 != null && cell1.matches("\\.")) {
                int cellNumber = checkCell(charactersGrid.get(i - 1), cell2, j, charactersGrid.get(i - 1).size());
                checkPartialSum(cellNumber);
            }
            if (cell3 != null && cell2 != null && cell2.matches("\\.")) {
                int cellNumber = checkCell(charactersGrid.get(i - 1), cell3, j + 1, charactersGrid.get(i - 1).size());
                checkPartialSum(cellNumber);
            }

            if (cell4 != null) {
                int cellNumber = checkCell(charactersGrid.get(i), cell4, j - 1, charactersGrid.get(i).size());
                checkPartialSum(cellNumber);
            }
            if (cell6 != null) {
                int cellNumber = checkCell(charactersGrid.get(i), cell6, j + 1, charactersGrid.get(i).size());
                checkPartialSum(cellNumber);
            }

            if (cell7 != null) {
                int cellNumber = checkCell(charactersGrid.get(i + 1), cell7, j - 1, charactersGrid.get(i + 1).size());
                checkPartialSum(cellNumber);
            }
            if (cell8 != null && cell7 != null && cell7.matches("\\.")) {
                int cellNumber = checkCell(charactersGrid.get(i + 1), cell8, j, charactersGrid.get(i + 1).size());
                checkPartialSum(cellNumber);
            }
            if (cell9 != null  && cell8 != null && cell8.matches("\\.")) {
                int cellNumber = checkCell(charactersGrid.get(i + 1), cell9, j + 1, charactersGrid.get(i + 1).size());
                checkPartialSum(cellNumber);
            }

            if (numbersToSum == 2) sum += partialSum;
        }

        return sum;
    }

    private static void checkPartialSum(int cellNumber) {
        if (cellNumber != 0) {
            partialSum = partialSum == 0 ? partialSum + cellNumber : partialSum * cellNumber;
            numbersToSum = cellNumber > 0 ? numbersToSum + 1 : numbersToSum;
        }
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
