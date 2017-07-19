/*
 * class to find all the permutations of a given string
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
	
	Set<String> s = new HashSet<String>();
	String prefix="",prefix1="";
	
	public List<String> generatePermutations(String input)
	{
		permute(prefix,input);	
		List<String> list = new ArrayList<String>(s);
		return list;
	}
	/**
	 * 
	 * @param prefix
	 * @param input
	 */
	public void permute(String prefix,String input)
	{
		if(input.equals(""))
		{
			s.add(prefix); // add the element 
		}
		else
		{
			for(int index = 0;index < input.length(); index++)
			{
				prefix1 = prefix + input.charAt(index);		// compute the prefix of the input
				StringBuilder sb= new StringBuilder(input);
				String temp=sb.deleteCharAt(index).toString();	// delete prefix from the input
				permute(prefix1,temp);			// recursively call the method for a new prefix and input
			}
		}
	}
	
	public static void main(String args[])
	{
		Permutations obj = new Permutations();
		List<String> result = obj.generatePermutations("AAC");
		System.out.print(result);
	}
}
