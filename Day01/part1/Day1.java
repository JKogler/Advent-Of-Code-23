import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Day1 {
   public static void main(String[] args) throws IOException {
      Scanner sc = null;
      Scanner tester = null;
      try {
         sc = new Scanner(new File("/home/jude/Documents/Advent-Of-Code-23/Day01/part1/input.txt"));
         tester = new Scanner(new File("/home/jude/Documents/Advent-Of-Code-23/Day01/part1/test.txt"));

         // Go through all lines
         System.out.printf("Sum for input : %d \n sum for test : %d \n", SumCalculator(sc), SumCalculator(tester));

      } finally {
         sc.close();

      }
   }

   // function that reads all lines and sums up numbers in line comprised of pairs
   // FIRSTDIGIT|FINALDIGGIT
   private static int SumCalculator(Scanner sc) {
      int finalSum = 0;
      while (sc.hasNextLine()) {
         Integer FirstNumber = null;
         Integer LastNumber = null;
         char[] line = sc.nextLine().toCharArray();
         for (int i = 0; i < line.length; i++) {
            int j = line.length - 1 - i;
            char charAtI = line[i];
            char charAtJ = line[j];

            if (FirstNumber == null && Character.isDigit(charAtI)) {
               FirstNumber = (int) charAtI - 48; // ASCII CODES --> 0 = 48
            }

            if (LastNumber == null && Character.isDigit(charAtJ)) {
               LastNumber = (int) charAtJ - 48;
            }
         }
         finalSum += FirstNumber * 10 + LastNumber;
      }
      return finalSum;
   }
}
