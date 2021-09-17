package numbers;

import java.util.ArrayList;
import java.util.Arrays;

public class Number {

    protected Long value;
    protected boolean isEven;
    protected boolean isBuzz;
    protected boolean isDuck;
    protected boolean isPalindromic;
    protected boolean isGapful;
    protected boolean isSpy;
    protected boolean isSquare;
    protected boolean isSunny;
    protected boolean isJumping;
    protected boolean isHappy;
    ArrayList<Long> counters = new ArrayList<>();

    public Number(String value) {
        String valueOfString = String.valueOf(value);
        String valueOfStringReverse = new StringBuilder(valueOfString).reverse().toString();
        this.value = Long.parseLong(value);
        isEven = this.value % 2 == 0;
        isBuzz = this.value % 7 == 0 || this.value % 10 == 7;
        isDuck = valueOfString.substring(1).contains("0");
        isPalindromic = valueOfString.equals(valueOfStringReverse);
        isGapful = gapfulCheck(value);
        isSpy = spyCheck(value);
        isSquare = squareCheck(value);
        isSunny = sunnyCheck(value);
        isJumping = jumpingCheck(value);
        isHappy = happyCheck(value);
    }

    public boolean gapfulCheck(String value) {
        String firstAndLastChar = String.valueOf(value.charAt(0)) + value.charAt(value.length() - 1);
        int firstAndLastCharInt = Integer.parseInt(firstAndLastChar);
        return value.length() >= 3 && Long.parseLong(value) % (long) firstAndLastCharInt == 0;
    }

    public boolean spyCheck(String value) {
        long sumNumbers = 0;
        long productNumbers = 1;
        for (int i = 0; i < value.length(); i++) {
            long productNumbers1 = Integer.parseInt(value.charAt(i) + "");
            sumNumbers += productNumbers1;
            productNumbers *= productNumbers1;
        }
        return sumNumbers == productNumbers;
    }

    public boolean sunnyCheck(String value) {
        double numberSqrt = Math.sqrt(Long.parseLong(value) + 1);
        return numberSqrt % 1 == 0;
    }

    public boolean squareCheck(String value) {
        double numberSqrt = Math.sqrt(Long.parseLong(value));
        return numberSqrt % 1 == 0;
    }

    public boolean jumpingCheck(String value) {
        int k = 0;
        String[] str = value.split("");
        for (int i = 0; i < str.length - 1; i++) {
            if (Long.parseLong(str[i]) == Long.parseLong(str[i + 1]) - 1 ||
                    Long.parseLong(str[i]) == Long.parseLong(str[i + 1]) + 1) {
                k++;
            }
        }
        return k == str.length - 1;
    }


    public boolean happyCheck(String value) {
        long counter = 0;
        ArrayList<String> digitOfNumbers = new ArrayList<>(Arrays.asList(value.split("")));
        for (String s :
                digitOfNumbers) {
            counter += Math.pow(Double.parseDouble(s), 2);
        }
        if (counter == 1) {
            isHappy = true;
            return isHappy;
        }
        if (counters.contains(counter)) {
            isHappy = false;
            return isHappy;
        }
        counters.add(counter);
        happyCheck(String.valueOf(counter));
        return isHappy;
    }

    @Override
    public String toString() {
        return "Properties of " + value + "\n" +
                "buzz: " + isBuzz + "\n" +
                "duck: " + isDuck + "\n" +
                "palindromic: " + isPalindromic + "\n" +
                "gapful: " + isGapful + "\n" +
                "spy: " + isSpy  + "\n" +
                "square: " + isSquare  + "\n" +
                "sunny: " + isSunny  + "\n" +
                "jumping: " + isJumping  + "\n" +
                "happy: " + isHappy  + "\n" +
                "sad: " + !isHappy  + "\n" +
                "even: " + isEven + "\n" +
                "odd: " + !isEven;
    }
}