package numbers;

import java.util.ArrayList;
import java.util.Arrays;

public class SeveralNumbers extends Number {

    public SeveralNumbers(String value) {
        super(value);
    }

    public static ArrayList<SeveralNumbers> createArrayNumbers(String input) {
        ArrayList<SeveralNumbers> numbersList = new ArrayList<>();
        String[] inputData = input.split(" ");
        long firstNumber = Long.parseLong(inputData[0]);
        int amountOfNumber = Integer.parseInt(inputData[1]);
        for (int i = 0; i < amountOfNumber; i++) {
            numbersList.add(new SeveralNumbers(String.valueOf(firstNumber + i)));
        }
        return numbersList;
    }

    public static ArrayList<SeveralNumbers> createArrayNumbersForProperties(String input) {
        String[] inputData = input.split(" ");
        long firstNumber = Long.parseLong(inputData[0]);
        int amountOfNumber = Integer.parseInt(inputData[1]);
        ArrayList<String> arrayOfProperties = new ArrayList<>(Arrays.asList(Arrays.copyOfRange(inputData, 2, inputData.length)));

        SeveralNumbers severalNumbers = new SeveralNumbers(String.valueOf(firstNumber));
        ArrayList<SeveralNumbers> arrayListOfNumber = new ArrayList<>(amountOfNumber);
        while (arrayListOfNumber.size() < amountOfNumber) {
            if (correspondsToProperties(severalNumbers, arrayOfProperties)) {
                arrayListOfNumber.add(severalNumbers);
            }
            severalNumbers = new SeveralNumbers(String.valueOf(++firstNumber));
        }
        return arrayListOfNumber;
    }

    public static boolean correspondsToProperties(SeveralNumbers severalNumbers, ArrayList<String> properties) {
        boolean isCorresponds = false;
        for (String s :
                properties) {
            if (s.startsWith("-") && severalNumbers.toString().contains(s.substring(1).toLowerCase())) {
                isCorresponds = false;
                break;
            }
            if (!s.startsWith("-") && !severalNumbers.toString().contains(s.toLowerCase())) {
                isCorresponds = false;
                break;
            } else {
                isCorresponds = true;
            }
        }
        return isCorresponds;
    }

    @Override
    public String toString() {
        return value
                + " is "
                + (isBuzz ? "buzz, " : "")
                + (isDuck ? "duck, " : "")
                + (isPalindromic ? "palindromic, " : "")
                + (isGapful ? "gapful, " : "")
                + (isSpy ? "spy, " : "")
                + (isSquare ? "square, " : "")
                + (isSunny ? "sunny, " : "")
                + (isJumping ? "jumping, " : "")
                + (isHappy ? "happy, " : "")
                + (!isHappy ? "sad, " : "")
                + (isEven ? "even" : "")
                + (!isEven ? "odd" : "");
    }
}