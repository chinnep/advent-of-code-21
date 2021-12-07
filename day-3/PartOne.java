import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException; 

public class PartOne {
  final static int DATA_LENGTH = 1000;
	public static void main(String[] args) {

		String binary = "";
		int gamma = 0;
		int epsilon = 0;
		double[] sums = new double[12];
    String[] result = new String[2];

		try {
			File myObj = new File("data.txt");
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				binary = myReader.nextLine();
				for(int i = 0; i < binary.length(); i++) {
					sums[i]+=Character.getNumericValue(binary.charAt(i));
				}
			}

			result = calculateGammaEpsilon(sums);

      // convert from binary with base 2
      gamma = Integer.parseInt(result[0],2);
      epsilon = Integer.parseInt(result[1],2);  
		  System.out.println("part one answer: " + gamma*epsilon);

			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

  // gamma will be result[0], & epsilon will be result[1]
  // If the average is below 0.5 then the most common digit is 0 and vice versa
	public static String[] calculateGammaEpsilon(double[] sums) {
		String[] result = {"",""};
		for(int i = 0; i < sums.length; i++) {
			if(sums[i]/DATA_LENGTH < 0.5) {
        result[0] += "0";
        result[1] +="1";
      } else {
        result[0] += "1";
        result[1] +="0";
      }
		}
		return new String[]{result[0], result[1]};
	}
}