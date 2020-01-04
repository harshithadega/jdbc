package com.deloitte.emp.dao;
import java.sql.Date;
import java.util.List;

	import com.deloitte.emp.beans.Emp;

	public interface EmpDao {
		void openConnection();
		void close();
		int addEmp(Emp emp); 
		List<Emp> getEmpls();
		Emp getEmpByCode(int empcode);
	    void delEmp(int empcode);
	    void updEmp(double sal,int empcode);
	    int updAll(String ename,String job,int mgr,Date hiredate,double sal,double comm,int deptno,int empno);
	}

