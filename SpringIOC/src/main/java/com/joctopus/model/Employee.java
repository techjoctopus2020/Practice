package com.joctopus.model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Employee {

	private Integer id;
	private String name;
	private String salary;

	private Address add; // Depedency class

	private List<String> empList;
	private Set<String> empSet;

	private Map<String, String> empMap;

	// If employee can had muliple address

	private List<Address> addList;

	public Employee() {
		System.out.println("I am in Employee Default Constructor");
	}

	public Employee(Integer id, String name, String salary, Address add, List<String> empList, Set<String> empSet,
			Map<String, String> empMap, List<Address> addList) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.add = add;
		this.empList = empList;
		this.empSet = empSet;
		this.empMap = empMap;
		this.addList = addList;
	}

	public void show() {

		System.out.println(id + " " + name + " " + salary + " " + empList.toString());
		System.out.println("Set Values:" + empSet.toString());

		System.out.println("Address:" + add.toString());

		// iterate Map using for each loop

		Iterator<Entry<String, String>> itr = empMap.entrySet().iterator();

		while (itr.hasNext()) {

			Entry<String, String> entry = itr.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		// Iterate the List of Address

		Iterator<Address> itr1 = addList.iterator();

		while (itr1.hasNext()) {
			System.out.println("List of Employee Address:" + itr1.next());
		}

	}

}
