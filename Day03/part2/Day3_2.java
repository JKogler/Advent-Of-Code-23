package Day03.part2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3_2 {

    public static int engineFixer(List<char[]> engine) {
        int sum = 0;
        for (int row = 0; row < engine.size(); row++) {
            char[] line = engine.get(row);

            for (int index = 0; index < line.length; index++) {
                if (line[index] == '*') {
                    List <Integer> listOfParts = gearPartFinder(engine, row, index);
                    if (listOfParts.size() == 2) {
                        sum += listOfParts.get(0) * listOfParts.get(1);
                    }
                }
            }
        }
        return sum;
    }

    public static List<Integer> gearPartFinder(List<char[]> engine, int indexRow, int indexCol) {
        List<Integer> gearParts = new ArrayList<>();
        boolean checkTop = false;
        boolean checkLeft = false;
        boolean checkRight = false;
        boolean checkBottom = false;
        char[] lineTop = new char[engine.get(indexRow).length];
        char[] lineBottom = new char[engine.get(indexRow).length];
        char[] line = engine.get(indexRow);
        if (indexRow != 0) {
            checkTop = true;
            lineTop = engine.get(indexRow - 1);
        }
        if (indexRow < engine.size() - 1) {
            checkBottom = true;
            lineBottom = engine.get(indexRow + 1);
        }
        if (indexCol != 0) {
            checkLeft = true;
        }
        if (indexCol < engine.get(indexRow).length - 1) {
            checkRight = true;
        }

        if (checkLeft) {
            if (Character.isDigit(line[indexCol - 1])) {
                gearParts.add(returnNr(line, indexCol - 1));
            }
        }

        if (checkRight) {
            if (Character.isDigit(line[indexCol + 1])) {
                gearParts.add(returnNr(line, indexCol + 1));
            }

        }
        if (checkBottom) {
            if (Character.isDigit(lineBottom[indexCol])) {
                gearParts.add(returnNr(lineBottom, indexCol));
            } else {
                if (checkLeft) {
                    if (Character.isDigit(lineBottom[indexCol - 1])) {
                        gearParts.add(returnNr(lineBottom, indexCol - 1));
                    }
                }
                if (checkRight) {
                    if (Character.isDigit(lineBottom[indexCol + 1])) {

                        gearParts.add(returnNr(lineBottom, indexCol + 1));
                    }
                }
            }
        }
        if (checkTop) {
            if (Character.isDigit(lineTop[indexCol])) {
                gearParts.add(returnNr(lineTop, indexCol));
            } else {
                if (checkLeft) {
                    if (Character.isDigit(lineTop[indexCol - 1])) {
                        gearParts.add(returnNr(lineTop, indexCol - 1));
                    }
                }
                if (checkRight) {
                    if (Character.isDigit(lineTop[indexCol + 1])) {
                        gearParts.add(returnNr(lineTop, indexCol + 1));
                    }
                }
            }
        }

        return gearParts;
    }

    public static int returnNr(char[] line, int index) {
        int endIndex = index;
        int startIndex = index;
        while (endIndex < line.length - 1 && Character.isDigit(line[endIndex + 1])) {
            endIndex++;
        }
        while (startIndex > 0 && Character.isDigit(line[startIndex - 1])) {
            startIndex--;
        }

        return Integer.parseInt(new String(line).substring(startIndex, endIndex + 1));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("/home/jude/Documents/Advent-Of-Code-23/Day03/part1/input.txt"));
            List<char[]> engine = new ArrayList<>();
            while (sc.hasNextLine()) {
                engine.add(sc.nextLine().toCharArray());
            }
            System.out.printf("Sum of surrounding gears : %d\n", engineFixer(engine));
        } finally {
            sc.close();
        }
    }
}
