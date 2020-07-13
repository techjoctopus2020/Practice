package com.Joctopus.Hib_Batch.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Joctopus.Hib_Batch.Entity.Employee;
import com.Joctopus.Hib_Batch.Utils.HibernateUtils;

public class PrimaryLevelCacheDemo {

		
		public static void main(String[] args) throws InterruptedException {
			
			SessionFactory sessionFactory = HibernateUtils.getAnnatationSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			
			//Get employee with id=1
			Employee emp = (Employee) session.load(Employee.class, 1);
			printData(emp,1);
			
			//waiting for sometime to change the data in backend
			Thread.sleep(10000);
			
			//Fetch same data again, check logs that no query fired
			Employee emp1 = (Employee) session.load(Employee.class, 1);
			printData(emp1,2);
			
			System.out.println("********************Creating NEwSession**********************************");

			//Create new session
			Session newSession = sessionFactory.openSession();
			//Get employee with id=1, notice the logs for query
			Employee emp2 = (Employee) newSession.load(Employee.class, 1);
			printData(emp2,3);
			
			System.out.println("***************************************************************************");
			
			
			//START: evict example to remove specific object from hibernate first level cache
			//Get employee with id=2, first time hence query in logs
			Employee emp3 = (Employee) session.load(Employee.class, 3);
			printData(emp3,4);
			
			System.out.println("****************************evict()***********************************************");
			//evict the employee object with id=1
			session.evict(emp);
			System.out.println("Session Contains Employee with id=1?"+session.contains(emp));

			//since object is removed from first level cache, you will see query in logs
			Employee emp4 = (Employee) session.load(Employee.class, 1);
			printData(emp4,5);
			
			System.out.println("****************************evict() END***********************************************");
			
			//this object is still present, so you won't see query in logs
			Employee emp5 = (Employee) session.load(Employee.class, 3);
			printData(emp5,6);
			//END: evict example
			
			//START: clear example to remove everything from first level cache
			session.clear();
			Employee emp6 = (Employee) session.load(Employee.class, 1);
			printData(emp6,7);
			Employee emp7 = (Employee) session.load(Employee.class, 3);
			printData(emp7,8);
			
			System.out.println("Session Contains Employee with id=2?"+session.contains(emp7));
			
			
			
			tx.commit();
			sessionFactory.close();
		}

		private static void printData(Employee emp, int count) {
			System.out.println(count+":: Name="+emp.getName()+", Time="+emp.getInsertTime());
		}

	}

