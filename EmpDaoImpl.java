package com.deloitte.emp.dao.impl;

	import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import com.deloitte.emp.beans.Emp;
	import com.deloitte.emp.dao.EmpDao;
	import com.deloitte.emp.utils.ConvertDate;
	import com.deloitte.emp.utils.EmpUtils;

	import oracle.jdbc.OracleDriver;
	public class EmpDaoImpl implements EmpDao {

		private Connection conn=null;
		private PreparedStatement pst;
		private ResultSet rs;
		@Override
		public void openConnection() {
			try {
				DriverManager.registerDriver(new OracleDriver());
				String url ="jdbc:oracle:thin:@localhost:1521:orcl";
				String user = "scott";
				String pass = "tiger";
				conn = DriverManager.getConnection(url, user, pass);
			} catch (SQLException e) {
			e.printStackTrace();
			}
		}
		@Override
		public void close() {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public int addEmp(Emp emp) {
			openConnection();
			int rows=0;
			try {
				pst = conn.prepareStatement(EmpUtils.insertqry);
				pst.setInt(1, emp.getEmpno());
				pst.setString(2, emp.getEname());
				pst.setString(3, emp.getJob());
				pst.setInt(4, emp.getMgr());
				pst.setDate(5, (Date) ConvertDate.parseDate(emp.getHiredate()));
				pst.setDouble(6, emp.getSal());
				pst.setDouble(7, emp.getComm());
				pst.setInt(8, emp.getDeptno());
				rows= pst.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				close();
			}
			return rows;
		}
		@Override
		public List<Emp> getEmpls() {
			openConnection();
			List<Emp> emplist = new ArrayList<Emp>();
			try {
				pst = conn.prepareStatement(EmpUtils.GETEMPLS);
				rs = pst.executeQuery();
				while(rs.next()){
					Emp emp = new Emp(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4),rs.getDate(5).toString(), rs.getDouble(6), 
						rs.getDouble(7), rs.getInt(8));
					emplist.add(emp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close();
			return emplist;
		}
		@Override
		public Emp getEmpByCode(int empcode) {
			openConnection();
			Emp emp = null;
			try {
				pst = conn.prepareStatement(EmpUtils.GETEMPlBYCODE);
				pst.setInt(1, empcode); 
				rs = pst.executeQuery();
				if(rs.next()){
					emp = new Emp(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4),rs.getDate(5).toString(), rs.getDouble(6), 
						rs.getDouble(7), rs.getInt(8));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close();
			return emp;
		}
		@Override
		public  void delEmp(int empcode) {
			openConnection();
			try {
				pst = conn.prepareStatement(EmpUtils.DELROW);
				pst.setInt(1, empcode); 
				rs = pst.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			close();
		}
		
			@Override
			public void updEmp(double sal, int empcode) {
				openConnection();
				
				try {
					pst = conn.prepareStatement(EmpUtils.UPDSAL);
					pst.setDouble(1,sal);
					pst.setInt(2,empcode);
					rs=pst.executeQuery();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				close();
		}
			@Override
			public  int updAll(String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno,
					int empno) {
				openConnection();
				int flag=0;
				try {
					pst=conn.prepareStatement(EmpUtils.UPDALL);
					pst.setString(1,ename);
					pst.setString(2, job);
					pst.setInt(3,mgr);
					pst.setDate(4,hiredate);
					pst.setDouble(5,sal);
					pst.setDouble(6,comm);
					pst.setInt(7,deptno);
					pst.setInt(8,empno);
					rs= pst.executeQuery();
					flag=pst.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				close();
				return flag;
			}
			
			
			}
				
			
			





