package com.Joctopus.Hib_Batch.Mappings.ManyToMany.Main;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Joctopus.Hib_Batch.Mappings.ManyToMany.Entity.Course;
import com.Joctopus.Hib_Batch.Mappings.ManyToMany.Entity.Student;
import com.Joctopus.Hib_Batch.Utils.DateUtil;
import com.Joctopus.Hib_Batch.Utils.HibernateUtils;

public class ManyToManyTest {

	public static void main(String[] args) {

		// Get the session object

		Session session = HibernateUtils.getSession();

		Transaction tx = session.beginTransaction();

		HashSet<Course> courseSet = new HashSet<Course>();

		courseSet.add(new Course("Java", "90days"));
		courseSet.add(new Course("Selenium", "45days"));
		courseSet.add(new Course("AWS", "90days"));

		Student stu = new Student();
		stu.setName("Hema");
		stu.setFname("HemaFather");
		stu.setDob(DateUtil.convertStringToDate("7-Jun-1994"));

		stu.setCourseSet(courseSet);

		Student stu1 = new Student();
		stu1.setName("Ravali");
		stu1.setFname("RavaliFather");
		stu1.setDob(DateUtil.convertStringToDate("8-Jun-1994"));

		stu1.setCourseSet(courseSet);

		Student stu2 = new Student();
		stu2.setName("Madhu");
		stu2.setFname("MadhuFather");
		stu2.setDob(DateUtil.convertStringToDate("8-Jun-1994"));

		stu2.setCourseSet(courseSet);

		session.save(stu);
		session.save(stu1);
		session.save(stu2);
		tx.commit();
		session.close();

	}

}
