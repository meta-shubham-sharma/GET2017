package com.metacube.assignment2;

import java.util.HashMap;

public class CheckString {

	HashMap<String, Integer> map;

	public CheckString() {
		map = new HashMap<String, Integer>();
	}

	/**
	 * 
	 * @param input
	 * @return integral value of number of distinct characters
	 */
	public int checkUniqueCharachtersFromString(String input) {
		int output = 0;	
		if(map.containsKey(input)){
				output = map.get(input);
			}
		else{
			output = (int)input.chars().distinct().count();
			map.put(input, output);
		}
		return output;
	}
}
