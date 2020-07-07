package com.Joctopus.Hib_Batch.Main;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Joctopus.Hib_Batch.Entity.Employee;
import com.Joctopus.Hib_Batch.Entity.Employee1;
import com.Joctopus.Hib_Batch.Utils.HibernateUtils;

public class EmpAnnoatationTest {

	private static Session session = null;
	private static Transaction tx = null;

	/**
	 * save
	 * 
	 * @param emp
	 */
	private static void saveEmp(Employee1 emp) {

		session = HibernateUtils.getSession();

		tx = session.beginTransaction();

		Integer i = (Integer) session.save(emp);
		if (i > 0) {
			System.out.println("Record hasbeen Saved:" + i);

		}

		tx.commit();
		session.close();

	}

	/**
	 * persist
	 * 
	 * @param emp
	 */

	private static void persistEmp(Employee1 emp) {

		session = HibernateUtils.getSession();

		tx = session.beginTransaction();

		session.persist(emp);

		tx.commit();
		session.close();

	}

	/**
	 * saveOrUpdate
	 * 
	 * @param emp
	 */

	private static void saveOrUpdateEmp(Employee1 emp) {

		// Get the session object

		session = HibernateUtils.getSession();

		System.out.println("Contains:" + session.contains(emp));
		tx = session.beginTransaction();

		Employee dbEmp = session.load(Employee.class, 11);

		dbEmp.setName("Subramani");
		dbEmp.setRole("DevLead");

		session.saveOrUpdate(emp);
		session.flush();
		session.close();

	}

	/**
	 * load
	 * 
	 * @param emp
	 */

	private static void loadEmp() {

		// Get the session object

		session = HibernateUtils.getSession();
		tx = session.beginTransaction();

		Employee dbEmp = session.load(Employee.class, 5);
		System.out.println("Eb Record:" + dbEmp);

		dbEmp.setName("Ravali");
		dbEmp.setRole("FullStack");
		session.update(dbEmp);
		tx.commit();

		session.close();

	}

	/**
	 * get
	 * 
	 * @param emp
	 */

	private static void getEmp() {
		// Get the session object

		session = HibernateUtils.getSession();
		tx = session.beginTransaction();
		Employee dbEmp = session.get(Employee.class, 6);
		System.out.println("get(): db Record:" + dbEmp);
		session.close();

	}

	/**
	 * delete
	 * 
	 * @param emp
	 */

	private static void deleteEmp() {
		// Get the session object

		session = HibernateUtils.getSession();
		tx = session.beginTransaction();
		Employee dbEmp = session.get(Employee.class, new Integer(12));
		
		System.out.println("Delete Record:"+dbEmp);
		session.delete(dbEmp);
		tx.commit();
		session.close();

	}

	public static void main(String[] args) {
		Employee1 emp = new Employee1();

		emp.setName("Keerti");
		emp.setRole("Tester");
		emp.setInsertTime(new Date());

		// saveEmp(emp);
		// persistEmp(emp);
		//saveOrUpdateEmp(emp);

		// loadEmp();

		// getEmp();
		deleteEmp();

	}

}
