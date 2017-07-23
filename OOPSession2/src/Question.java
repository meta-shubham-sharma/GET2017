/**
 * Question class to read operation
 * write operation and send the input to the Survey
 */
import java.io.*;
import java.util.*;

public class Question extends QuestionUtility implements Comparable<Question> {
    
	String str;
	
	public Question(){
    	
    }
	
    public Question(String str){
    	this.str=str;
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
