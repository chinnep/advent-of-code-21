import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException; 

public class PartTwo {
	public static void main(String[] args) {
		String[] move = new String[2];
		int distance = 0;
		int horizontal = 0;
		int depth = 0;
		int aim = 0;

		try {
			File myObj = new File("data.txt");
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				move = myReader.nextLine().split(" ");
				distance = Integer.parseInt(move[1]);
				switch (move[0]) {
					case "forward": 
						horizontal += distance;
						depth += aim*distance;
						break;
					case "up":
						aim-=distance;
						break;
					case "down":
						aim += distance;
						break;
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println("part two answer: " + depth*horizontal);
	}
}