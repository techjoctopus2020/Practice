package com.joctopus.containers;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.joctopus.model.HelloWorld;

public class HelloTest {

	public static void main(String[] args) {

		// creat an object and initialize container either beanfactory or
		// applicationContext

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		HelloWorld h = (HelloWorld) context.getBean("hello");

		System.out.println("Welcome to Joctopus SpringCourse :" + h.getName());
		
		// BeanFactory
		
		XmlBeanFactory factory = new XmlBeanFactory (new ClassPathResource("applicationContext.xml")); 
		
		HelloWorld h1 = (HelloWorld) context.getBean("hello");

		System.out.println("Welcome to Joctopus SpringCourse :" + h1.getName());

	}

}
