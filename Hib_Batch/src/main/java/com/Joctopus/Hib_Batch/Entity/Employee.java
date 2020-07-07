package com.Joctopus.Hib_Batch.Entity;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5313464189831415262L;
	
	
	private int id;
	private String name;
	private String role;
	private Date insertTime;

	public Employee() {

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", insertTime=" + insertTime + "]";
	}
	
	

}
