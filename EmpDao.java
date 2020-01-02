package com.deloitte.emp.dao;
	import java.util.List;

	import com.deloitte.emp.beans.Emp;

	public interface EmpDao {
		void openConnection();
		void close();
		int addEmp(Emp emp); 
		List<Emp> getEmpls();
		Emp getEmpByCode(int empcode);
	    void delEmp(int empcode);
	    
	}

