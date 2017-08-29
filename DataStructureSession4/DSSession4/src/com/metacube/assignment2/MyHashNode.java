package com.metacube.assignment2;

public class MyHashNode<E, V> {
	
	E key;V value;
	/**
	 * @return the key
	 */
	public E getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(E key) {
		this.key = key;
	}
	/**
	 * @return the value
	 */
	public V getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(V value) {
		this.value = value;
	}
}
