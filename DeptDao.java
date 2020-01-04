package com.deloitte.dept.dao;

import java.util.List;

import com.deloitte.dept.beans.Dept;

public interface DeptDao {
	void openConnection();
	void close();
	int addDept(int deptno,String dname,String loc);
	int updAll(int deptno,String dname,String loc);
	List<Dept> getDept();
}