package Day02.part2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2_2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("/home/jude/Documents/Advent-Of-Code-23/Day02/part1/input.txt"));
            List<String[]> games = new ArrayList<>();
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(":");
                games.add(line[1].split(";"));
            }

            System.out.printf("VALUE IS : %d\n" , ReturnValidRounds(games));
        } finally {
            sc.close();
        }
    }

    public static int ReturnValidRounds(List<String[]> games) {
        int sum = 0;
        for (int i = 0; i < games.size(); i++) {
            int maxBlue = Integer.MIN_VALUE;
            int maxRed = Integer.MIN_VALUE;
            int maxGreen = Integer.MIN_VALUE;

            for (String round : games.get(i)) {

                for (String Color : round.split(",")) {
                    String[] blocks = Color.split(" ");

                    switch (blocks[2]) {
                        case "blue":
                            if (Integer.parseInt(blocks[1]) > maxBlue) {
                                maxBlue = Integer.parseInt(blocks[1]);
                            }
                            break;
                        case "red":
                            if (Integer.parseInt(blocks[1]) > maxRed) {
                                maxRed = Integer.parseInt(blocks[1]);
                            }
                            break;
                        case "green":
                            if (Integer.parseInt(blocks[1]) > maxGreen) {
                                maxGreen = Integer.parseInt(blocks[1]);
                            }
                            break;

                    }
                }
            }
            sum += maxBlue * maxRed * maxGreen;

        }
        return sum;
    }
}
