package com.metacube.sortingSystem;

public class SortingSystem {

	private int array[];
	int size;

	public SortingSystem(int capacity) {
		size = 0;
		array = new int[capacity];
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	public void add(int value) {
		array[size++] = value;
	}

	public int[] getArray() {
		return array;
	}
	
	public boolean checkTotalDigits(int[] input){
		boolean flag = false;
		for (int index = 0; index < input.length; index++) {
			if( input[index] >= 100 ){
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	@Override
	public String toString(){
		String result = "";
		for (int index = 0; index < getSize(); index++) {
			result+=array[index]+" ";
		}
		return result;
	}
	
	public boolean checkLength(int num){
		if(num<10){
			return true;
		}
		else{
			return false;
		}
	}
}
