package com.amlan.maincontroler;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amlan.bo.EmployeeBO;
import com.amlan.dao.EmployeeDAO;

public class MyController {

	public static void main(String[] args) {
		EmployeeDAO dao=null;
		List<EmployeeBO> listBO=null;
		EmployeeBO bo=null;
		int count=0;
		
		ApplicationContext ctx= new ClassPathXmlApplicationContext("com/amlan/cfgs/applicationContext.xml");
		dao= ctx.getBean("empDAO", EmployeeDAO.class);
		//invoke method
		//listBO=dao.fetchdata();
		//listBO.forEach(System.out::println);
		
		/*bo=new EmployeeBO();
		bo.setEid(110);
		bo.setFname("NATARAZ");
		bo.setSalary(100000);
		count=dao.insert(bo);
		if(count==0)System.out.println("Record not inserted");
		else System.out.println("Record inserted"); 
*/
		count=dao.update(110, "HK");
		if(count==0)System.out.println("Record not Updated");
		else System.out.println("Record Updated"); 

		
		
		
		
		
		
		
		
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
