package com.metacube.assignment2;

import java.util.ArrayList;
import java.util.List;

public class MyHashTable<E, V> {

	private Object[] roomBucket;

	public MyHashTable() {
		roomBucket = new Object[13];
	}

	@SuppressWarnings("unchecked")
	public void insertValue(E key, V value) {
		if (key == null || value == null) {
			throw new IllegalArgumentException();
		}
		MyHashNode<E, V> room = new MyHashNode<E, V>();
		int MyKey = hashFunction(key);
		if (roomBucket[MyKey] == null) {
			room.setKey((E) String.valueOf(MyKey));
			room.setValue(value);
			roomBucket[MyKey] = room;
			Guest guest = (Guest) ((MyHashNode<E, V>) roomBucket[MyKey])
					.getValue();
			guest.setRoom(MyKey + 1);

		} else {
			int index = 0;
			for (index = 0; index < roomBucket.length; index++) {
				if (roomBucket[index] == null && index != MyKey) {
					room.setKey((E) String.valueOf(index));
					room.setValue(value);
					roomBucket[index] = room;
					break;
				}
			}
			if (index < roomBucket.length) {
				Guest guest = (Guest) ((MyHashNode<E, V>) roomBucket[index])
						.getValue();
				guest.setRoom(index + 1);
			} else {
				System.out.println("No rooms available !!");
			}
		}
	}

	public int hashFunction(E key) {
		int hash = key.hashCode() % roomBucket.length;
		return hash;
	}

	@SuppressWarnings("unchecked")
	public V getValue(int age, String name) {
		for (int index = 0; index < roomBucket.length; index++) {
			if (roomBucket[index] != null) {
				Guest guest = (Guest) ((MyHashNode<E, V>) roomBucket[index])
						.getValue();
				if (guest.getName().equals(name) && guest.getAge() == age) {
					return ((MyHashNode<E, V>) roomBucket[index]).getValue();
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<String> getAllValues() {
		List<String> allGuests = new ArrayList<String>();

		for (int index = 0; index < roomBucket.length; index++) {
			if (roomBucket[index] != null) {
				Guest guest = (Guest) ((MyHashNode<E, V>) roomBucket[index])
						.getValue();
				allGuests.add("\nName : " + guest.getName() + "\tAge : "
						+ guest.getAge() + "\tRoomNo. : " + guest.getRoom());
			}
		}
		return allGuests;
	}
}
