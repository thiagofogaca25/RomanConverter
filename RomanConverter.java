package Roman;

import java.util.Scanner;

public class RomanConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Write Roman: ");
            String roman = scanner.next();

            if (correct(roman) == false) {
                continue;
            }

            int result = romanToInt(roman);

            System.out.println(result);
            System.out.println("Proximo?(y/n)");
            String Answer = scanner.next();
            if (Answer.equalsIgnoreCase("n")) {
                break;
            }
        }
        System.out.println("GoodBye");

        scanner.close();
    }

    public static int romanToInt(String roman) {
        int result = 0;
        for (int i = 0; i < roman.length(); i++) {
            char ActualRomanChar = roman.charAt(i);
            int actualRomanValue = romanToValue(ActualRomanChar);
            if (i < roman.length() - 1) {
                char NextRomanChar = roman.charAt(i + 1);
                int nextRomanValue = romanToValue(NextRomanChar);
                if (actualRomanValue < nextRomanValue) {
                    result -= actualRomanValue;
                }
                if (actualRomanValue >= nextRomanValue) {
                    result += actualRomanValue;
                }
            } else {
                result += actualRomanValue;
            }

        }
        return result;
    }

    public static int romanToValue(char roman) {

        switch (roman) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;

            default:
                break;
        }

        return 1;
    }

    public static boolean correct(String roman) {
        return isValidLength(roman) && isValidRepetition(roman) && isValidRomanLength(roman)
                && isValidSubtraction(roman);
    }

    public static boolean isValidLength(String roman) {
        if (roman.length() >= 15) {
            System.out.println("Invalid Roman numeral");
            return false;
        }
        return true;
    }

    public static boolean isValidRomanLength(String roman) {
        for (int i = 0; i < roman.length(); i++) {
            char c = roman.charAt(i);

            if (c != 'I' &&
                    c != 'V' &&
                    c != 'X' &&
                    c != 'L' &&
                    c != 'C' &&
                    c != 'D' &&
                    c != 'M') {

                System.out.println("Invalid Roman numeral");
                return false;

            }
        }
        return true;
    }

    public static boolean isValidSubtraction(String roman) {
        for (int i = 0; i < roman.length(); i++) {
            char currentChar = roman.charAt(i);

            if (i < roman.length() - 1) {
                char nextChar = roman.charAt(i + 1);
                int actualRomanValue = romanToValue(currentChar);
                int nextRomanValue = romanToValue(nextChar);

                if (actualRomanValue < nextRomanValue) {
                    switch (currentChar) {
                        case 'I':
                            if (nextChar != 'V' && nextChar != 'X') {
                                System.out.println("Invalid Roman numeral");
                                return false;
                            }
                            break;
                        case 'X':
                            if (nextChar != 'L' && nextChar != 'C') {
                                System.out.println("Invalid Roman numeral");
                                return false;
                            }
                            break;
                        case 'C':
                            if (nextChar != 'D' && nextChar != 'M') {
                                System.out.println("Invalid Roman numeral");
                                return false;
                            }
                            break;

                        default:
                            System.out.println("Invalid Roman numeral");
                            return false;
                    }
                }
            }
        }

        return true;

    }

    public static boolean isValidRepetition(String roman) {
        int counterRepetition = 1;
        for (int i = 0; i < roman.length(); i++) {
            char currentChar = roman.charAt(i);

            if (i < roman.length() - 1) {
                char nextChar = roman.charAt(i + 1);

                if (currentChar == nextChar) {
                    counterRepetition++;
                } else {
                    counterRepetition = 1;
                }

                if ((currentChar == 'V' ||
                        currentChar == 'L' ||
                        currentChar == 'D') &&
                        currentChar == nextChar) {

                    System.out.println("Invalid Roman numeral");
                    return false;
                }

                if (counterRepetition > 3) {
                    System.out.println("Invalid Roman numeral");
                    return false;
                }

            }

        }
        return true;
    }
}
