package Day04.part1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4_1 {

    public static int checkWinners(Scanner sc) {
        int score = 0;
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(":");
            String[] winVsBet = line[1].split("\\|");
            String[] win = winVsBet[0].split("\\s+");
            String[] bet = winVsBet[1].split("\\s+");
            List <Integer> winningNr =convertToIntList(win);
            List <Integer> betNr = convertToIntList(bet);

            score += returnScore(winningNr, betNr);
            
        }

        return score;
    }

    public static List <Integer> convertToIntList (String [] s) {
        List <Integer> returnList = new ArrayList<>();
        for (int i = 1; i < s.length; i++) {
            returnList.add(Integer.parseInt(s[i]));
        }

        return returnList;
    }

    public static int returnScore(List<Integer> winers, List <Integer> bet){
        int count = -1;
        for (Integer nr : winers){
            if (bet.contains(nr)) {
                count++;
            }
        }
        if (count == -1) {
            return 0;
        }
        else {
            return (int) Math.pow(2,count);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("/home/jude/Documents/Advent-Of-Code-23/Day04/part1/input.txt"));
            System.out.println(checkWinners(sc));
        } finally {
            sc.close();
        }
    }
}
