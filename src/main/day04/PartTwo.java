package main.day04;

import main.Utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartTwo {

    public static void main(String[] args) {
        String puzzleInput = Utility.getPuzzleInput("resources/day04-input.txt");
        String[] cards = puzzleInput.split("\\r\\n");

        Map<Integer, Integer> scratchcardCopies = calculateCardsCopies(cards);

        int copiesCount = scratchcardCopies.values().stream().mapToInt(Integer::intValue).sum();
        int scratchcardsSum = cards.length + copiesCount;

        System.out.printf("The quantity of the scratchcards is: %d\n", scratchcardsSum);
    }

    private static Map<Integer, Integer> calculateCardsCopies(String[] cards) {
        Map<Integer, Integer> scratchcardCopies = new HashMap<>();

        for (String line : cards) {
            String[] card = line.split(":\\s+");
            int cardId = Integer.parseInt(card[0].replaceAll("Card\\s+", ""));
            String cardNumbers = card[1];
            String[] numbersArray = cardNumbers.split("\\s+\\|\\s+");
            List<String> winningNumbers = List.of(numbersArray[0].split("\\s+"));
            List<String> numbersToMatch = List.of(numbersArray[1].split("\\s+"));

            int wonCopies = calculateWonCopies(winningNumbers, numbersToMatch);
            int cardsToEvaluateQuantity = scratchcardCopies.containsKey(cardId) ? 1 + scratchcardCopies.get(cardId) : 1;

            for (int j = 1; j <= cardsToEvaluateQuantity; j++)
                evaluateScratchcard(scratchcardCopies, cardId, wonCopies);
        }

        return scratchcardCopies;
    }

    private static void evaluateScratchcard(Map<Integer, Integer> scratchcardCopies, int cardId, int wonCopies) {
        for (int i = 1; i <= wonCopies; i++) {
            int nextCardId = cardId + i;

            if (scratchcardCopies.containsKey(nextCardId))
                scratchcardCopies.put(nextCardId, scratchcardCopies.get(nextCardId) + 1);
            else
                scratchcardCopies.put(nextCardId, 1);
        }
    }

    private static int calculateWonCopies(List<String> winningNumbers, List<String> numbersToMatch) {
        int wonCopies = 0;

        for (String numberToMatch : numbersToMatch)
            if (winningNumbers.contains(numberToMatch))
                wonCopies++;

        return wonCopies;
    }

}
