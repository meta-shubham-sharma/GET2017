package com.metacube.queue;

public class Candidate {
	String rank , name ;
	String collegeName;
	int options[];
	
	public Candidate(){
	}
	/**
	 * read from file and add to queue
	 * @param str
	 * @param que
	 */
	public Candidate(String str, MyQueue que){
		String lines[] = str.split("#");
		for(int index = 0; index < lines.length;index ++){
			String details[] = lines[index].split(",");
			Candidate can = new Candidate();
			can.setRank(details[0]);
			can.setName(details[1]);
			que.enqueue(can);
		}
	}
	
	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}
	/**
	 * @param rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
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
	/**
	 * @return the collegeNames
	 */
	public String getCollegeName() {
		return collegeName;
	}

	/**
	 * @param collegeNames the collegeNames to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	/**
	 * @return the options
	 */
	public int[] getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(int[] options) {
		this.options = options;
	}

}
