package com.Joctopus.Hib_Batch.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "employee", uniqueConstraints = { @UniqueConstraint(columnNames = { "e_id" }) })
public class Employee1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "e_id", nullable = false, unique = true, length = 11)
	private int id;
	@Column(name = "e_name", length = 20, nullable = true)
	private String name;
	@Column(name = "e_role", length = 20, nullable = true)
	private String role;
	@Column(name = "insert_Time", nullable = true)
	private Date insertTime;

	public Employee1() {

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
