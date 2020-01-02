package com.deloitte.emp.applications;

import com.deloitte.emp.beans.Emp;
import com.deloitte.emp.dao.EmpDao;
import com.deloitte.emp.dao.impl.EmpDaoImpl;

public class GetEmplByCode {
	public static void main(String[] args) {
		EmpDao dao = new EmpDaoImpl();
		Emp e = dao.getEmpByCode(7876);
		System.out.println(e.getEmpno()+" "+e.getEname()+" "+e.getJob()+" "+
				e.getMgr()+" "+e.getHiredate()+" "+e.getSal()+" "+e.getComm()+" "+
				e.getDeptno());
	}

}

