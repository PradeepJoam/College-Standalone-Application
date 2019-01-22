package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import db.Dbconnection;
import model.Dept;

public class Myworking {

	public static boolean storeDept(Dept dept) {
		// TODO Auto-generated method stub
		boolean status=false;
		try {
			Connection con=Dbconnection.getConnection();
			Statement st=con.createStatement();
			String verifyQry="select * from dept where deptName='"+ dept.getDeptName()+"' and deptHead='"+dept.getDeptHead()+"'";
			System.out.println("Check Data " +verifyQry);
			ResultSet rst=st.executeQuery(verifyQry);
			if(rst.next())
			{
				System.out.println("Data Duplicate");
				
			}
			else {
					String sql="insert into dept (deptId,deptName,deptHead)values(?,?,?)";
					PreparedStatement pst=con.prepareStatement(sql);
					System.out.println("Insert Query "+sql);
					pst.setString(1, dept.getDeptId());
					pst.setString(2, dept.getDeptName());
					pst.setString(3, dept.getDeptHead());
					int i=pst.executeUpdate();
					if(i>0)
					{
						status=true;
					}
				}
		} catch (Exception e) {
			System.out.println("Dept Store Exception "+e);
		}
		
		
		return status;
	}

	public static ResultSet viewDeptdetails(String tableName) {
		ResultSet rst = null;
		
		try {
			Connection con=Dbconnection.getConnection();
			Statement st=con.createStatement();
			String qry="select * from "+tableName+"";
			System.out.println("View Select Query " +qry);
			rst=st.executeQuery(qry);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("View Dept Exception "+e);
		}
		
		
		return rst;
	}

	public static boolean deleteData(Dept dept, String tableName) {
		boolean status=false;
		
		try {
			Connection con=Dbconnection.getConnection();
			Statement st=con.createStatement();
			String qry="delete from "+tableName+" where deptid='"+dept.getDeptId()+"'";
			System.out.println("Delete Query " +qry);
			int i=st.executeUpdate(qry);
			if(i>0)
			{
				status=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("View Dept Exception "+e);
		}
		return status;
	}

	public static boolean updateDatadept(Dept dept, String tableName, Scanner inputKeyword) {
		boolean status=false;
		
		try {
			Connection con=Dbconnection.getConnection();
			Statement st=con.createStatement();
			String qry="select * from "+tableName+" where deptid='"+dept.getDeptId()+"'";
			ResultSet rst=st.executeQuery(qry);
			if(rst.next())
			{
				
				System.out.println("Enter Dept Head Name");
				dept.setDeptHead(inputKeyword.next());
				String upQry="update dept set depthead=? where deptid=?";
				PreparedStatement pst=con.prepareStatement(upQry);
				pst.setString(1, dept.getDeptHead());
				pst.setString(2, dept.getDeptId());
				int i=pst.executeUpdate();
				if(i>0)
				{
					status=true;
				}
			}
			else
			{
				System.out.println("Invalid Dept Id ");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("View Dept Exception "+e);
		}
		return status;
	}

}
