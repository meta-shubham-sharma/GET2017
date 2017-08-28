package com.metacube.sortedLinkedList;

import java.util.LinkedList;

public class MyLinkedList {

	LinkedList<Integer> list;
	private int index;
	
	public MyLinkedList() {
		list = new LinkedList<Integer>();
		index = 0;
	}

	public void add(int item1, int item2) {
		if (list.isEmpty()) {
			list.add(item1);
		} else if (item1 < list.getFirst()) {
			list.addFirst(item1);
		} else if (item1 < item2) {
			list.add(index, item1);
		} 
		else { 
			if (index == list.size()-1) {
				list.addLast(item1);
			} else {
				index++;
				item2 = list.get(index);
				add(item1, item2);
			}
		}
	}

	public LinkedList<Integer> printList() {
		return list;
	}

	public void addValue(int item) {
		index = 0;
		add(item,item);
	}
}
