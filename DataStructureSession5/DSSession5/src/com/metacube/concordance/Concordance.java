package com.metacube.concordance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Concordance {
	public static void main(String[] args) {
		
		
		String input = "";
		
		for(int index = 0 ; index < args.length;index++){
			input+=args[index];
		}
		
		input = input.replace(" ", "");
		
		String result = getConcordance(input);

		System.out.println(result);
	}

	public static String getConcordance(String input) {
		HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();

		for (int index = 0; index < input.length(); index++) {
			char letter = input.charAt(index);
			if (map.containsKey(letter)) {
				map.get(letter).add(index);
			} else {
				List<Integer> occurenceList = new ArrayList<Integer>();
				occurenceList.add(index);
				map.put(letter, occurenceList);
			}
		}

		return map.toString();
	}
}
