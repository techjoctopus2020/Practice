package com.Joctopus.Hib_Batch.Mappings.ManyToMany.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "s_id")
	private Integer id;
	@Column(name = "s_name")
	private String name;
	@Temporal(TemporalType.DATE)
	@Column(name = "s_dob")
	private Date dob;
	@Column(name = "s_fname")
	private String fname;

	@ManyToMany
	@Cascade(value=CascadeType.SAVE_UPDATE)
	@JoinTable(name="student_course",joinColumns= {@JoinColumn(name="s_id")},inverseJoinColumns= {@JoinColumn(name="cou_id")})
	private Set<Course> courseSet;
	
	

	public Set<Course> getCourseSet() {
		return courseSet;
	}

	public void setCourseSet(Set<Course> courseSet) {
		this.courseSet = courseSet;
	}

	public Student() {

	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getDob() {
		return dob;
	}

	public String getFname() {
		return fname;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

}
