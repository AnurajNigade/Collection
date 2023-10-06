package com.main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Employee{
	private int EmpId;
	private String name;
	private String Department;
	private double salary;
	
	public Employee(int empId, String name, String department, double salary) {
		super();
		EmpId = empId;
		this.name = name;
		Department = department;
		this.salary = salary;
	}
	
	public int getEmpId() {
		return EmpId;
	}


	public String getName() {
		return name;
	}

	public String getDepartment() {
		return Department;
	}


	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", name=" + name + ", Department=" + Department + ", salary=" + salary
				+ "]";
	}
	
	
	
}

public class CollectionDemo {
	public static void main(String[] args) {
		LinkedList<Employee> eList=new LinkedList<Employee>();
//		Scanner sc=new Scanner(System.in);
		int ch;
		do {
			System.out.println("Press 1 to add new empolyee detail :");
			System.out.println("Press 2 to delete empolyee detail :");
			System.out.println("Press 3 to show total salary of all employees in given department : ");
			System.out.println("Press 4 to find employee with highest salary from each department :");
			System.out.println("5. exit");
			System.out.println("Enter your choice");
			Scanner sc =new Scanner(System.in);
			ch=sc.nextInt();
			switch (ch) {
			case 1: 
				System.out.println("Enter Id of employee :");
				int id=sc.nextInt();
				System.out.println("Enter name of employee :");
				String str=sc.next();
	
				System.out.println("Enter department of employee :");
				String dep=sc.next();
				System.out.println("Enter salary of employee :");
				double salary=sc.nextDouble();
				eList.add(new Employee(id, str, dep, salary));
				
				break;
			
			case 2:
//				System.out.println(eList);
				for (Employee employee : eList) {
					System.out.println(employee);
				}
				System.out.println("Enter Id of employee you want remove :");
				int id1=sc.nextInt();
				boolean employeeFound = false;

				// Using Iterator to safely remove elements
				Iterator<Employee> iterator = eList.iterator();
				while (iterator.hasNext()) {
				    Employee employee = iterator.next();
				    
				    if (id1 == employee.getEmpId()) {
				        iterator.remove(); // Remove the employee
				        employeeFound = true;
				        break; // Exit the loop once found
				    }
				}

				if (employeeFound) {
				    System.out.println("Employee with ID " + id1 + " removed successfully.");
				} else {
				    System.out.println("Employee not found.");
				}
				
				break;
			
			case 3:
				System.out.println("Enter department you want to calculate total salary :");
				String depSalary=sc.next();
				double TotalSal=0;
				Iterator<Employee> iterator2=eList.iterator();
				while (iterator2.hasNext()) {
					Employee employee = (Employee) iterator2.next();
					
					if (depSalary.equalsIgnoreCase(employee.getDepartment())) {
						TotalSal+=employee.getSalary();
						
					}
				}
				System.out.println("Total salary of  "+depSalary+"  is "+TotalSal);
				
				break;
				
			case 4:
				System.out.println("Enter department in which you want to show highest salary employee: ");
				String str2=sc.next();
				double LowestSal=0;
				String Name="";
				Iterator<Employee> iterator3=eList.iterator();
				while (iterator3.hasNext()) {
					Employee employee = (Employee) iterator3.next();
					if (str2.equalsIgnoreCase(employee.getDepartment())) {
						
						if (LowestSal<employee.getSalary()) {
							LowestSal=employee.getSalary();
							Name=employee.getName();
						}
					}
					
				}
				System.out.println("Highest salary of  "+str2+"  is "+Name+" Salary is"+LowestSal);
				
			case 5:
				System.out.println("End !!!");
				break;
			default:
				break;
			}
			
		} while (ch!=5);
		
	}
}
