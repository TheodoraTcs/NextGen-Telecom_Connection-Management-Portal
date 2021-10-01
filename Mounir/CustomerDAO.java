package com.ilp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO {
	
	public static final String EMPID = "2072273";
	public static final String URL = "jdbc:derby:C:\\Users\\" + EMPID + "\\MyDB;create=true";
	public static final String USERNAME = "test";
	public static final String PASSWORD = "test";
	
	public Connection con = null;
	public ResultSet rs = null;
	
	public boolean deleteCustomer(Customer customer){
		
		try{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String deleteQuery = "DELETE FROM customer_table WHERE id=? AND ? <= DATE({fn TIMESTAMPADD(SQL_TSI_MONTH, -3, CURRENT_TIMESTAMP)})";
			PreparedStatement ps = con.prepareStatement(deleteQuery);
			
			ps.setInt(1, customer.getId());
			ps.setString(2, customer.getDate);
			
			int count = ps.executeUpdate();
			
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
}
