package com.Joctopus.Hib_Batch.Mappings.oneToone.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "bank_tx")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="txn")
public class Bank_Tx {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tx_id")
	private long txid;
	@Column(name = "tx_date")
	private Date txdate;
	@Column(name = "tx_totamt")
	private double txtotalAmt;

	@OneToOne(mappedBy = "txn")
	@Cascade(value = CascadeType.SAVE_UPDATE)
	private Customer cust;

	public long getTxid() {
		return txid;
	}

	public Date getTxdate() {
		return txdate;
	}

	public double getTxtotalAmt() {
		return txtotalAmt;
	}

	public Customer getCust() {
		return cust;
	}

	public void setTxid(long txid) {
		this.txid = txid;
	}

	public void setTxdate(Date txdate) {
		this.txdate = txdate;
	}

	public void setTxtotalAmt(double txtotalAmt) {
		this.txtotalAmt = txtotalAmt;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	
	@Override
	public String toString(){
		return txid+", "+txtotalAmt+", "+cust.getName()+", "+cust.getEmail()+", "+cust.getAddress();
	}

}
