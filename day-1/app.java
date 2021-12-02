import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;  // Import this class to handle errors

public class app {
    public static void main(String[] args) {
        final int DATA_LENGTH = 2000;
        int[] data = new int[DATA_LENGTH];
        int pointer = 0;
        int count = -1;
        int previousSum = -1;
        int newSum = 0;
        try {
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
              int num = Integer.parseInt(myReader.nextLine());
              data[pointer] = num;
              pointer++;
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        for (int i = 0; i < DATA_LENGTH-2; i++) {
            newSum = data[i] + data[i+1] + data[i+2];
            if(previousSum < newSum) count++;
            previousSum = newSum;
        }
        System.out.println(count);
    }
}