package numbers;

import java.util.*;

public class Main {

    public static String wrongProperty;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printInstruction();
        while (true) {
            System.out.println("\nEnter a request:");
            String input = sc.nextLine();
            String[] inputSplit = input.split(" ");
            // handler errors input
            try {
                checkInputForInvalidArgument(input);
            } catch (InvalidParamException e) {
                switch (e.getParam()) {
                    case 1:
                        System.out.println("The first parameter should be a natural number or zero.");
                        break;
                    case 2:
                        System.out.println("The second parameter should be a natural number.");
                        break;
                    case 3:
                        System.out.println("The request contains mutually exclusive properties: [ODD, EVEN]\n" +
                                "There are no numbers with these properties.");
                        break;
                    case 4:
                        System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY]\n" +
                                "There are no numbers with these properties.");
                        break;
                    case 5:
                        System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]\n" +
                                "There are no numbers with these properties.");
                        break;
                    case 6:
                        System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD]\n" +
                                "There are no numbers with these properties.");
                        break;
                    case 7:
                        System.out.println("The request contains mutually exclusive properties: [" + wrongProperty.toUpperCase(Locale.ROOT) + ", -" + wrongProperty.toUpperCase(Locale.ROOT) + "]\n" +
                                "There are no numbers with these properties.");
                        break;
                    case 8:
                        System.out.println("The request contains mutually exclusive properties: [-ODD, -EVEN]\n" +
                                "There are no numbers with these properties.");
                        break;
                    case 10:
                        System.out.println("The request contains mutually exclusive properties: [-DUCK, -SPY]\n" +
                                "There are no numbers with these properties.");
                        break;
                    case 11:
                        System.out.println("The request contains mutually exclusive properties: [-HAPPY, -SAD]\n" +
                                "There are no numbers with these properties.");
                        break;
                    default:
                        System.out.println("The invalid parameter.");
                }
                continue;
            }

            if (input.equals("0")) {
                break;
            }
            if (inputSplit.length == 1) {
                Number sourceNumber = new Number(input);
                System.out.println(sourceNumber);
            } else if (inputSplit.length == 2) {
                for (SeveralNumbers severalNumbers :
                        SeveralNumbers.createArrayNumbers(input)) {
                    System.out.println(severalNumbers);
                }
            } else if (inputSplit.length > 2) {
                ArrayList<String> arrayOfProperties = new ArrayList<>(Arrays.asList(Arrays.copyOfRange(inputSplit, 2, inputSplit.length)));
                ArrayList<String> arrayOfWrongProperties = checkArrayProperties(arrayOfProperties);
                if (arrayOfWrongProperties.size() > 0) {
                    if (arrayOfWrongProperties.size() == 1) {
                        System.out.println("The property " + arrayOfWrongProperties.toString().toUpperCase() + " is wrong.\n" +
                                "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                    } else {
                        System.out.println("The properties " + arrayOfWrongProperties.toString().toUpperCase() + " are wrong.\n" +
                                "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                    }
                    continue;
                }

                for (SeveralNumbers severalNumbers :
                        SeveralNumbers.createArrayNumbersForProperties(input)) {
                    System.out.println(severalNumbers);
                }
            }
        }

        System.out.println("Goodbye!");
        sc.close();
    }

    public static void printInstruction() {
        System.out.println("Welcome to Amazing Numbers!\n" +
                "\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
    }

    public static void checkInputForInvalidArgument(String input) throws InvalidParamException {
        String[] numbersInput = input.split(" ");
        String firstNumber = numbersInput[0];
        if (numbersInput.length == 1) {
            checkFirstArgument(firstNumber);
        } else if (numbersInput.length == 2) {
            String secondNumber = numbersInput[1];
            checkFirstArgument(firstNumber);
            checkSecondArgument(secondNumber);
        } else {
            String secondNumber = numbersInput[1];
            ArrayList<String> evenOdd = new ArrayList(List.of("even", "odd"));
            ArrayList<String> evenOdd1 = new ArrayList(List.of("-even", "-odd"));
            ArrayList<String> sunnySquare = new ArrayList(List.of("sunny", "square"));
            ArrayList<String> duckSpy = new ArrayList(List.of("duck", "spy"));
            ArrayList<String> duckSpy1 = new ArrayList(List.of("-duck", "-spy"));
            ArrayList<String> happySad = new ArrayList(List.of("happy", "sad"));
            ArrayList<String> happySad1 = new ArrayList(List.of("-happy", "-sad"));
            ArrayList<String> arrayOfProperties = new ArrayList<>(Arrays.asList(Arrays.copyOfRange(numbersInput, 2, numbersInput.length)));
            if (arrayOfProperties.containsAll(evenOdd)) {
                throw new InvalidParamException(3);
            } else if (arrayOfProperties.containsAll(sunnySquare)) {
                throw new InvalidParamException(4);
            } else if (arrayOfProperties.containsAll(duckSpy)) {
                throw new InvalidParamException(5);
            } else if (arrayOfProperties.containsAll(happySad)) {
                throw new InvalidParamException(6);
            } else if (arrayOfProperties.containsAll(evenOdd1)) {
                throw new InvalidParamException(8);
            } else if (arrayOfProperties.containsAll(duckSpy1)) {
                throw new InvalidParamException(10);
            } else if (arrayOfProperties.containsAll(happySad1)) {
                throw new InvalidParamException(11);
            }
            for (String s :
                    arrayOfProperties) {
                if (s.startsWith("-") && arrayOfProperties.contains(s.substring(1))) {
                    wrongProperty = s;
                    throw new InvalidParamException(7);
                }
                if (!s.startsWith("-") && arrayOfProperties.contains("-" + s)) {
                    wrongProperty = s;
                    throw new InvalidParamException(7);
                }
            }
            checkFirstArgument(firstNumber);
            checkSecondArgument(secondNumber);
            checkArrayProperties(arrayOfProperties);
        }
    }

    public static void checkFirstArgument(String firstArgument) throws InvalidParamException {
        try {
            Long.parseLong(firstArgument);
        } catch (NumberFormatException e) {
            throw new InvalidParamException(1);
        }
        if (Long.parseLong(firstArgument) < 0) {
            throw new InvalidParamException(1);
        }
    }

    public static void checkSecondArgument(String secondArgument) throws InvalidParamException {
        try {
            Integer.parseInt(secondArgument);
        } catch (Exception e) {
            throw new InvalidParamException(2);
        }
        if (Integer.parseInt(secondArgument) <= 0) {
            throw new InvalidParamException(2);
        }
    }

    public static ArrayList<String> checkArrayProperties(ArrayList<String> arrayOfProperties) {
        ArrayList<String> wrongProperties = new ArrayList<>();
        ArrayList<String> arrayListEnumProperties = new ArrayList<>();
        for (Properties s :
                Properties.values()) {
            arrayListEnumProperties.add(s.getName());
            arrayListEnumProperties.add("-" + s.getName());
        }
        for (String s :
                arrayOfProperties) {
            if (!arrayListEnumProperties.contains(s.toUpperCase())) {
                wrongProperties.add(s);
            }
        }
        return wrongProperties;
    }
}
