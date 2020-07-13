package com.Joctopus.Hib_Batch.Mappings.OneToMany.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name="cart")
public class Cart implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private long id;
	@Column(name="cart_total")
	private double total;
	@Column(name="cart_name")
	private String name;
	
	@OneToMany(mappedBy="cart")
	@Cascade(value=CascadeType.SAVE_UPDATE)
	private Set<Items> itemSet;

	public long getId() {
		return id;
	}

	public double getTotal() {
		return total;
	}

	public String getName() {
		return name;
	}

	public Set<Items> getItemSet() {
		return itemSet;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setItemSet(Set<Items> itemSet) {
		this.itemSet = itemSet;
	}
	
	

}
