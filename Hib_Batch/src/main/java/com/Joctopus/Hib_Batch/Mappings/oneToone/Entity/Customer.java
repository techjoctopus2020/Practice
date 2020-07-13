package com.Joctopus.Hib_Batch.Mappings.oneToone.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "customer")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "txn")
public class Customer implements Serializable {

	@Id
	@GeneratedValue(generator = "gen")
	@Column(name = "tx_id", unique = true, nullable = false)
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = { @Parameter(name = "property", value = "txn") })

	private long id;
	@Column(name = "cust_name", unique = false, nullable = true)
	private String name;
	@Column(name = "cust_email", unique = false, nullable = true)
	private String email;
	@Column(name = "cust_add", unique = false, nullable = true)
	private String address;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Bank_Tx txn;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public Bank_Tx getTxn() {
		return txn;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTxn(Bank_Tx txn) {
		this.txn = txn;
	}

}
