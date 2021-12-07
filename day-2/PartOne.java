import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException; 

public class PartOne {
  public static void main(String[] args) {
    String[] move = new String[2];
    int depth = 0;
    int horizontal = 0;

    try {
      File myObj = new File("data.txt");
      Scanner myReader = new Scanner(myObj);

      while (myReader.hasNextLine()) {
        move = myReader.nextLine().split(" ");
        
        switch (move[0]) {
          case "forward": 
          horizontal += Integer.parseInt(move[1]);
            break;
          case "up":
            depth -= Integer.parseInt(move[1]);
            break;
          case "down":
            depth += Integer.parseInt(move[1]);
            break;
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    System.out.println("part one answer: " + depth*horizontal);
  }
}