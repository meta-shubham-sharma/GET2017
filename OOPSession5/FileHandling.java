package SocialNetwork;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileHandling {
	FileInputStream fstream;
	BufferedReader br;
	String str = "";
	StringBuffer buf = new StringBuffer();
	
	public String read(String filepath){
		try {
			fstream = new FileInputStream(filepath);
			br = new BufferedReader(new InputStreamReader(fstream));
			while ((str = br.readLine()) != null) {
				buf.append(str);
				buf.append("\n");
				/**/
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return buf.toString();
	}
	
	
}
