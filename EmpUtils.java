package com.deloitte.emp.utils;

public class EmpUtils {
	public static String insertqry="insert into emp values(?,?,?,?,?,?,?,?)";
	public static final String GETEMPLS = "select * from emp";
	public static final String GETEMPlBYCODE = "select * from emp where empno=?";
	public static final String DELROW = "delete from emp where empno =?";
	public static final String UPDSAL="update emp set sal=? where empno =?";
	public static final String UPDALL="update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
	
}
