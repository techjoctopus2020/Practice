package com.joctopus.containers;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.joctopus.model.Employee;

public class EmpTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Employee e = (Employee) context.getBean("emp");

		e.show();

		// BeanFactory

		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

		Employee e1 = (Employee) context.getBean("emp");

		e1.show();

	}

}
