package com.amlan.test;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

import com.amlan.bindings.Employee;

public class EmployeeDetailsClient {

	public static void main(String[] args) {
		int id=0;
		Scanner scn= new Scanner(System.in);
		System.out.print("Enter Employee Id: ");
		id=scn.nextInt();
		
		ApplicationContext ctx= new ClassPathXmlApplicationContext("com/amlan/config/applicationContext.xml");
		RestTemplate rt= ctx.getBean("rt",RestTemplate.class);
		//Employee emp=rt.//getForObject("http://dummy.restapiexample.com/api/v1/employee/"+id);
		//System.out.println(emp);
		System.out.println(rt.getForObject("http://dummy.restapiexample.com/api/v1/employee/"+id, String.class));
		scn.close();
	}

}
