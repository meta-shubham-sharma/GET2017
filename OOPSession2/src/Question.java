/**
 * Question class to read operation
 * write operation and send the input to the Survey
 */
import java.io.*;
import java.util.*;

public class Question implements Comparable<Question> {
    
	String str;
	
	public Question(){
    	
    }
	
    public Question(String str){
    	this.str=str;
    }
	
    Scanner scan = new Scanner(System.in);				
	/**
	 * 
	 * @param filePath
	 * @return a 2D string matrix splitting the file input with ',' 
	 */
	public String[][] read(String filePath) {
		String questions[][] = {};
		int index = 0;
		try {
			FileInputStream fstream = new FileInputStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			while ( (str = br.readLine()) != null){
				rows++;
			}
			questions = new String[rows][];
			fstream = new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fstream));
			String str = "";
			while ((str = br.readLine()) != null) {								// Read the File Line By Line
				questions[index++] = str.split(",");							// split the values in string matrix  
			return questions;
			}
			br.close();
			} catch (Exception e) {
			return questions;
			}
	}

	/**
	 * 
	 * @param participant
	 * @param question
	 */
	public void getInput(int participant, String question[][]) {					

		for (int index = 0; index < question.length; index++) {
			for (int jindex = 0; jindex < question[index].length; jindex++) {
				System.out.println(question[index][jindex]);						// print questions for user to check	
			}
			if ("(Type) Single Select".equals(question[index][1])) {
				int answer = scan.nextInt();												
				while ( answer>5  ) {												// validate correct inputs from user	
					System.out.print("Enter correct option from 1 to 5");
					answer = scan.nextInt();
				}
				write("Participant" + " " + participant + "," + answer,				// write the values calculated into file to generate Report-B
						"C:/Users/User21/Desktop/Report-B.txt");
			} else if ("(Type) Multi Select".equals(question[index][1])) {
				String answer = scan.next();
				write("," + answer, "C:/Users/User21/Desktop/Report-B.txt");
			} else if ("(Type)Text".equals(question[index][1])) {
				String answer = scan.next();
				write("," + answer, "C:/Users/User21/Desktop/Report-B.txt");
			} else if ("(Type) Number".equals(question[index][1])) {
				long answer = scan.nextLong();
				while (String.valueOf(answer).length() != 10) {
					System.out.print("Enter 10 digit number");
					answer = scan.nextLong();
				}
				write("," + answer, "C:/Users/User21/Desktop/Report-B.txt");		
			}
		}
		write("-1", "C:/Users/User21/Desktop/Report-B.txt");						// write newline into file for next questions 
	}

	/**
	 * 
	 * @param text 
	 * @param filePath
	 */
	public void write(String text, String filePath) {							// perform write operation using the filepath and text to write
		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
					filePath), true));			
			if (text.equals("-1")) {
				bw.newLine();
			} else {
				bw.write(text);
			}
			bw.close();
		} catch (Exception e) {
		}
	}
	/**
	 * overriding the Comparable interface
	 */
	@Override
	public int compareTo(Question o) {
		// TODO Auto-generated method stub					
		String str1 = str; String str2 = o.str;
		return str1.compareTo(str2);
	}
	
	

}
