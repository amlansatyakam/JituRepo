package com.amlan.dao;

import java.util.List;

import com.amlan.bo.EmployeeBO;

public interface EmployeeDAO {

	public List<EmployeeBO> fetchdata();
	public int insert(EmployeeBO bo);
	public int update(int eid,String newname);
}
