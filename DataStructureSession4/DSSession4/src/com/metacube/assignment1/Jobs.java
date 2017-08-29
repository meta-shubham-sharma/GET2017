package com.metacube.assignment1;

@SuppressWarnings("rawtypes")
public class Jobs implements Comparable {

	private String designation;
	private int priority;
	private String message;
	private int seqNum;
	static int counter;

	/**
	 * @return the seqNum
	 */
	public int getSeqNum() {
		return seqNum;
	}

	/**
	 * @param seqNum
	 *            the seqNum to set
	 */
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
		counter++;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation
	 *            the designation to set
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
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
		setSeqNum(counter);
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param messsage
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int compareTo(Object arg0) {
		int priority1 = this.priority;
		int answer = 0;
		Jobs temp = (Jobs) arg0;
		int priority2 = temp.priority;
		if (priority1 != priority2) {
			if (priority1 > priority2) {
				answer = 1;
			} else {
				answer = -1;
			}
		} else {
			int seqNum1 = this.getSeqNum();
			int seqNum2 = temp.getSeqNum();
			if (seqNum1 < seqNum2) {
				answer = 1;
			} else {
				answer = -1;
			}
		}
		return answer;
	}

}
