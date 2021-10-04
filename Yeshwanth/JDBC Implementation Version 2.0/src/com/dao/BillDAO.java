package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Bill;

public class BillDAO {
	
	public static final String JDBC_URL="jdbc:derby:C:\\Users\\2088497\\MyDB;create=true";
	public static final String USERNAME="test";
	public static final String PASSWORD="test";
	
	public Connection con=null;
	public ResultSet rs=null;
	
	public boolean createBill(Bill bill) {
		
		try{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con= DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			
			String insertQuery="insert into tbl_Bill values(?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(insertQuery);
			
			ps.setInt(1, bill.getBillId());
			ps.setInt(2, bill.getCustomerId());
			ps.setInt(3, bill.getMonth());
			ps.setDouble(4, bill.getFee());
			
			int count=ps.executeUpdate();
			
			if(count>0){
				return true;
			}
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println(e.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
	
	public double displayTotalAmount(Bill bill) {
		
		double fee = 0;
		try{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con= DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

			String selectQuery="select fee from tbl_Bill where customerId = ?";
			PreparedStatement ps= con.prepareStatement(selectQuery);
			
/*			ps.setInt(1, customerPlans.getCustomerId());
			ps.setInt(2, customerPlans.getCustomerId());
			ps.setInt(2, customerPlans.getCustomerId());
			ps.setInt(4, customerPlans.getCustomerId());*/
			ps.setInt(1, bill.getCustomerId());
			rs=ps.executeQuery();
			
			while(rs.next()) {
				fee += rs.getDouble("FEE");
			}
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println(e.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		return fee;
	
	}

}
