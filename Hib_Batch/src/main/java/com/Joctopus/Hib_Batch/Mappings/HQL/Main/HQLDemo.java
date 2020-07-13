package com.Joctopus.Hib_Batch.Mappings.HQL.Main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Joctopus.Hib_Batch.Mappings.HQL.Entity.EmployeeHql;
import com.Joctopus.Hib_Batch.Utils.HibernateUtils;

public class HQLDemo {

	private static String SELECT_ALL_EMP = "FROM EmployeeHql";

	private static String SELECT_EMP_BY_ID = "FROM EmployeeHql WHERE id= :id"; 
	
	private static String UPDATE_EMP_BY_ID = "update EmployeeHql set name= :name where id= :id";
	
	

	private static Query query = null;
	

	public static void main(String[] args) {

		// Get the session object

		Session session = HibernateUtils.getSession();

		// transaction

		Transaction tx = session.beginTransaction();

		// create query and get the all employees

		query = session.createQuery(SELECT_ALL_EMP);

		System.out.println("**********************SELECT_ALL_EMP**************************");

		List<EmployeeHql> empList = query.list();

		for (EmployeeHql emp : empList) {

			System.out.println(emp.getId() + "  " + emp.getName() + "  " + emp.getSalary() + "  "+ emp.getAddress().getCity() + "  " + emp.getAddress().getZipcode());

		}

		System.out.println("**********************SELECT_ALL_EMP END**************************");

		query = session.createQuery(SELECT_EMP_BY_ID);

		System.out.println("**********************SELECT_EMP_BY_ID**************************");

		query.setLong("id", 1);
		EmployeeHql emp = (EmployeeHql) query.uniqueResult();

		System.out.println(emp.getId() + "  " + emp.getName() + "  " + emp.getSalary() + "  "+ emp.getAddress().getCity() + "  " + emp.getAddress().getZipcode());

		System.out.println("**********************SELECT_EMP_BY_ID END**************************");
		
		//HQL Update Employee
				query = session.createQuery(UPDATE_EMP_BY_ID);
				query.setParameter("name", "Surendra");
				query.setLong("id", 4);
				int result = query.executeUpdate();
				System.out.println("Employee Update Status="+result);
				//session.flush();
				
		// Fetch the updated Record
				
				EmployeeHql emp1 = session.load(EmployeeHql.class, 4L);
				System.out.println(emp1.getId() + "  " + emp1.getName() + "  " + emp1.getSalary() + "  "+ emp1.getAddress().getCity() + "  " + emp1.getAddress().getZipcode());

	}

}
