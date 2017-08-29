package com.metacube.assignment2;

import java.util.List;

public class RoomAllocation {

	MyHashTable<Integer,Guest> hashTable = new MyHashTable<Integer,Guest>();
	
	public void addGuest(String name , int age){
		Guest guest = new Guest();
		guest.setName(name);
		guest.setAge(age);
		hashTable.insertValue(age, guest);
	}
	
	public Guest getGuest(int age,String name){
		Guest guest = hashTable.getValue(age,name);
		return guest;
	}
	
	public String getAllGuest(){
		List<String> guests = hashTable.getAllValues();
		String allGuests = "";
		if(guests.isEmpty()){
			allGuests+="No Guests are present currently !!";
		}
		else{
			allGuests+=guests.toString();
		}
		return allGuests;
	}
}
