package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bean.Customer;
import com.bean.Plans;
import com.bean.TariffPlan;

public class CustomerDAO {

	public static final String JDBC_URL="jdbc:derby:C:\\Users\\2088497\\MyDB;create=true";
	public static final String USERNAME="test";
	public static final String PASSWORD="test";
	
	public Connection con=null;
	public ResultSet rs=null;
	
	public boolean registerCustomer(Customer customer){
		
		try{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con= DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			
			String insertQuery="insert into tbl_Customers values(?,?,?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(insertQuery);
			
			ps.setInt(1, customer.getCustomerId());
			ps.setString(2, customer.getCustomerName());
			ps.setString(3, customer.getCustomerAddress());
			ps.setString(4, customer.getCustomerEmail());
			ps.setInt(5, customer.getCustomerNumber());
			ps.setString(6, customer.getCustomerPassword());
			
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
	
	public double displayTotalAmount(Plans customerPlans) {
		
		double fee = 0;
		for(TariffPlan plan : customerPlans.getPlanNames()) {
			fee += plan.getTariffRate();
		}
		return fee;
	
	}
	
	public boolean deleteCustomer(Customer customer){
		
		try{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String deleteQuery = "DELETE FROM customer_table WHERE id=? AND ? <= DATE({fn TIMESTAMPADD(SQL_TSI_MONTH, -3, CURRENT_TIMESTAMP)})";
			PreparedStatement ps = con.prepareStatement(deleteQuery);
			
			ps.setInt(1, customer.getCustomerId());
			ps.setString(2, customer.getCustomerDate);
			
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
