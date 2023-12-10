package main.day03;

import java.util.List;

import static main.day03.Common.*;

public class PartOne {

    public static void main(String[] args) {
        startCellChecking(1);
    }

    static int checkCells(List<List<String>> charactersGrid, int sum, int i, int j) {
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
            if (cell9 != null && cell8 != null && cell8.matches("\\."))
                sum += checkCell(charactersGrid.get(i + 1), cell9, j + 1, charactersGrid.get(i + 1).size());
        }

        return sum;
    }

}
