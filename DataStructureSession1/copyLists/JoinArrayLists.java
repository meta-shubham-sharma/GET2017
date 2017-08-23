package com.metacube.copyLists;

import com.metacube.arrayList.MyArrayList;

/**
 * @author shubham
 *
 * @param <E>
 */
public class JoinArrayLists<E> extends MyArrayList<E> {
	/**
	 * 
	 * @param list1
	 * @param list2
	 */
	public void joinTwoArrayList(MyArrayList<E> list1, MyArrayList<E> list2) {
		int size = list2.getSize();
		for (int index = 0; index < size; index++) {
			list1.addElement(list2.getElementByPosition(index));
		}
	}

}
