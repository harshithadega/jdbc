package com.deloitte.emp.applications;

	import com.deloitte.emp.beans.Emp;
	import com.deloitte.emp.dao.EmpDao;
	import com.deloitte.emp.dao.impl.EmpDaoImpl;

	public class EmpAppln {
		public static void main(String[] args) {
			Emp emp = new Emp(11,"aaa","job",45,"31-12-2019", 5000, 600, 30);
			EmpDao dao = new EmpDaoImpl();
			int rows = dao.addEmp(emp);
			if(rows>0)
				System.out.println("inserted");
			else
				System.out.println("not inserted");
		}
	}
