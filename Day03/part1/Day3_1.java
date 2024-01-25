package Day03.part1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3_1 {
    public static int engineFixer(List<char[]> engine) {
        int sum = 0;
        for (int row = 0; row < engine.size(); row++) {
            char[] line = engine.get(row);

            for (int index = 0; index < line.length; index++) {
                if (Character.isDigit(line[index])) {
                    int endIndex = returnEndOfNr(line, index);
                    if (isAValidGear(engine, row, index, endIndex)) {
                        String strLine = new String(line);
                        int gearNr = Integer.parseInt(strLine.substring(index, endIndex + 1));
                        sum += gearNr;
                    }
                    index = endIndex;
                }
            }
        }
        return sum;
    }

    public static boolean isAValidGear(List<char[]> engine, int indexOfRow, int indexColumnStart, int indexColumnEnd) {
        boolean checkTop = false;
        boolean checkLeft = false;
        boolean checkRight = false;
        boolean checkBottom = false;
        char[] lineTop = new char[engine.get(indexOfRow).length];
        char[] lineBottom = new char[engine.get(indexOfRow).length];
        char[] line = engine.get(indexOfRow);
        if (indexOfRow != 0) {
            checkTop = true;
            lineTop = engine.get(indexOfRow - 1);
        }
        if (indexOfRow < engine.size() - 1) {
            checkBottom = true;
            lineBottom = engine.get(indexOfRow + 1);
        }
        if (indexColumnStart != 0) {
            checkLeft = true;
        }
        if (indexColumnEnd < engine.get(indexOfRow).length - 1) {
            checkRight = true;
        }

        for (int checker = indexColumnStart; checker <= indexColumnEnd; checker++) {
            if (checker == indexColumnStart && checkLeft) {

                if (!isNotValidChar(line[checker - 1])) {
                    return true;
                }
                if (checkBottom) {
                    if (!isNotValidChar(lineBottom[checker - 1])) {
                        return true;
                    }
                }
                if (checkTop) {
                    if (!isNotValidChar(lineTop[checker - 1])) {
                        return true;
                    }
                }

            }
            if (checker == indexColumnEnd && checkRight) {

                if (!isNotValidChar(line[checker + 1])) {
                    return true;
                }
                if (checkBottom) {
                    if (!isNotValidChar(lineBottom[checker + 1])) {
                        return true;
                    }
                }
                if (checkTop) {
                    if (!isNotValidChar(lineTop[checker + 1])) {
                        return true;
                    }
                }

            }

            if (checkBottom) {
                if (!isNotValidChar(lineBottom[checker])) {
                    return true;
                }
            }

            if (checkTop) {
                if (!isNotValidChar(lineTop[checker])) {
                    return true;
                }
            }
        }

        return false;

    }

    public static int returnEndOfNr(char[] line, int startIndex) {
        int endIndex = startIndex;
        while (endIndex < line.length - 1 && Character.isDigit(line[endIndex + 1])) {
            endIndex++;
        }
        return Math.min(endIndex, line.length);
    }

    private static boolean isNotValidChar(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9') ||
                (c == '.');
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("/home/jude/Documents/Advent-Of-Code-23/Day03/part1/input.txt"));
            List<char[]> engine = new ArrayList<>();
            while (sc.hasNextLine()) {
                engine.add(sc.nextLine().toCharArray());
            }
            System.out.printf("final sum is : %d\n", engineFixer(engine));
        } finally {
            sc.close();
        }
    }
}
