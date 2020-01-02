package com.deloitte.emp.applications;

import java.util.List;

import com.deloitte.emp.beans.Emp;
import com.deloitte.emp.dao.EmpDao;
import com.deloitte.emp.dao.impl.EmpDaoImpl;

public class ViewEmpls {
	public static void main(String[] args) {
		EmpDao dao = new EmpDaoImpl();
		List<Emp> empls = dao.getEmpls();
		for(Emp e : empls)
			System.out.println(e.getEmpno()+" "+e.getEname()+" "+e.getJob()+" "+
			e.getMgr()+" "+e.getHiredate()+" "+e.getSal()+" "+e.getComm()+" "+
			e.getDeptno());
	}

}

