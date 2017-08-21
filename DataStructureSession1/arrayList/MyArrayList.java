package com.metacube.arrayList;

/**
 * @author shubham
 *
 * @param <E>
 */
public class MyArrayList<E> {

	Object[] array = null;
	static int MAX = 5;
	
	public MyArrayList() {
		array = new Object[MAX];
	}
	/**
	 * 
	 * @param element
	 */
	public void addElement(E element) {
		if (getSize() == MAX) {
			this.array = resize(this.array);
		} 
			int index = getSize();
			array[index] = element;
	}
	/**
	 * 
	 * @param index
	 * @param element
	 * @return boolean
	 */
	public boolean setElement(int index, E element) {
		
		if(index > getSize()){
			return false;
		}
		 else {
			if (getSize() == MAX) {
				array = resize(array);
			}
			for (int jindex = getSize() - 1; jindex >= index; jindex--) {
				array[jindex+1] = array[jindex];
			}
			array[index] = element;
			return true;
		}
	}
	/**
	 * 
	 * @param array
	 */
	public Object[] resize(Object[] array) {
		Object[] newArray = new Object[array.length + MAX];
		for (int index = 0; index < array.length; index++) {
			newArray[index] = array[index];
		}
		return newArray;
	}
	/**
	 * 
	 * @return size
	 */
	public int getSize() {
		int index = 0;
		for (index = 0; index < this.array.length; index++) {
			if (array[index] == null) {
				break;
			}
		}
		return index;
	}
	/**
	 * 
	 * @param element
	 * @return position of element
	 */
	public int getElement(E element) {
		int index;
		for (index = 0; index < getSize(); index++) {
			if ( (array[index]).equals(element) ) {
				return index+1;
			}
		}
		return -1;
	}
	/**
	 * 
	 * @param position
	 * @return boolean
	 */
	public boolean removeElementFromPosition(int position) {
		if(position >= getSize()){
			return false;
		}
		for (int index = position; index < getSize()-1; index++) {
			array[index] = array[index + 1];
		}
		array[getSize() - 1] = null;
		return true;
	}
	/**
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean removeElement(E element){
		for(int index = 0;index < getSize() ; index++){
			if ( (array[index]).equals(element) ){
				for(int jindex = index;jindex < getSize()-1 ; jindex++){
					array[jindex] = array[jindex+1];
				}
				array[getSize() - 1] = null;
				return true;
			}
		}
		return false;
	}

	public void clearArrayList(){
		Object[] newArray = new Object[MAX];
		array = newArray;
	}
	
	public void reverseArrayList(){
		Object[] newArray = new Object[array.length];
		int jindex = 0;
		for(int index = getSize()-1 ; index >=0  ; index--){
			newArray[jindex++] = array[index];
		}
			this.array = newArray;
	}
	/**
	 * 
	 * @param position
	 * @return element by position
	 */
	@SuppressWarnings("unchecked")
	public E getElementByPosition(int position){
		return (E)array[position];
	}
	
	public Object[] printArrayList(){
		return this.array;
	}
	@SuppressWarnings("unchecked")
	public void sortArrayList(){
		for(int index = 0; index < getSize() ; index++){
			for(int jindex = index+1; jindex < getSize() ; jindex++){
				if(((Comparable<E>) array[index]).compareTo((E) array[jindex]) > 0) {
					Object temp = array[jindex];
					array[jindex] = array[index];
					array[index] = temp;
				}
			}
		}
	}
	
}
