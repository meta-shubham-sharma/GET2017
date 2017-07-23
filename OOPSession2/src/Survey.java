/**
 * Survey class that perform read operation, write operation 
 * calculate percentage distribution
 * reports A and B created
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Survey {
	
	public static void main(String args[]) {
		Scanner scan = null;
		try {
			Question obj = new Question();  			// object of question class that has data
			scan = new Scanner(System.in);
			
			String question[][] = {};

			System.out.println("Enter number of users to participate in survey :- ");	// enter the number of users that participate in survey
			int noOfUsers = scan.nextInt();
			
			question = obj.read("C:/Users/User21/Desktop/Questions.txt");        // read method of question class read the file Questions and return a 2D string matrix splitted with "," 

			for (int index = 0; index < noOfUsers; index++) {
				System.out.println("Survey starts here :-");
				obj.getInput(index + 1, question);								// get input from users according to the type of question and Report-B is generated 
				System.out.println();
			}

			question = obj.read("C:/Users/User21/Desktop/Report-B.txt");		// read inputs from the Report-B and split them in 2D question matrix
			
			int percentage[] = new int[6];							
			
			for (int index = 0; index < noOfUsers; index++) {
				percentage[Integer.parseInt(question[index][1])] += 1;			// calculate percentage distribution  	
			}
			
			for (int index = 1; index < 6; index++) {
					percentage[index] = (int) ((percentage[index] / (float) noOfUsers) * 100);		// write percentage distribution into the file generating Report-A
					obj.write(index + " - " + percentage[index] + "%",
							"C:/Users/User21/Desktop/Report-A.txt");
					obj.write("-1", "C:/Users/User21/Desktop/Report-A.txt");
				}
			
			question = obj.read("C:/Users/User21/Desktop/Questions.txt");		// read the file Questions.txt 
			
			List<Question> list = new ArrayList<Question>();
			
			for (int index = 0; index < question.length; index++) {				// add the values to the list of Questions			
				list.add(new Question(question[index][0]));
			}
			Iterator<Question> itr = list.iterator();				
			Collections.sort(list);
			while (itr.hasNext()) {
				System.out.println(itr.next().str);								
			}
		} catch (Exception except) {
			scan.close();
		}
	}
}
