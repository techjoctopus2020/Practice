package com.Joctopus.Hib_Batch.Main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Joctopus.Hib_Batch.Entity.Employee;

public class EmpXmlTest {

	public static void main(String[] args) {

		// load hibernate.cfg.xml ibnto app

		Configuration config = new Configuration();
		SessionFactory sf = config.configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Employee emp = new Employee();

		// emp.setId(i);
		emp.setName("Madhu");
		emp.setRole("Developer");
		emp.setInsertTime(new Date()); // Transient
		
		
		session.save(emp);

		tx.commit();
		session.close();

	}

}
