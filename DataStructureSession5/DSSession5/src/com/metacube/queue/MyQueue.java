package com.metacube.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyQueue<E> {
	
	LinkedList<E> list = null;
	public MyQueue(){
		list = new LinkedList<E>();
	}
	
	public void enqueue(E item){
		list.add(item);
	}
	
	public E dequeue(){
		if(list.isEmpty()){
			throw new NoSuchElementException();
		}
		return list.removeFirst();
	}
	
	public LinkedList<E> printQueue(){
		return list;
	}
	
	public E peek(){
		if(list.isEmpty()){
			throw new NoSuchElementException();
		}
		return list.getFirst();
	}
}
