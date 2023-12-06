package main.day01;

public class Common {

    static int getSum(int sum, String line) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String character : line.split(""))
            if (character.matches("\\d"))
                stringBuilder.append(character);

        String firstNumber = String.valueOf(stringBuilder.charAt(0));
        String lastNumber = String.valueOf(stringBuilder.charAt(stringBuilder.length() - 1));
        String calibrationValue = firstNumber.concat(lastNumber);
        sum += Integer.parseInt(calibrationValue);

        return sum;
    }

}
