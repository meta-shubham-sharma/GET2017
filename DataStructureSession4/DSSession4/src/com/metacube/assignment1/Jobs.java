package com.metacube.assignment1;

@SuppressWarnings("rawtypes")
public class Jobs implements Comparable{
	
	private String designation;
	private int priority;
	private String message;
	
	
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param messsage the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public int compareTo(Object arg0) {
		int priority1 = this.priority;
		int answer = 0;
		Jobs t = (Jobs)arg0;
		int priority2 = t.priority;
		if(priority1 > priority2){
			answer = 1;
		}else if(priority1 < priority2){
			answer = -1;
		}
		return answer;
	}

}
