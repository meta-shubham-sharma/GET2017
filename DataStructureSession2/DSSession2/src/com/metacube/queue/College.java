package com.metacube.queue;
import java.util.HashMap;

public class College {
	int id;
	String name;
	int seatsAvailable;
	HashMap<Integer,College> collegeList = new HashMap<Integer,College>();
	
	
	public College(){
	}
	public College(String str){
		String lines[] = str.split("#");
		for(int index = 0; index < lines.length;index ++){
			String details[] = lines[index].split(",");
			College col = new College();
			col.setId( Integer.parseInt( details[0]));
			col.setSeatsAvailable(Integer.parseInt( details[2]));
			col.setName(details[1]);
			collegeList.put( Integer.parseInt(details[0]) ,col );
		}
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the seatsAvailable
	 */
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	/**
	 * @param seatsAvailable the seatsAvailable to set
	 */
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public HashMap<Integer,College> getColleges(){
		return collegeList;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
