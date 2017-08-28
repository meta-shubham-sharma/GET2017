package com.metacube.sortedLinkedList;

import java.util.LinkedList;

public class MyLinkedList {

	LinkedList<Integer> list;
	private int index;
	
	public MyLinkedList() {
		list = new LinkedList<Integer>();
		index = 0;
	}

	public void add(int item1, int index) {
		if (list.isEmpty()) {
			list.add(item1);
		} else if (item1 < list.getFirst()) {
			list.addFirst(item1);
		} else if ( item1 < list.get(index) ) {
			list.add(index, item1);
		} 
		else { 
			if (index == list.size()-1) {
				list.addLast(item1);
			} else {
				index++;
				add(item1, index);
			}
		}
	}

	public LinkedList<Integer> printList() {
		return list;
	}

	public void addValue(int item) {
		index = 0;
		add(item,index);
	}
}
