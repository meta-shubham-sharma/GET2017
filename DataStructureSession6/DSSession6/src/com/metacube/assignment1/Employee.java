package com.metacube.assignment1;

@SuppressWarnings("rawtypes")
public class Employee implements Comparable {
	Integer id;
	String name, address;
	
	public Employee(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		Employee emp = (Employee) arg0;
		return this.getId().compareTo(emp.getId());
	}
}
