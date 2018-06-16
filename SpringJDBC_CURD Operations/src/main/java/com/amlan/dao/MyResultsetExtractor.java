package com.amlan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.amlan.bo.EmployeeBO;

public class MyResultsetExtractor implements ResultSetExtractor<List<EmployeeBO>> {

	@Override
	public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<EmployeeBO> listBO=null;
		listBO=new ArrayList();
		
		while(rs.next()) {
			EmployeeBO bo= new EmployeeBO();
			bo.setEid(rs.getInt(1));
			bo.setFname(rs.getString(2));
			bo.setSalary(rs.getInt(3));
			listBO.add(bo);
		}
	
		return listBO;
	}

}
