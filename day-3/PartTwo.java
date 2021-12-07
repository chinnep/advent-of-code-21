import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException; 

public class PartTwo {
  public static void main(String[] args) {
    try {
      File myObj = new File("data.txt");
      Scanner myReader = new Scanner(myObj);

      // Start here
      ArrayList<String> data_o = new ArrayList<String>();
      ArrayList<String> data_c = new ArrayList<String>();
      final int bitLength = 5;
      String oxygenGeneratorRating = "";
      String co2ScrubberRating = "";
      String mostCommon, leastCommon;

      while (myReader.hasNextLine()) {
        data_o.add(myReader.nextLine());
      }

      //make a copy...
      data_c = new ArrayList<String>(data_o);

      for (int i = 0; i < bitLength; i++) {
        mostCommon = findMostCommon(data_o, i);
        leastCommon = findLeastCommon(data_c, i);

        oxygenGeneratorRating += mostCommon.equals("0.5") ? "1" : mostCommon;
        co2ScrubberRating += mostCommon.equals("0.5") ? "0" : leastCommonCommon;

        data_o = cleanData(data_o, oxygenGeneratorRating);
        data_c = cleanData(data_c, co2ScrubberRating);
      }
 
      System.out.println("part two answer: " + oxygenGeneratorRating+' co2: '+ co2ScrubberRating);

      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  // If the average is BELOW 0.5 then the most common digit is 0
  // If the average is ABOVE 0.5 then the most common digit is 1
  // If the average is EQUAL TO 0.5 then then we need to know to stop
  public static String findMostCommon(ArrayList<String> data, int index) {
    double sum = 0;
    for(String reading : data) {
      sum += Character.getNumericValue(reading.charAt(index));
    }
    return sum/data.size() < 0.5 
      ? "0" 
      : sum/data.size() == 0.5
        ? "0.5"
        : "1";
  }

  public static String findLeastCommon(ArrayList<String> data, int index) {
    double sum = 0;
    for(String reading : data) {
      sum += Character.getNumericValue(reading.charAt(index));
    }
    return sum/data.size() < 0.5 
      ? "1" 
      : sum/data.size() == 0.5
        ? "0.5"
        : "0";
  }

  public static ArrayList<String> cleanData(ArrayList<String> data, String toMatch) {
    if(data.size() == 1) return data;

    ArrayList<String> result = (ArrayList<String>) data.stream().filter(reading -> reading.substring(0, toMatch.length()).equals(toMatch));

    if (result.size() < 1) return data;
    return result;
  }
}