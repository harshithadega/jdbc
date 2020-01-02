package com.deloitte.emp.applications;

import com.deloitte.emp.beans.Emp;
import com.deloitte.emp.dao.EmpDao;
import com.deloitte.emp.dao.impl.EmpDaoImpl;

public class DeleteRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpDao dao = new EmpDaoImpl();
		 dao.delEmp(7369);
		System.out.println("deleted");
	}

}
