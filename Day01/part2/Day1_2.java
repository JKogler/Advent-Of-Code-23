import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day1_2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = null;
        Scanner tester = null;
        try {
             sc = new Scanner(new File("/home/jude/Documents/Advent-Of-Code-23/Day01/part2/input.txt"));
            tester = new Scanner(new File("/home/jude/Documents/Advent-Of-Code-23/Day01/part2/test.txt"));

            // Go through all lines
            System.out.printf("Sum for input : %d \n sum for test : %d \n", SumCalculator(sc), SumCalculator(tester));

        } finally {
            tester.close();

        }
    }

    // function that reads all lines and sums up numbers in line comprised of pairs
    // FIRSTDIGIT|FINALDIGGIT
    private static int SumCalculator(Scanner sc) {
        int finalSum = 0;
        while (sc.hasNextLine()) {
            Integer FirstNumber = null;
            Integer LastNumber = null;
            String newLine = sc.nextLine();
            char[] line = newLine.toCharArray();

            for (int i = 0; i < line.length; i++) {
                int j = line.length - 1 - i;
                char charAtI = line[i];
                char charAtJ = line[j];

                if (FirstNumber == null) {
                    if (Character.isDigit(charAtI)) {
                        FirstNumber = (int) charAtI - 48; // ASCII CODES --> 0 = 48
                    } else {
                        int ret = returnString(newLine, i, true);
                        if (ret != 0) {
                            FirstNumber = ret;
                        }
                    }

                }

                if (LastNumber == null) {
                    if (Character.isDigit(charAtJ)) {
                        LastNumber = (int) charAtJ - 48;
                    } else {
                        int ret = returnString(newLine, j + 1, false);
                        if (ret != 0) {
                            LastNumber = ret;
                        }
                    }

                }
            }
            finalSum += FirstNumber * 10 + LastNumber;
        }
        return finalSum;
    }

    public static Integer returnString(String line, int start, boolean directionForward) {
        int i = 3;
        try {
            while (i <= 5) {
                String sub;
                if (directionForward) {
                    sub = line.substring(start, Math.min(start + i, line.length()));
                    
                } else {
                    sub = line.substring(Math.max(start - i, 0), start);
                }
                i++;
                int checker = returnStringToInt(sub);
                if (checker != 0) {
                    return checker;
                }
            }

        } catch (IndexOutOfBoundsException e) {
            // Handle the IndexOutOfBoundsException
            System.err.println("IndexOutOfBoundsException caught: " + e.getMessage());

        }

        return 0;

    }

    private static int returnStringToInt(String S) {
        switch (S) {
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            default:
                return 0;
        }

    }

}
