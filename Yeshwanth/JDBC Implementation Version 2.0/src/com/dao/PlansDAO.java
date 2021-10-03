package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bean.Customer;
import com.bean.Plans;
import com.bean.TariffPlan;

public class PlansDAO {
	
	public static final String JDBC_URL="jdbc:derby:C:\\Users\\2088497\\MyDB;create=true";
	public static final String USERNAME="test";
	public static final String PASSWORD="test";
	
	public Connection con=null;
	public ResultSet rs=null;
	
	public boolean enterDesiredPlans(Plans customerPlans, Customer customer) {
		
		String planNames = "";
		for(TariffPlan planName : customerPlans.getPlanNames()) {
			planNames += planName.getPlanName() + " ";
		}
		try{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con= DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			
			String insertQuery="insert into tbl_Plans values(?,?,?)";
			PreparedStatement ps= con.prepareStatement(insertQuery);
			
			ps.setString(1, planNames);
			ps.setInt(2, customer.getCustomerId());
			ps.setDate(3, java.sql.Date.valueOf(customerPlans.getDateOfStart()));
			
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
}
