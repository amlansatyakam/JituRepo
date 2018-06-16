package com.amlan.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.amlan.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String FETCH_RECORD = "SELECT EID,FNAME,SALARY FROM EMPLOYEE";
	private static final String INSERT_DATA = "INSERT INTO EMPLOYEE (EID,FNAME,SALARY) VALUES (?,?,?)";
    private static final String UPDATE_DATA="UPDATE EMPLOYEE SET FNAME=? WHERE EID=?";
	private JdbcTemplate jt;

	public EmployeeDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public List<EmployeeBO> fetchdata() {
		List<EmployeeBO> limp = null;

		limp = jt.query(FETCH_RECORD, new MyResultsetExtractor());
		return limp;
	}

	@Override
	public int insert(EmployeeBO bo) {
		return jt.update(INSERT_DATA, bo.getEid(), bo.getFname(), bo.getSalary());

	}

	@Override
	public int update(int eid, String newname) {
		return jt.update(UPDATE_DATA, newname,eid);
	}
}
