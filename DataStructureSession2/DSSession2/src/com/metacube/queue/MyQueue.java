package com.metacube.queue;

public class MyQueue {
	
	Object array[];
	private int MAX = 5,front,rear,size=0,newSize = 5;
	
	public MyQueue(){
		array = new Object[MAX];
		front = 0;
		rear = -1;
	}
	/**
	 * empty queue
	 */
	public void makeEmpty(){
		Object newArray[] = new Object[MAX];
		this.array = newArray;
	}
	/**
	 * add to queue
	 * @param item
	 */
	public void enqueue(Object item){
		if(getSize() == 0){
			rear = -1;
			front = 0;
			array = new Object[newSize];
		}
		if(rear == newSize-1){
			array = resize(array);
			newSize += MAX;
		}
		array[++rear] = item;
		size++;
	}
	/**
	 * 
	 * @return item 
	 */
	public Object dequeue(){
		if(front > rear ){
			return new Exception();
		}
		size--;
		return array[front++];
	}
	
	/**
	 * 
	 * @return size
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * 
	 * @param array
	 * @return resized array
	 */
	public Object[] resize(Object[] array){
		Object[] newArray = new Object[array.length + MAX];
		for(int index = 0 ; index < array.length ; index++){
			newArray[index] = array[index];
		}
		return newArray;
	}
	
	/**
	 * 
	 * @return front element
	 */
	public Object getFront(){
		if(front > rear){
			return new Exception();
		}
		else{
			return array[front];
		}
	}
}
