package com.Joctopus.Hib_Batch.Mappings.oneToone.Main;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Joctopus.Hib_Batch.Mappings.oneToone.Entity.Bank_Tx;
import com.Joctopus.Hib_Batch.Mappings.oneToone.Entity.Customer;
import com.Joctopus.Hib_Batch.Utils.HibernateUtils;

public class OneToOneTest {

	private static void oneToOneDemo() {
		
		// Get the session or sessionfactory
		
				Session session = HibernateUtils.getSession();
				Transaction tx = session.beginTransaction();
				
				Bank_Tx btx = new Bank_Tx();
				
				btx.setTxtotalAmt(100000.00d);
				btx.setTxdate(new Date());
				
				Customer cust = new Customer();
				cust.setName("Hema");
				cust.setEmail("Hema@gmail.com");
				cust.setAddress("Prodatur");
				cust.setTxn(btx);
				btx.setCust(cust);
				
				session.save(btx);
				tx.commit();
				
				fetchCustomer(btx.getTxid(),session);
		
	}
	private static void fetchCustomer(long id, Session session) {
		
		Transaction tx = session.beginTransaction();
		Bank_Tx bank = session.load(Bank_Tx.class, id);
		tx.commit();
		System.out.println("*****************CUSTOMER TXN DETAILS ****************************");
		System.out.println(bank);
		
	}
	public static void main(String[] args) {
		
		oneToOneDemo();
		

	}



}
