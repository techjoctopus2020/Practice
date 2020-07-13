package com.Joctopus.Hib_Batch.Mappings.ManyToMany.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cou_id")
	private Integer id;
	@Column(name = "cou_name")
	private String name;
	@Column(name = "cou_duration")
	private String duration;

	public Course(String name, String duration) {
		this.name = name;
		this.duration = duration;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDuration() {
		return duration;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
