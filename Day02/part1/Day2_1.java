package Day02.part1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2_1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("/home/jude/Documents/Advent-Of-Code-23/Day02/part1/input.txt"));
            List<String[]> games = new ArrayList<>();
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(":");
                games.add(line[1].split(";"));
            }

            System.out.println(ReturnValidRounds(games, 12, 13, 14)); 
        } finally {
            sc.close();
        }
    }

    public static int ReturnValidRounds(List<String[]> games, int maxRed, int maxGreen, int maxBlue) {
        int sum = 0;
        for (int i = 0; i < games.size(); i++) {
            boolean isValid = true; 
            for (String round : games.get(i)) {
               
                for (String Color : round.split(",")) {
                    String[] blocks = Color.split(" ");

                    switch (blocks[2]) {
                        case "blue":
                            if (Integer.parseInt(blocks[1]) > maxBlue) {
                                isValid = false;
                            }
                            break;
                        case "red":
                            if (Integer.parseInt(blocks[1]) > maxRed) {
                                isValid = false;
                            }
                            break;
                        case "green":
                            if (Integer.parseInt(blocks[1]) > maxGreen) {
                                isValid = false;
                            }
                            break;

                    }
                }
            }
            if (isValid) {
                sum += i +1;
            }
            
        }
        return sum;
    }
}
